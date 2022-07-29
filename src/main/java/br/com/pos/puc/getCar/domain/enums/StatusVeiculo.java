package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusVeiculo {
	DISPONIVEL("DISPONIVEL"),
	ALUGADO("ALUGADO"),
	INDISPONIVEL("INDISPONIVEL");
	
	private String cod;
	
	private StatusVeiculo(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna o StatusVeiculo do veiculo a partir do codigo
	 * @param value
	 * @return @StatusVeiculo
	 */
	
	@JsonCreator
	public static StatusVeiculo getStatusVeiculo(String value) {
		for(StatusVeiculo status : StatusVeiculo.values()) {
			if(status.getCod().equals(value)) {
				return status;
			}
		}
		return null;
	}
}
