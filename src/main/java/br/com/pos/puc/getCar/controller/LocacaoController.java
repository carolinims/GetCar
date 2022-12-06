package br.com.pos.puc.getCar.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pos.puc.getCar.controller.dto.VeiculoDto;

@RestController
@RequestMapping("/locacao")
@CrossOrigin(origins = "http://localhost:3000")
public class LocacaoController {
	
	private final static Logger logger = Logger.getLogger(LocacaoController.class);
	
	@GetMapping("/buscaVeiPorPeriodo")
	public List<VeiculoDto> buscaVeiculoPorPeriodo(@RequestParam String dtHoraRetirada, @RequestParam String dtHoraDevolucao) {
		LocalTime dtHrRetirada = LocalTime.parse(dtHoraRetirada);
		
		System.out.println(dtHrRetirada.toString());
		return null;
		
	}
}
