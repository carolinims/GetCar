package br.com.pos.puc.getCar.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.pos.puc.getCar.domain.enums.StatusPagamento;

@Entity
@DiscriminatorValue("PG")
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPagamento;
	
	@Enumerated(EnumType.STRING)
	private StatusPagamento statusPagto;
	private BigDecimal valor;
	
	@OneToMany(mappedBy = "idMulta", fetch = FetchType.EAGER)
	private Set<Multa> listMulta;

	/**
	 * 
	 */
	public Pagamento() {
		super();
	}

	/**
	 * @param idPagamento
	 * @param statusPagto
	 * @param valor
	 * @param listMulta
	 */
	public Pagamento(Long idPagamento, StatusPagamento statusPagto, BigDecimal valor, Set<Multa> listMulta) {
		super();
		this.idPagamento = idPagamento;
		this.statusPagto = statusPagto;
		this.valor = valor;
		this.listMulta = listMulta;
	}

	@Override
	public String toString() {
		return "Pagamento [idPagamento=" + idPagamento + ", statusPagto=" + statusPagto + ", valor=" + valor
				+ ", listMulta=" + listMulta + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idPagamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(idPagamento, other.idPagamento);
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
	 * @return the statusPagto
	 */
	public StatusPagamento getStatusPagto() {
		return statusPagto;
	}

	/**
	 * @param statusPagto the statusPagto to set
	 */
	public void setStatusPagto(StatusPagamento statusPagto) {
		this.statusPagto = statusPagto;
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

	/**
	 * @return the listMulta
	 */
	public Set<Multa> getListMulta() {
		return listMulta;
	}

	/**
	 * @param listMulta the listMulta to set
	 */
	public void setListMulta(Set<Multa> listMulta) {
		this.listMulta = listMulta;
	}
	
	
}
