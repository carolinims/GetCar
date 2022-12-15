package br.com.pos.puc.getCar.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pos.puc.getCar.controller.dto.ClienteDto;
import br.com.pos.puc.getCar.controller.dto.UsuarioDto;
import br.com.pos.puc.getCar.controller.form.ClienteForm;
import br.com.pos.puc.getCar.controller.form.UsuarioForm;
import br.com.pos.puc.getCar.domain.Cliente;
import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.Usuario;
import br.com.pos.puc.getCar.domain.enums.TipoUsuario;
import br.com.pos.puc.getCar.exception.BusinessException;
import br.com.pos.puc.getCar.exception.NotFoundException;
import br.com.pos.puc.getCar.repository.ClienteRepository;
import br.com.pos.puc.getCar.repository.PerfilRepository;
import br.com.pos.puc.getCar.repository.UsuarioRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
		
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.converter();
		
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		usuario.setSenha(enconder.encode(usuario.getSenha()));
		
		Optional<Usuario> usuarioByLogin = userRepository.findByLogin(usuario.getLogin());
		if(usuarioByLogin.isPresent()) {
			// usuario já existe, retornar erro
			throw new BusinessException(String.format("Login [%s] já consta no sistema!", usuario.getLogin()),
					null);
		}
		
		// ANTES DE SALVAR O USUARIO VERIFICAR SE O LOGIN DELE JÁ EXISTE NO SISTEMA!!!!!!!!
		userRepository.save(usuario);
		
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> consultarUsuario(@PathVariable Long id){
		Optional<Usuario> usuario = userRepository.findById(id);
		
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(usuario.get()));
		}
		
		throw new NotFoundException(String.format("Usuario de id [%s] não encontrado", id), null);
	}
	
	@GetMapping()
	public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
		List<Usuario> listUsuario = userRepository.findAll();
		
//		List<Usuario> listUsuario = userRepository.listaUsuariosNaoCliente(TipoUsuario.CLIENTE.toString());
		
		if(!listUsuario.isEmpty()) {
			List<UsuarioDto> listUserDto = new ArrayList<UsuarioDto>();
			listUsuario.stream().forEach(usuario -> {
				if(usuario.getPerfis().get(0).getTipoUsuario() != TipoUsuario.CLIENTE) {
					listUserDto.add(new UsuarioDto(usuario));
				}
			});
			
			return ResponseEntity.ok(listUserDto);
		}
		
		throw new NotFoundException(String.format("Nenhum usuario encontrado"), "a lista de usuarios está vazia");
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id){
		Optional<Usuario> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			userRepository.delete(optional.get());
			return ResponseEntity.ok().build();
		}
		
		throw new NotFoundException(String.format("Erro ao excluir usuario de id [%s]", id), null);
	}
	
	@PostMapping("/cadastrarCliente")
	@Transactional
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder){	
		Cliente cliente = form.converter();
		
		// ANTES DE SALVAR O USUARIO, CASO TENHA SIDO INFORMADO LOGIN, VERIFICAR SE O LOGIN DELE JÁ EXISTE NO SISTEMA!!!!!!!!
		if(cliente.getLogin() != null && !cliente.getLogin().isEmpty()) {
			Optional<Cliente> clienteByLogin = Optional.ofNullable(clienteRepository.findByLogin(cliente.getLogin()));
			if(clienteByLogin.isPresent()) {
				// cliente já existe, retornar erro
				throw new BusinessException(String.format("Login [%s] já consta no sistema!", cliente.getLogin()),
						null);
			}
		} 
		
		//verificar se o documento já existe
		Optional<Cliente> clienteByDocumento = Optional.ofNullable(clienteRepository.findByDocumento(cliente.getDocumento())); 
		if(clienteByDocumento.isPresent()) {
			// cliente já existe, retornar erro
			throw new BusinessException(String.format("Cliente com CPF [%s] já consta no sistema!", cliente.getDocumento()), 
					null);
		}
		
		// SÓ RELACIONA PERFIL SE CADASTRO DE CLIENTE FOR FEITO COM LOGIN DE USUARIO
		if(cliente.getLogin() != null && !cliente.getLogin().isEmpty()) {
			List<Perfil> perfilFromBd = new ArrayList<>();
			for(Perfil perfil : cliente.getPerfis()) {
				Optional<Perfil> optPerfil = perfilRepository.findById(perfil.getId());
				if(optPerfil.isPresent()) {
					perfilFromBd.add(optPerfil.get());
				}
			}
			cliente.setPerfis(perfilFromBd.isEmpty()? cliente.getPerfis() : perfilFromBd);
		}
		
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(cliente.getIdUsuario()).toUri();
		
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@GetMapping("/consultarCliente/{id}")
	public ResponseEntity<ClienteDto> consultarCliente(@PathVariable Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		
		throw new NotFoundException(String.format("Cliente de id [%s] não encontrado", id), null);
	}
	
	@GetMapping("/listarCliente")
	public ResponseEntity<List<ClienteDto>> listarCliente(){
		List<Cliente> listCliente = clienteRepository.findAll();
		
		if(!listCliente.isEmpty()) {
			List<ClienteDto> listClienteDto = new ArrayList<ClienteDto>();
			listCliente.stream().forEach(cliente -> {
				listClienteDto.add(new ClienteDto(cliente));
			});
			
			return ResponseEntity.ok(listClienteDto);
		}
		
		throw new NotFoundException(String.format("Nenhum cliente encontrado"), "a lista de clientes está vazia");
	}

}
