package br.com.pos.puc.getCar.controller.dto;

import br.com.pos.puc.getCar.domain.Modelo;
import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;
import br.com.pos.puc.getCar.domain.enums.Marcas;
import br.com.pos.puc.getCar.domain.enums.TipoCombustivel;
import br.com.pos.puc.getCar.domain.enums.TipoMotorizacao;

public class ModeloDto {
	
	private Long idModelo;
	private String descrModelo;
	private TipoCombustivel tipoCombustivel;
	private TipoMotorizacao tipoMotorizacao;
	private Marcas marca;
	private CategoriaVeiculo categoria;
	
	/**
	 * @param idModelo
	 * @param descrModelo
	 * @param tipoCombustivel
	 * @param tipoMotorizacao
	 * @param marca
	 * @param categoria
	 */
	public ModeloDto(Long idModelo, String descrModelo, TipoCombustivel tipoCombustivel,
			TipoMotorizacao tipoMotorizacao, Marcas marca, CategoriaVeiculo categoria) {
		super();
		this.idModelo = idModelo;
		this.descrModelo = descrModelo;
		this.tipoCombustivel = tipoCombustivel;
		this.tipoMotorizacao = tipoMotorizacao;
		this.marca = marca;
		this.categoria = categoria;
	}
	
	public ModeloDto(Modelo modelo) {
		super();
		this.idModelo = modelo.getIdModelo();
		this.descrModelo = modelo.getDescrModelo();
		this.tipoCombustivel = modelo.getTipoCombustivel();
		this.tipoMotorizacao = modelo.getTipoMotorizacao();
		this.marca = modelo.getMarca();
		this.categoria = modelo.getCategoria();
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
	
}
