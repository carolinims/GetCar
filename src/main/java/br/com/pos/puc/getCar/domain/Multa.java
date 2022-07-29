package br.com.pos.puc.getCar.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("MU")
public class Multa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMulta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private Cliente cliente;
	
	private String descrMulta;
	private BigDecimal valorMulta;
	private Date DrHrMulta;
		
	/**
	 * 
	 */
	public Multa() {
		super();
	}

	/**
	 * @param idMulta
	 * @param cliente
	 * @param descrMulta
	 * @param valorMulta
	 * @param drHrMulta
	 */
	public Multa(Long idMulta, Cliente cliente, String descrMulta, BigDecimal valorMulta, Date drHrMulta) {
		super();
		this.idMulta = idMulta;
		this.cliente = cliente;
		this.descrMulta = descrMulta;
		this.valorMulta = valorMulta;
		DrHrMulta = drHrMulta;
	}

	@Override
	public String toString() {
		return "Multa [idMulta=" + idMulta + ", cliente=" + cliente + ", descrMulta=" + descrMulta + ", valorMulta="
				+ valorMulta + ", DrHrMulta=" + DrHrMulta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMulta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multa other = (Multa) obj;
		return Objects.equals(idMulta, other.idMulta);
	}

	/**
	 * @return the idMulta
	 */
	public Long getIdMulta() {
		return idMulta;
	}

	/**
	 * @param idMulta the idMulta to set
	 */
	public void setIdMulta(Long idMulta) {
		this.idMulta = idMulta;
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
	 * @return the descrMulta
	 */
	public String getDescrMulta() {
		return descrMulta;
	}

	/**
	 * @param descrMulta the descrMulta to set
	 */
	public void setDescrMulta(String descrMulta) {
		this.descrMulta = descrMulta;
	}

	/**
	 * @return the valorMulta
	 */
	public BigDecimal getValorMulta() {
		return valorMulta;
	}

	/**
	 * @param valorMulta the valorMulta to set
	 */
	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

	/**
	 * @return the drHrMulta
	 */
	public Date getDrHrMulta() {
		return DrHrMulta;
	}

	/**
	 * @param drHrMulta the drHrMulta to set
	 */
	public void setDrHrMulta(Date drHrMulta) {
		DrHrMulta = drHrMulta;
	}
	
}
