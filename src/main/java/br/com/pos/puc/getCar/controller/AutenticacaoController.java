package br.com.pos.puc.getCar.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pos.puc.getCar.config.security.TokenService;
import br.com.pos.puc.getCar.controller.dto.TokenDto;
import br.com.pos.puc.getCar.controller.form.LoginForm;
import br.com.pos.puc.getCar.exception.NotFoundException;

@RestController
@RequestMapping("/autentic")
public class AutenticacaoController {
	
	private final static Logger logger = Logger.getLogger(AutenticacaoController.class);
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			
			logger.info(String.format("Usuario [%s] autenticado com sucesso", form.getLogin()));
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
			
		} catch (AuthenticationException e) {
			logger.error(String.format("Falha de autenticação do usuario [%s] - [%s]", form.getLogin(), e.getMessage()));
			throw new NotFoundException(String.format("Usuario ou senha invalidos"), null);
		}
	}
	
}
