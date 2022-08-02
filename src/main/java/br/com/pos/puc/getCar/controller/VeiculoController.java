package br.com.pos.puc.getCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pos.puc.getCar.repository.VeiculoRepository;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	

}
