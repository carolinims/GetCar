package br.com.pos.puc.getCar.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@DiscriminatorValue("PK")
public class ReservaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long idReserva;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	protected Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idVeiculo")
	protected Veiculo veiculo;
	
	protected Date DtHrRetiradaVeiculo;
	
	
	/**
	 * 
	 */
	public ReservaPK() {
		super();
	}

	/**
	 * @param cliente
	 * @param veiculo
	 * @param dtHrRetiradaVeiculo
	 */
	public ReservaPK(Cliente cliente, Veiculo veiculo, Date dtHrRetiradaVeiculo) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		DtHrRetiradaVeiculo = dtHrRetiradaVeiculo;
	}

	@Override
	public String toString() {
		return "ReservaPK [cliente=" + cliente + ", veiculo=" + veiculo + ", DtHrRetiradaVeiculo=" + DtHrRetiradaVeiculo
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(DtHrRetiradaVeiculo, cliente, idReserva, veiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaPK other = (ReservaPK) obj;
		return Objects.equals(DtHrRetiradaVeiculo, other.DtHrRetiradaVeiculo) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(idReserva, other.idReserva) && Objects.equals(veiculo, other.veiculo);
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the veiculo
	 */
	public Veiculo getVeiculo() {
		return veiculo;
	}

	/**
	 * @param veiculo the veiculo to set
	 */
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * @return the dtHrRetiradaVeiculo
	 */
	public Date getDtHrRetiradaVeiculo() {
		return DtHrRetiradaVeiculo;
	}

	/**
	 * @param dtHrRetiradaVeiculo the dtHrRetiradaVeiculo to set
	 */
	public void setDtHrRetiradaVeiculo(Date dtHrRetiradaVeiculo) {
		DtHrRetiradaVeiculo = dtHrRetiradaVeiculo;
	}

	
}
