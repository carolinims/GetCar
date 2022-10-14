package br.com.pos.puc.getCar.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.pos.puc.getCar.domain.enums.StatusVeiculo;

@Entity
@DiscriminatorValue("V")
public class Veiculo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVeiculo;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "idAgenciaAuto")
//	private AgenciaAutomotiva agAutomotiva;
	private String placaVeiculo;
	private String renavam;
	private Long valorHodometro;
	
	@Enumerated(EnumType.STRING)
	private StatusVeiculo statusVeiculo;
	private String cidadeVeiculo;
	private String estadoVeiculo;
	private String imgVeiculo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idModelo")
	private Modelo modelo;
	
	@OneToMany(mappedBy = "locacaoPK.idLocacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Locacao> listLocacoes;
	
	/**
	 * 
	 */
	public Veiculo() {
		super();
	}
	
	/**
	 * @param idVeiculo
	 * @param agAutomotiva
	 * @param placaVeiculo
	 * @param renavam
	 * @param valorHodometro
	 * @param statusVeiculo
	 * @param cidadeVeiculo
	 * @param estadoVeiculo
	 * @param modelo
	 */
	public Veiculo(Long idVeiculo, AgenciaAutomotiva agAutomotiva, String placaVeiculo, String renavam,
			Long valorHodometro, StatusVeiculo statusVeiculo, String cidadeVeiculo, String estadoVeiculo, String imgVeiculo,
			Modelo modelo) {
		super();
		this.idVeiculo = idVeiculo;
//		this.agAutomotiva = agAutomotiva;
		this.placaVeiculo = placaVeiculo;
		this.renavam = renavam;
		this.valorHodometro = valorHodometro;
		this.statusVeiculo = statusVeiculo;
		this.cidadeVeiculo = cidadeVeiculo;
		this.estadoVeiculo = estadoVeiculo;
		this.imgVeiculo = imgVeiculo;
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Veiculo [idVeiculo=" + idVeiculo + ", placaVeiculo=" + placaVeiculo + ", renavam=" + renavam
				+ ", valorHodometro=" + valorHodometro + ", statusVeiculo=" + statusVeiculo + ", cidadeVeiculo="
				+ cidadeVeiculo + ", estadoVeiculo=" + estadoVeiculo + ", imgVeiculo=" + imgVeiculo + ", modelo="
				+ modelo + ", listLocacoes=" + listLocacoes + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVeiculo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(idVeiculo, other.idVeiculo);
	}
	
	/**
	 * @return the idVeiculo
	 */
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	
	/**
	 * @param idVeiculo the idVeiculo to set
	 */
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
//	/**
//	 * @return the agAutomotiva
//	 */
//	public AgenciaAutomotiva getAgAutomotiva() {
//		return agAutomotiva;
//	}
//	
//	/**
//	 * @param agAutomotiva the agAutomotiva to set
//	 */
//	public void setAgAutomotiva(AgenciaAutomotiva agAutomotiva) {
//		this.agAutomotiva = agAutomotiva;
//	}
//	
	/**
	 * @return the placaVeiculo
	 */
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	
	/**
	 * @param placaVeiculo the placaVeiculo to set
	 */
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	
	/**
	 * @return the renavam
	 */
	public String getRenavam() {
		return renavam;
	}
	
	/**
	 * @param renavam the renavam to set
	 */
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	/**
	 * @return the valorHodometro
	 */
	public Long getValorHodometro() {
		return valorHodometro;
	}
	
	/**
	 * @param valorHodometro the valorHodometro to set
	 */
	public void setValorHodometro(Long valorHodometro) {
		this.valorHodometro = valorHodometro;
	}
	
	/**
	 * @return the statusVeiculo
	 */
	public StatusVeiculo getStatusVeiculo() {
		return statusVeiculo;
	}
	
	/**
	 * @param statusVeiculo the statusVeiculo to set
	 */
	public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}
	
	/**
	 * @return the cidadeVeiculo
	 */
	public String getCidadeVeiculo() {
		return cidadeVeiculo;
	}
	
	/**
	 * @param cidadeVeiculo the cidadeVeiculo to set
	 */
	public void setCidadeVeiculo(String cidadeVeiculo) {
		this.cidadeVeiculo = cidadeVeiculo;
	}
	
	/**
	 * @return the estadoVeiculo
	 */
	public String getEstadoVeiculo() {
		return estadoVeiculo;
	}
	
	/**
	 * @param estadoVeiculo the estadoVeiculo to set
	 */
	public void setEstadoVeiculo(String estadoVeiculo) {
		this.estadoVeiculo = estadoVeiculo;
	}

	/**
	 * @return the imgVeiculo
	 */
	public String getImgVeiculo() {
		return imgVeiculo;
	}

	/**
	 * @param imgVeiculo the imgVeiculo to set
	 */
	public void setImgVeiculo(String imgVeiculo) {
		this.imgVeiculo = imgVeiculo;
	}

	/**
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
			
}
