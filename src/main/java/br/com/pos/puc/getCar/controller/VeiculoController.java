package br.com.pos.puc.getCar.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pos.puc.getCar.controller.dto.GrupoVeiculoDto;
import br.com.pos.puc.getCar.controller.dto.ModeloDto;
import br.com.pos.puc.getCar.controller.dto.VeiculoDto;
import br.com.pos.puc.getCar.controller.form.GrupoVeiculoForm;
import br.com.pos.puc.getCar.controller.form.VeiculoForm;
import br.com.pos.puc.getCar.domain.GrupoDeVeiculos;
import br.com.pos.puc.getCar.domain.Modelo;
import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.exception.BusinessException;
import br.com.pos.puc.getCar.exception.NotFoundException;
import br.com.pos.puc.getCar.repository.AgenciaAutomotivaRepository;
import br.com.pos.puc.getCar.repository.GrupoDeVeiculosRepository;
import br.com.pos.puc.getCar.repository.ModeloRepository;
import br.com.pos.puc.getCar.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
@CrossOrigin(origins = "http://localhost:3000")
public class VeiculoController {
	
	private final static Logger logger = Logger.getLogger(VeiculoController.class);
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private AgenciaAutomotivaRepository agAutomotivaRepository;
	
	@Autowired
	private GrupoDeVeiculosRepository gruVeiculosRepository;
		
	@PutMapping("/editar")
	@Transactional
	public ResponseEntity<?> editar(@RequestBody VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder) {
		
		// consulta para saber se veículo já existe na base, pois se não existe não é possivel editar
		Optional<Veiculo> veiculoFromBd = (veiculoRepository.findById(veiculoForm.getIdVeiculo()));
		if(!veiculoFromBd.isPresent()) {
			// veiculo já existe, retornar erro
			throw new BusinessException(String.format("Veiculo de id [%s] não pode ser editado pois não consta no sistema!", veiculoForm.getIdVeiculo()), 
					null);
		}
		
		// consulta para saber se a nova placa informada já existe na base
		Optional<Veiculo> veiculoByPlaca = Optional.ofNullable(veiculoRepository.findByPlacaVeiculo(veiculoForm.getPlacaVeiculo()));
		if(veiculoForm != null && veiculoByPlaca.isPresent()) {
			// veiculo já existe, retornar erro
			throw new BusinessException(String.format("Erro ao alterar placa, já consta no sistema veículo associado a placa [%s]!", veiculoForm.getPlacaVeiculo()), 
					null);
		}
		
		Veiculo veiculo = veiculoForm.converter();
		
		Optional<Modelo> modeloFromBd =  modeloRepository.findById(veiculoForm.getModelo().getIdModelo() == null 
				? 0 
				: veiculoForm.getModelo().getIdModelo());
		if(modeloFromBd.isPresent()) {
			veiculo.setModelo(modeloFromBd.get());
		} else {
			logger.error(String.format("Falha ao editar dados do veiculo - modelo de veiculo [%s] não encontrado, o id do modelo não foi informado ou é invalido",
					veiculoForm.getModelo().getIdModelo()));
			
			throw new NotFoundException(String.format("Modelo de veiculo [%s] não encontrado", veiculoForm.getModelo().getIdModelo()), 
					"O id do  modelo não foi informado ou é invalido");
		}
		
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
				
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder){
		Veiculo veiculo = veiculoForm.converter();
		
		// consulta para saber se veículo já existe na base
		Optional<Veiculo> veiculoFromBd = Optional.ofNullable(veiculoRepository.findByPlacaVeiculo(veiculoForm.getPlacaVeiculo()));
		if(veiculoForm != null && veiculoFromBd.isPresent()) {
			// veiculo já existe, retornar erro
			throw new BusinessException(String.format("Veiculo de placa [%s] já consta no sistema!", veiculoForm.getPlacaVeiculo()), 
					null);
		}
		
		Optional<Modelo> modeloFromBd =  modeloRepository.findById(veiculoForm.getModelo().getIdModelo() == null 
				? 0 
				: veiculoForm.getModelo().getIdModelo());
		if(modeloFromBd.isPresent()) {
			veiculo.setModelo(modeloFromBd.get());
		} else {
			logger.error(String.format("Falha ao cadastrar veiculo - modelo de veiculo [%s] não encontrado, o id do modelo não foi informado ou é invalido",
					veiculoForm.getModelo().getIdModelo()));
			
			throw new NotFoundException(String.format("Modelo de veiculo [%s] não encontrado", veiculoForm.getModelo().getIdModelo()), 
					"O id do  modelo não foi informado ou é invalido");
		}
		
		// PARA FAZER A PARTE DA AGENCIA AUTOMOTIVA FUNCIONAR FAREMOS IGUAL FOI FEITO PARA GRUPO DE VEICULOS
		// O RELACIONAMENTO FICARA COM A AGENCIA AUTOMOTIVA, PRIMEIRO O VEICULO SERÁ CADASTRADO, DEPOIS SERÁ ASSOCIADO A UMA 
		// AGENCIA AUTOMOTIVA, A AGENCIA TERA INFORMAÇÃO DE QUAIS SÃO SEUS VEICULOS, MAS O VEICULO NÃO TERA INFORMAÇÃO DE QUAL 
		// A SUA AGENCIA, FAREMOS ISSO PARA RESOLVER STACKOVERFLOW POR REFERENCIA CICLICA.
		// 	ESSA VERIFICAÇÃO SERÁ DESCONTINUADA OU IRÁ MUDAR DE LUGAR 
//		Optional<AgenciaAutomotiva> agAutomotivaFromBd = agAutomotivaRepository.findById(veiculoForm.getAgAutomotiva().getIdAgenciaAuto() == null 
//				? 0 
//				: veiculoForm.getAgAutomotiva().getIdAgenciaAuto());
//		if(agAutomotivaFromBd.isPresent()) {
//			veiculo.setAgAutomotiva(agAutomotivaFromBd.get());
//		} else {
//			logger.error(String.format("Falha ao cadastrar veiculo - agencia automotiva [%s] não encontrada, o id da agencia não foi informado ou é invalido",
//					veiculoForm.getAgAutomotiva().getIdAgenciaAuto()));
//			
//			throw new NotFoundException(String.format("Agencia automotiva [%s] não encontrada", veiculoForm.getAgAutomotiva().getIdAgenciaAuto()), 
//					"O id do agencia automotiva não foi informado ou é invalido");
//		}
		
		
		// verificar se placa e renavam já existem, se existir retorna erro 
		// lembrar de criar endpoint para associar veiculo ao grupo
		
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
				
	}

