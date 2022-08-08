package br.com.pos.puc.getCar.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pos.puc.getCar.controller.dto.ClienteDto;
import br.com.pos.puc.getCar.controller.dto.VeiculoDto;
import br.com.pos.puc.getCar.controller.form.VeiculoForm;
import br.com.pos.puc.getCar.domain.AgenciaAutomotiva;
import br.com.pos.puc.getCar.domain.Modelo;
import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;
import br.com.pos.puc.getCar.domain.enums.Marcas;
import br.com.pos.puc.getCar.domain.enums.TipoCombustivel;
import br.com.pos.puc.getCar.domain.enums.TipoMotorizacao;
import br.com.pos.puc.getCar.exception.NotFoundException;
import br.com.pos.puc.getCar.repository.AgenciaAutomotivaRepository;
import br.com.pos.puc.getCar.repository.ModeloRepository;
import br.com.pos.puc.getCar.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	private final static Logger logger = Logger.getLogger(VeiculoController.class);
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private AgenciaAutomotivaRepository agAutomotivaRepository;
	
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder){
		Veiculo veiculo = veiculoForm.converter();
		
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
		
		Optional<AgenciaAutomotiva> agAutomotivaFromBd = agAutomotivaRepository.findById(veiculoForm.getAgAutomotiva().getIdAgenciaAuto() == null 
				? 0 
				: veiculoForm.getAgAutomotiva().getIdAgenciaAuto());
		if(agAutomotivaFromBd.isPresent()) {
			veiculo.setAgAutomotiva(agAutomotivaFromBd.get());
		} else {
			logger.error(String.format("Falha ao cadastrar veiculo - agencia automotiva [%s] não encontrada, o id da agencia não foi informado ou é invalido",
					veiculoForm.getAgAutomotiva().getIdAgenciaAuto()));
			
			throw new NotFoundException(String.format("Agencia automotiva [%s] não encontrada", veiculoForm.getAgAutomotiva().getIdAgenciaAuto()), 
					"O id do agencia automotiva não foi informado ou é invalido");
		}
		
		// verificar se placa e renavam já existem, se existir retorna erro 
		// construir corretamente os DTOs para veiculo
		// lembrar de criar endpoint para associar veiculo ao grupo
		
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
				
	}

}
