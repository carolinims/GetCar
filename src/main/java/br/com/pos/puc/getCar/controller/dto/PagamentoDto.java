package br.com.pos.puc.getCar.controller.dto;

import java.math.BigDecimal;

import br.com.pos.puc.getCar.domain.Pagamento;
import br.com.pos.puc.getCar.domain.enums.StatusPagamento;

public class PagamentoDto {
	private Long idPagamento;
	private StatusPagamento statusPagamento;
	private BigDecimal valor;
	
	
	/**
	 * @param idPagamento
	 * @param statusPagamento
	 * @param valor
	 */
	public PagamentoDto(Long idPagamento, StatusPagamento statusPagamento, BigDecimal valor) {
		super();
		this.idPagamento = idPagamento;
		this.statusPagamento = statusPagamento;
		this.valor = valor;
	}
	
	public PagamentoDto(Pagamento pagamento) {
		this.idPagamento = pagamento.getIdPagamento();
		this.statusPagamento = pagamento.getStatusPagto();
		this.valor = pagamento.getValor(); 
	}

	/**
	 * @return the idPagamento
	 */
	public Long getIdPagamento() {
		return idPagamento;
	}
	/**
	 * @param idPagamento the idPagamento to set
	 */
	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}
	/**
	 * @return the statusPagamento
	 */
	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}
	/**
	 * @param statusPagamento the statusPagamento to set
	 */
	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