	@GetMapping("/consultar/{id}")
	public ResponseEntity<VeiculoDto> consultarCliente(@PathVariable Long id){
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		
		if(veiculo.isPresent()) {
			return ResponseEntity.ok(new VeiculoDto(veiculo.get()));
		}
		
		throw new NotFoundException(String.format("Veiculo de id [%s] não encontrado", id), null);
	}
	
	@GetMapping("/listarVeiculos")
	public Page<VeiculoDto> lista(@RequestParam(required = false) String marca, 
			@PageableDefault(sort = "idVeiculo", direction = Direction.DESC, size = 150) Pageable paginacao){
				
		if(marca == null) {
			Page<Veiculo> veiculos = veiculoRepository.findAll(paginacao);
			return VeiculoDto.converter(veiculos);
		} else {
			Page<Veiculo> veiculos = veiculoRepository.findByModeloMarca(marca, paginacao);
			return VeiculoDto.converter(veiculos);
		}	
	}
	
	@DeleteMapping("/excluir/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id){
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if(optional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listaModeloVeiculos")
	public ResponseEntity<List<ModeloDto>> lista(){
				
		List<Modelo> listaModelo;
		listaModelo = modeloRepository.findAll();
				
		if(!listaModelo.isEmpty()) {
			List<ModeloDto> listModeloDto = new ArrayList<ModeloDto>();
			listaModelo.stream().forEach(modelo -> {
				listModeloDto.add(new ModeloDto(modelo));
			});
			
			return ResponseEntity.ok(listModeloDto);
		}
		
		throw new NotFoundException(String.format("Nenhum modelo encontrado"), "a lista de modelos está vazia");
	}	
	
	@GetMapping("/listarGruposVeiculo")
	public ResponseEntity<List<GrupoVeiculoDto>> listarGrupos(){
		List<GrupoDeVeiculos> listGrupos = gruVeiculosRepository.findAll();
		
		if(!listGrupos.isEmpty()) {
			List<GrupoVeiculoDto> listGruVeiculoDto = listGrupos
					.stream()
					.map(gru -> (GrupoVeiculoDto) new GrupoVeiculoDto(gru))
					.collect(Collectors.toList());
			return ResponseEntity.ok(listGruVeiculoDto);
		}
		
		throw new NotFoundException(String.format("Nenhum grupo de veiculos encontrado"), "a lista de grupos está vazia");
	}
	
	
	@PostMapping("/cadastrarGrupo")
	@Transactional
	public ResponseEntity<?> cadastrarGrupo(@RequestBody GrupoVeiculoForm grupoVeiculoForm, UriComponentsBuilder uriBuilder) {
		GrupoDeVeiculos gruVeiculos = grupoVeiculoForm.converter();
		
		// consulta para saber se  possiveis veiculos da lista constam na base de dados
		if(grupoVeiculoForm.getListaVeiculos() != null && !grupoVeiculoForm.getListaVeiculos().isEmpty()) {
			List<Long> listIdVeiculos = grupoVeiculoForm.getListaVeiculos().stream().map(v -> (Long) v.getIdVeiculo()).collect(Collectors.toList());
			
			Optional<List<Veiculo>> veiculosFromBd = Optional.ofNullable(veiculoRepository.findAllById(listIdVeiculos));
			if(veiculosFromBd.isPresent()) {
				// veiculos retornaram da base, caso seja informado id de veiculos inexistente simplesmente não vai retornar nessa lista
				// e não sera cadastrado
				gruVeiculos.getListVeiculo().clear();
				gruVeiculos.setListVeiculo(veiculosFromBd.get().stream().collect(Collectors.toSet()));
			}
		}
		
		gruVeiculosRepository.save(gruVeiculos);
		
		URI uri = uriBuilder.path("/veiculo/consultarGrupo/{id}").buildAndExpand(gruVeiculos.getIdGrupoVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new GrupoVeiculoDto(gruVeiculos));
		
	}
	
	@DeleteMapping("/excluirGrupo/{id}")
	@Transactional
	public ResponseEntity<?> excluirGrupo(@PathVariable Long id){
		Optional<GrupoDeVeiculos> optional = gruVeiculosRepository.findById(id);
		if(optional.isPresent()) {
			gruVeiculosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		throw new NotFoundException(String.format("Grupo de id [%s] não encontrado", id), "Não foi possivel excluir pois o grupo não existe");
	}
	
	@GetMapping("/consultarGrupo/{id}")
	public ResponseEntity<GrupoVeiculoDto> consultarGrupo(@PathVariable Long id){
		Optional<GrupoDeVeiculos> gruVeiculo = gruVeiculosRepository.findById(id);
		
		if(gruVeiculo.isPresent()) {
			return ResponseEntity.ok(new GrupoVeiculoDto(gruVeiculo.get()));
		}
		
		throw new NotFoundException(String.format("Grupo de id [%s] não encontrado", id), null);
	}
	
	@PutMapping("/adicionarVeiculoGrupo")
	@Transactional
	public ResponseEntity<?> adicionarVeiculoGrupo(@RequestParam Long idVeiculo, @RequestParam Long idGrupo, UriComponentsBuilder uriBuilder) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(idVeiculo);
		if(!veiculo.isPresent()) {
			throw new NotFoundException(String.format("Veiculo de id [%s] não encontrado", idVeiculo), "Falha ao cadastrar veículo no grupo");
		}
		
		Optional<GrupoDeVeiculos> gruVeiculo = gruVeiculosRepository.findById(idGrupo);
		if(!gruVeiculo.isPresent()) {
			throw new NotFoundException(String.format("Grupo de id [%s] não encontrado", idGrupo), "Falha ao cadastrar veículo no grupo");
		}
		
		gruVeiculo.get().getListVeiculo().add(veiculo.get());
		
		gruVeiculosRepository.save(gruVeiculo.get());
		
		URI uri = uriBuilder.path("/consultarGrupo/{id}").buildAndExpand(gruVeiculo.get().getIdGrupoVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new GrupoVeiculoDto(gruVeiculo.get()));	
	}
	
	@PutMapping("/removerVeiculoGrupo")
	@Transactional
	public ResponseEntity<?> removerVeiculoGrupo(@RequestParam Long idVeiculo, @RequestParam Long idGrupo, UriComponentsBuilder uriBuilder) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(idVeiculo);
		if(!veiculo.isPresent()) {
			throw new NotFoundException(String.format("Veiculo de id [%s] não encontrado", idVeiculo), "Falha ao remover veículo do grupo");
		}
		
		Optional<GrupoDeVeiculos> gruVeiculo = gruVeiculosRepository.findById(idGrupo);
		if(!gruVeiculo.isPresent()) {
			throw new NotFoundException(String.format("Grupo de id [%s] não encontrado", idGrupo), "Falha ao remover veículo do grupo");
		}
		
		gruVeiculo.get().getListVeiculo().remove(veiculo.get());
		
		gruVeiculosRepository.save(gruVeiculo.get());
		
		URI uri = uriBuilder.path("/consultarGrupo/{id}").buildAndExpand(gruVeiculo.get().getIdGrupoVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new GrupoVeiculoDto(gruVeiculo.get()));	
	}
	
}
