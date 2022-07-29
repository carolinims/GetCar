package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoriaVeiculo {
	HATCH("HATCH"),
	ESPORTIVO("ESPORTIVO"),
	SEDAN("SEDAN"),
	MINIVAN("MINIVAN"),
	PERUA("PERUA"),
	PICAPE("PICAPE"),
	SUV("SUV"),
	MOTOCICLETA("MOTOCICLETA");
	
	private String cod;
	
	private CategoriaVeiculo(String cod) {
		this.cod = cod;
	}

	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna a CategoriaVeiculo do veiculo a partir do codigo
	 * @param value
	 * @return @CategoriaVeiculo
	 */
	
	@JsonCreator
	public static CategoriaVeiculo getCategoriaVeiculo(String value) {
		for(CategoriaVeiculo catVeiculo : CategoriaVeiculo.values()) {
			if(catVeiculo.getCod().equals(value)) {
				return catVeiculo;
			}
		}
		return null;
	}
}
