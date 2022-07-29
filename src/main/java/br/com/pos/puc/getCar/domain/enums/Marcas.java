package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Marcas {
	TOYOTA("TOYOTA"),
	HONDA("HONDA"),
	HYUNDAI("HYUNDAI"),
	VOLKSWAGEN("VOLKSWAGEN"),
	CHEVROLET("CHEVROLET"),
	FIAT("FIAT"),
	FORD("FORD"),
	RENAULT("RENAULT"),
	JEEP("JEEP"),
	NISSAN("NISSAN"),
	CAOA("CAOA"),
	PEUGEOT("PEUGEOT"),
	CITROEN("CITROEN"),
	BMW("BMW"),
	MERCEDES("MERCEDES"),
	VOLVO("VOLVO"),
	AUDI("AUDI"),
	LAND_ROVER("LAND_ROVER"),
	KIA("KIA"),
	SUZUKI("SUZUKI"),
	YAMAHA("YAMAHA"),
	JAC("JAC"),
	KAWASAKI("KAWASAKI");
	
	private String cod;
	
	private Marcas(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * Retorna a Marcas do veiculo a partir do codigo
	 * @param value
	 * @return @Marcas
	 */
	
	@JsonCreator
	public static Marcas getMarca(String value) {
		for(Marcas marca : Marcas.values()) {
			if(marca.getCod().equals(value)) {
				return marca;
			}
		}
		return null;
	}
	
}
