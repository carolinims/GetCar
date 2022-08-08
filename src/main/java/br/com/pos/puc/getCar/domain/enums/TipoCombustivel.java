package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoCombustivel {
	GASOLINA ("GASOLINA"),
	ETANOL("ETANOL"),
	FLEX("FLEX"),
	DIESEL("DIESEL"),
	ELETRICO("ELETRICO"),
	HIBRIDO("HIBRIDO");
	
	private String cod;
	
	private TipoCombustivel(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * Retorna o tipoCombustivel do veiculo a partir do codigo
	 * @param value
	 * @return @TipoCombustivel
	 */
	
	@JsonCreator
	public static TipoCombustivel getTipoCombustivel(String value) {
		for(TipoCombustivel tpComb : TipoCombustivel.values()) {
			if(tpComb.getCod().equals(value)) {
				return tpComb;
			}
		}
		return null;
	}
	
}
