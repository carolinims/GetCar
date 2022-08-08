package br.com.pos.puc.getCar.controller.form;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pos.puc.getCar.domain.Modelo;
import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;
import br.com.pos.puc.getCar.domain.enums.Marcas;
import br.com.pos.puc.getCar.domain.enums.TipoCombustivel;
import br.com.pos.puc.getCar.domain.enums.TipoMotorizacao;

public class ModeloForm {
	
	@NotNull @NotEmpty
	private Long idModelo;
	
	@NotNull @NotEmpty
	private String descrModelo;
	private TipoCombustivel tipoCombustivel;
	private TipoMotorizacao tipoMotorizacao;
	private Marcas marca;
	private CategoriaVeiculo categoria;
	private Set<VeiculoForm> listVeiculoForm;
	
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
	 * @return the listVeiculoForm
	 */
	public Set<VeiculoForm> getListVeiculoForm() {
		return listVeiculoForm;
	}
	/**
	 * @param listVeiculoForm the listVeiculoForm to set
	 */
	public void setListVeiculoForm(Set<VeiculoForm> listVeiculoForm) {
		this.listVeiculoForm = listVeiculoForm;
	}
	
	public Modelo converter() {
		return new Modelo(idModelo, 
				descrModelo, 
				tipoCombustivel, 
				tipoMotorizacao, 
				marca, 
				categoria, 
				getListVeiculoForm() == null ? null : this.getListVeiculoForm()
				.stream()
				.map(veiculoForm -> veiculoForm.converter())
				.collect(Collectors.toSet()));
	}
}
