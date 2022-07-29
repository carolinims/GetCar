package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusPagamento {
	PAGTO_ADIANTADO("PAGTO_ADIANTADO"),
	AGUARDANDO_PAGTO("AGUARDANDO_PAGTO"),
	PAGO("PAGO"),
	PAGTO_COM_ATRASO("PAGTO_COM_ATRASO");
	
	private String cod;
	
	private StatusPagamento(String cod) {
		this.cod = cod;
	}
	
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Retorna o StatusPagamento do pagamento a partir do codigo
	 * @param value
	 * @return @StatusPagamento
	 */
	
	@JsonCreator
	public static StatusPagamento getStatusPagamento(String value) {
		for(StatusPagamento status : StatusPagamento.values()) {
			if(status.getCod().equals(value)) {
				return status;
			}
		}
		return null;
	}
}
