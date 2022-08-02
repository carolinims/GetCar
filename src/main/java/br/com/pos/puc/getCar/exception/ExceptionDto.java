package br.com.pos.puc.getCar.exception;

import java.io.Serializable;

public class ExceptionDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	private String detalheMensagem;
	
	/**
	 * @param mensagem
	 * @param detalheMensagem
	 */
	public ExceptionDto(String mensagem, String detalheMensagem) {
		super();
		this.mensagem = mensagem;
		this.detalheMensagem = detalheMensagem;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @return the detalheMensagem
	 */
	public String getDetalheMensagem() {
		return detalheMensagem;
	}
}
