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
import javax.persistence.OneToMany;

import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;
import br.com.pos.puc.getCar.domain.enums.Marcas;
import br.com.pos.puc.getCar.domain.enums.TipoCombustivel;
import br.com.pos.puc.getCar.domain.enums.TipoMotorizacao;

@Entity
@DiscriminatorValue("M")
public class Modelo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModelo;
	private String descrModelo;
	
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	
	@Enumerated(EnumType.STRING)
	private TipoMotorizacao tipoMotorizacao;
	
	@Enumerated(EnumType.STRING)
	private Marcas marca;
	
	@Enumerated(EnumType.STRING)
	private CategoriaVeiculo categoria;
	
	@OneToMany(mappedBy = "idVeiculo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Veiculo> listVeiculo;
	
	public Modelo() {
		super();
	}

	/**
	 * @param idModelo
	 * @param descrModelo
	 * @param tipoCombustivel
	 * @param tipoMotorizacao
	 * @param marca
	 * @param categoria
	 * @param listVeiculo
	 */
	public Modelo(Long idModelo, String descrModelo, TipoCombustivel tipoCombustivel, TipoMotorizacao tipoMotorizacao,
			Marcas marca, CategoriaVeiculo categoria, Set<Veiculo> listVeiculo) {
		super();
		this.idModelo = idModelo;
		this.descrModelo = descrModelo;
		this.tipoCombustivel = tipoCombustivel;
		this.tipoMotorizacao = tipoMotorizacao;
		this.marca = marca;
		this.categoria = categoria;
		this.listVeiculo = listVeiculo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idModelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return Objects.equals(idModelo, other.idModelo);
	}

	@Override
	public String toString() {
		return "Modelo [idModelo=" + idModelo + ", descrModelo=" + descrModelo + ", tipoCombustivel=" + tipoCombustivel
				+ ", tipoMotorizacao=" + tipoMotorizacao + ", marca=" + marca + ", categoria=" + categoria
				+ ", listVeiculo=" + listVeiculo + "]";
	}

	/**
	 * @return the idModelo
	 */
	public Long getIdModelo() {
		return idModelo;
	}

	/**
	 * @param idModelo the idModelo to set
	 */
	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	/**
	 * @return the descrModelo
	 */
	public String getDescrModelo() {
		return descrModelo;
	}

	/**
	 * @param descrModelo the descrModelo to set
	 */
	public void setDescrModelo(String descrModelo) {
		this.descrModelo = descrModelo;
	}

	/**
	 * @return the tipoCombustivel
	 */
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	/**
	 * @param tipoCombustivel the tipoCombustivel to set
	 */
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	/**
	 * @return the tipoMotorizacao
	 */
	public TipoMotorizacao getTipoMotorizacao() {
		return tipoMotorizacao;
	}

	/**
	 * @param tipoMotorizacao the tipoMotorizacao to set
	 */
	public void setTipoMotorizacao(TipoMotorizacao tipoMotorizacao) {
		this.tipoMotorizacao = tipoMotorizacao;
	}

	/**
	 * @return the marca
	 */
	public Marcas getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	/**
	 * @return the categoria
	 */
	public CategoriaVeiculo getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaVeiculo categoria) {
		this.categoria = categoria;
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
