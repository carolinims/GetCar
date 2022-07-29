package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoMotorizacao {
	MOTOR_1_0("1.0"),
	MOTOR_1_4("1.4"),
	MOTOR_1_6("1.6"),
	MOTOR_1_8("1.8"),
	MOTOR_2_0("2.0");
	
	
	private String cod;
	
	private TipoMotorizacao(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna o TipoMotorizacao do veiculo a partir do codigo
	 * @param value
	 * @return @TipoMotorizacao
	 */
	
	@JsonCreator
	public static TipoMotorizacao getTipoMotorizacao(String value) {
		for(TipoMotorizacao tpMotor : TipoMotorizacao.values()) {
			if(tpMotor.getCod().equals(value)) {
				return tpMotor;
			}
		}
		return null;
	}
}
