package br.com.pos.puc.getCar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Trata exceptions de regra de negocio
 */
@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String detalhes;
	
	public BusinessException(String exception, String detalhes) {
		super(exception);
		this.detalhes = detalhes;
	}

	/**
	 * @return the detalhes
	 */
	public String getDetalhes() {
		return detalhes;
	}

	/**
	 * @param detalhes the detalhes to set
	 */
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
}
