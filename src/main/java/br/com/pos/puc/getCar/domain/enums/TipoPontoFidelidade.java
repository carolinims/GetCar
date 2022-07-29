package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoPontoFidelidade {
	OURO("OURO"),
	PRATA("PRATA"),
	BRONZE("BRONZE");
	
	private String cod;
	
	private TipoPontoFidelidade(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna o TipoPontoFidelidade do ponto fidelidade a partir do codigo
	 * @param value
	 * @return @TipoPontoFidelidade
	 */
	
	@JsonCreator
	public static TipoPontoFidelidade getTipoPontoFidelidade(String value) {
		for(TipoPontoFidelidade status : TipoPontoFidelidade.values()) {
			if(status.getCod().equals(value)) {
				return status;
			}
		}
		return null;
	}
}
