package br.com.pos.puc.getCar.controller.form;

import java.math.BigDecimal;

import br.com.pos.puc.getCar.domain.Pagamento;
import br.com.pos.puc.getCar.domain.enums.StatusPagamento;

public class PagamentoForm {
	private Long idPagamento;
	private StatusPagamento statusPagamento;
	private BigDecimal valor;
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
		valor = valor.setScale(2);
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "PagamentoForm [idPagamento=" + idPagamento + ", statusPagamento=" + statusPagamento + ", valor=" + valor
				+ "]";
	}

	public Pagamento converter() {
		return new Pagamento(this.idPagamento, 
				this.getStatusPagamento(), 
				this.valor,
				null);
	}
}
