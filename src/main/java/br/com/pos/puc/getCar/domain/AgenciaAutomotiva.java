package br.com.pos.puc.getCar.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("AA")
public class AgenciaAutomotiva {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgenciaAuto;
	private String nomeAgencia;
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "agAutomotiva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Atendente> listAtendente;
	
	@OneToMany(mappedBy = "agAutomotiva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Gerente> listGerente;
	
	@OneToMany(mappedBy = "agAutomotiva", fetch = FetchType.EAGER)
	private Set<Veiculo> listVeiculo;
	
	/**
	 * 
	 */
	public AgenciaAutomotiva() {
		super();
	}

	/**
	 * @param idAgenciaAuto
	 * @param nomeAgencia
	 * @param endereco
	 * @param listAtendente
	 * @param listGerente
	 * @param listVeiculo
	 */
	public AgenciaAutomotiva(Long idAgenciaAuto, String nomeAgencia, Endereco endereco, Set<Atendente> listAtendente,
			Set<Gerente> listGerente, Set<Veiculo> listVeiculo) {
		super();
		this.idAgenciaAuto = idAgenciaAuto;
		this.nomeAgencia = nomeAgencia;
		this.endereco = endereco;
		this.listAtendente = listAtendente;
		this.listGerente = listGerente;
		this.listVeiculo = listVeiculo;
	}

	@Override
	public String toString() {
		return "AgenciaAutomotiva [idAgenciaAuto=" + idAgenciaAuto + ", nomeAgencia=" + nomeAgencia + ", endereco="
				+ endereco + ", listAtendente=" + listAtendente + ", listGerente=" + listGerente + ", listVeiculo="
				+ listVeiculo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAgenciaAuto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgenciaAutomotiva other = (AgenciaAutomotiva) obj;
		return Objects.equals(idAgenciaAuto, other.idAgenciaAuto);
	}

	/**
	 * @return the idAgenciaAuto
	 */
	public Long getIdAgenciaAuto() {
		return idAgenciaAuto;
	}

	/**
	 * @param idAgenciaAuto the idAgenciaAuto to set
	 */
	public void setIdAgenciaAuto(Long idAgenciaAuto) {
		this.idAgenciaAuto = idAgenciaAuto;
	}

	/**
	 * @return the nomeAgencia
	 */
	public String getNomeAgencia() {
		return nomeAgencia;
	}

	/**
	 * @param nomeAgencia the nomeAgencia to set
	 */
	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * @return the listAtendente
	 */
	public Set<Atendente> getListAtendente() {
		return listAtendente;
	}

	/**
	 * @param listAtendente the listAtendente to set
	 */
	public void setListAtendente(Set<Atendente> listAtendente) {
		this.listAtendente = listAtendente;
	}

	/**
	 * @return the listGerente
	 */
	public Set<Gerente> getListGerente() {
		return listGerente;
	}

	/**
	 * @param listGerente the listGerente to set
	 */
	public void setListGerente(Set<Gerente> listGerente) {
		this.listGerente = listGerente;
	}

	/**
	 * @return the listVeiculo
	 */
	public Set<Veiculo> getListVeiculo() {
		return listVeiculo;
	}

	/**
	 * @param listVeiculo the listVeiculo to set
	 */
	public void setListVeiculo(Set<Veiculo> listVeiculo) {
		this.listVeiculo = listVeiculo;
	}
	
}
