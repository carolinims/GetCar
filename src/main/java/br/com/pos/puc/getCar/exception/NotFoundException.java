package br.com.pos.puc.getCar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param exception
	 * @param exception1
	 */
	public NotFoundException(String exception, String detalhes) {
		super(exception);
		this.detalhes = detalhes;
	}

	private String detalhes;

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
