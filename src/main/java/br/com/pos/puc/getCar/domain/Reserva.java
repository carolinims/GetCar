package br.com.pos.puc.getCar.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import br.com.pos.puc.getCar.domain.enums.StatusReserva;

@Entity
public class Reserva {

	@EmbeddedId
	private ReservaPK reservaPK;
	
	@OneToOne(fetch =  FetchType.EAGER)
    private GrupoDeVeiculos grupoVeiculo;
	
    private Date DateDtHrPrevDevolucao;
    
    @OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    private Pagamento pagamento;
    
    @Enumerated(EnumType.STRING)
	private StatusReserva statusReserva;
   
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
	public Reserva(ReservaPK reservaPK, GrupoDeVeiculos grupoVeiculo, Date dateDtHrPrevDevolucao, Pagamento pagamento, StatusReserva statusReserva) {
		super();
		this.reservaPK = reservaPK;
		this.grupoVeiculo = grupoVeiculo;
		DateDtHrPrevDevolucao = dateDtHrPrevDevolucao;
		this.pagamento = pagamento;
		this.statusReserva = statusReserva;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(DateDtHrPrevDevolucao, grupoVeiculo, pagamento, reservaPK, statusReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(DateDtHrPrevDevolucao, other.DateDtHrPrevDevolucao)
				&& Objects.equals(grupoVeiculo, other.grupoVeiculo) && Objects.equals(pagamento, other.pagamento)
				&& Objects.equals(reservaPK, other.reservaPK) && statusReserva == other.statusReserva;
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

	/**
	 * @return the statusReserva
	 */
	public StatusReserva getStatusReserva() {
		return statusReserva;
	}

	/**
	 * @param statusReserva the statusReserva to set
	 */
	public void setStatusReserva(StatusReserva statusReserva) {
		this.statusReserva = statusReserva;
	}
	
    
    
}
