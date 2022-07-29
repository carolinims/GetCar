package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusLocacao {
	EM_ANDAMENTO("EM_ANDAMENTO"),
	FINALIZADA("FINALIZADA");
	
private String cod;
	
	private StatusLocacao(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna o StatusLocacao do locacao a partir do codigo
	 * @param value
	 * @return @StatusLocacao
	 */
	
	@JsonCreator
	public static StatusLocacao getStatusLocacao(String value) {
		for(StatusLocacao status : StatusLocacao.values()) {
			if(status.getCod().equals(value)) {
				return status;
			}
		}
		return null;
	}
}
