package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusReserva {
	ATIVA("ATIVA"),
	CANCELADA("CANCELADA"),
	FINALIZADA("FINALIZADA");
	
	private String cod;
	
	private StatusReserva(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna o StatusReserva da reserva a partir do codigo
	 * @param value
	 * @return @StatusReserva
	 */
	
	@JsonCreator
	public static StatusReserva getStatusReserva(String value) {
		for(StatusReserva status : StatusReserva.values()) {
			if(status.getCod().equals(value)) {
				return status;
			}
		}
		return null;
	}
}
