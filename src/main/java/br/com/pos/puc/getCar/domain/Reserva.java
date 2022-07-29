package br.com.pos.puc.getCar.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Reserva {

	@EmbeddedId
	private ReservaPK reservaPK;
	
	@OneToOne(fetch =  FetchType.EAGER)
    private GrupoDeVeiculos grupoVeiculo;
	
    private Date DateDtHrPrevDevolucao;
    
    @OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    private Pagamento pagamento;
   
	/**
	 * 
	 */
	public Reserva() {
		super();
	}

	/**
	 * @param reservaPK
	 * @param grupoVeiculo
	 * @param dateDtHrPrevDevolucao
	 * @param pagamento
	 */
	public Reserva(ReservaPK reservaPK, GrupoDeVeiculos grupoVeiculo, Date dateDtHrPrevDevolucao, Pagamento pagamento) {
		super();
		this.reservaPK = reservaPK;
		this.grupoVeiculo = grupoVeiculo;
		DateDtHrPrevDevolucao = dateDtHrPrevDevolucao;
		this.pagamento = pagamento;
	}

	/**
	 * @return the reservaPK
	 */
	public ReservaPK getReservaPK() {
		return reservaPK;
	}

	/**
	 * @param reservaPK the reservaPK to set
	 */
	public void setReservaPK(ReservaPK reservaPK) {
		this.reservaPK = reservaPK;
	}

	/**
	 * @return the grupoVeiculo
	 */
	public GrupoDeVeiculos getGrupoVeiculo() {
		return grupoVeiculo;
	}

	/**
	 * @param grupoVeiculo the grupoVeiculo to set
	 */
	public void setGrupoVeiculo(GrupoDeVeiculos grupoVeiculo) {
		this.grupoVeiculo = grupoVeiculo;
	}

	/**
	 * @return the dateDtHrPrevDevolucao
	 */
	public Date getDateDtHrPrevDevolucao() {
		return DateDtHrPrevDevolucao;
	}

	/**
	 * @param dateDtHrPrevDevolucao the dateDtHrPrevDevolucao to set
	 */
	public void setDateDtHrPrevDevolucao(Date dateDtHrPrevDevolucao) {
		DateDtHrPrevDevolucao = dateDtHrPrevDevolucao;
	}

	/**
	 * @return the pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
    
    
}
