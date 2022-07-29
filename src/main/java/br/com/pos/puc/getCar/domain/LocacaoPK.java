package br.com.pos.puc.getCar.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
@DiscriminatorValue("PK")
public class LocacaoPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idVeiculo")
	private Veiculo veiculo;
	
	private Date DtHrRetiradaVeiculo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
	private Pagamento pagamento;

	/**
	 * 
	 */
	public LocacaoPK() {
		super();
	}

	/**
	 * @param idLocacao
	 * @param cliente
	 * @param veiculo
	 * @param dtHrRetiradaVeiculo
	 * @param pagamento
	 */
	public LocacaoPK(Long idLocacao, Cliente cliente, Veiculo veiculo, Date dtHrRetiradaVeiculo, Pagamento pagamento) {
		super();
		this.idLocacao = idLocacao;
		this.cliente = cliente;
		this.veiculo = veiculo;
		DtHrRetiradaVeiculo = dtHrRetiradaVeiculo;
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "LocacaoPK [idLocacao=" + idLocacao + ", cliente=" + cliente + ", veiculo=" + veiculo
				+ ", DtHrRetiradaVeiculo=" + DtHrRetiradaVeiculo + ", pagamento=" + pagamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLocacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocacaoPK other = (LocacaoPK) obj;
		return Objects.equals(idLocacao, other.idLocacao);
	}

	/**
	 * @return the idLocacao
	 */
	public Long getIdLocacao() {
		return idLocacao;
	}

	/**
	 * @param idLocacao the idLocacao to set
	 */
	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
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
