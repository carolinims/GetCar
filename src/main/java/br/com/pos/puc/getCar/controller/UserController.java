package br.com.pos.puc.getCar.controller;

import java.net.URI;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pos.puc.getCar.controller.dto.ClienteDto;
import br.com.pos.puc.getCar.controller.dto.UserDto;
import br.com.pos.puc.getCar.controller.form.ClienteForm;
import br.com.pos.puc.getCar.controller.form.UsuarioForm;
import br.com.pos.puc.getCar.domain.Cliente;
import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.Usuario;
import br.com.pos.puc.getCar.repository.ClienteRepository;
import br.com.pos.puc.getCar.repository.PerfilRepository;
import br.com.pos.puc.getCar.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
		
	@PostMapping
	@Transactional
	public ResponseEntity<UserDto> cadastrarUsuario(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.converter();
		userRepository.save(usuario);
		
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		
		return ResponseEntity.created(uri).body(new UserDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> consultarUsuario(@PathVariable Long id){
		Optional<Usuario> usuario = userRepository.findById(id);
		
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new UserDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping()
	public ResponseEntity<List<UserDto>> listarUsuarios(){
		List<Usuario> listUsuario = userRepository.findAll();
		
		if(!listUsuario.isEmpty()) {
			List<UserDto> listUserDto = new ArrayList<UserDto>();
			listUsuario.stream().forEach(usuario -> {
				listUserDto.add(new UserDto(usuario));
			});
			
			return ResponseEntity.ok(listUserDto);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id){
		Optional<Usuario> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			userRepository.delete(optional.get());
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrarCliente")
	@Transactional
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder){	
		Cliente cliente = form.converter();
		
		List<Perfil> perfilFromBd = new ArrayList<>();
		for(Perfil perfil : cliente.getPerfis()) {
			Optional<Perfil> optPerfil = perfilRepository.findById(perfil.getId());
			if(optPerfil.isPresent()) {
				perfilFromBd.add(optPerfil.get());
			}
		}
		cliente.setPerfis(perfilFromBd.isEmpty()? cliente.getPerfis() : perfilFromBd);
		
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(cliente.getIdUsuario()).toUri();
		
		Date teste = new Date();
		System.out.println("AQUI" + teste);
		
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@GetMapping("/consultarCliente/{id}")
	public ResponseEntity<ClienteDto> consultarCliente(@PathVariable Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		
		return ResponseEntity.notFound().build();
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
		
		return ResponseEntity.notFound().build();
	}

}
