package br.com.pos.puc.getCar.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;

@Entity
@DiscriminatorValue("GV")
public class GrupoDeVeiculos {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrupoVeiculo;
	private String descrGrupo;
	
	@Transient
	private Set<CategoriaVeiculo> listCategoriaVeiculo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Veiculo_GrupoDeVeiculos", joinColumns = 
	{@JoinColumn(name = "idGrupoVeiculo")}, inverseJoinColumns = 
	{@JoinColumn(name = "idVeiculo")})
	private Set<Veiculo> listVeiculo;
	
	@Column(name = "categoriaVeiculo")
	public Set<CategoriaVeiculo> getListCategoriaVeiculo() {
		return listCategoriaVeiculo;
	}
	
	private BigDecimal valorDiaria;
	
	/**
	 * 
	 */
	public GrupoDeVeiculos() {
		super();
	}
			
	/**
	 * @param idGrupoVeiculo
	 * @param descrGrupo
	 * @param listCategoriaVeiculo
	 * @param listVeiculo
	 * @param valorDiaria
	 */
	public GrupoDeVeiculos(Long idGrupoVeiculo, String descrGrupo, Set<CategoriaVeiculo> listCategoriaVeiculo,
			Set<Veiculo> listVeiculo, BigDecimal valorDiaria) {
		super();
		this.idGrupoVeiculo = idGrupoVeiculo;
		this.descrGrupo = descrGrupo;
		this.listCategoriaVeiculo = listCategoriaVeiculo;
		this.listVeiculo = listVeiculo;
		this.valorDiaria = valorDiaria;
	}

	@Override
	public String toString() {
		return "GrupoDeVeiculos [idGrupoVeiculo=" + idGrupoVeiculo + ", descrGrupo=" + descrGrupo
				+ ", listCategoriaVeiculo=" + listCategoriaVeiculo + ", listVeiculo=" + listVeiculo + ", valorDiaria="
				+ valorDiaria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idGrupoVeiculo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeVeiculos other = (GrupoDeVeiculos) obj;
		return Objects.equals(idGrupoVeiculo, other.idGrupoVeiculo);
	}
	
	/**
	 * @return the idGrupoVeiculo
	 */
	public Long getIdGrupoVeiculo() {
		return idGrupoVeiculo;
	}
	
	/**
	 * @param idGrupoVeiculo the idGrupoVeiculo to set
	 */
	public void setIdGrupoVeiculo(Long idGrupoVeiculo) {
		this.idGrupoVeiculo = idGrupoVeiculo;
	}
	
	/**
	 * @return the descrGrupo
	 */
	public String getDescrGrupo() {
		return descrGrupo;
	}
	
	/**
	 * @param descrGrupo the descrGrupo to set
	 */
	public void setDescrGrupo(String descrGrupo) {
		this.descrGrupo = descrGrupo;
	}
	
	/**
	 * @param listCategoriaVeiculo the listCategoriaVeiculo to set
	 */
	public void setListCategoriaVeiculo(Set<CategoriaVeiculo> listCategoriaVeiculo) {
		this.listCategoriaVeiculo = listCategoriaVeiculo;
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
	
	/**
	 * @return the valorDiaria
	 */
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}
	
	/**
	 * @param valorDiaria the valorDiaria to set
	 */
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	
}
