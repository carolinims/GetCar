package br.com.pos.puc.getCar.controller.form;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.GrupoDeVeiculos;
import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;

public class GrupoVeiculoForm {
	
	private Long idGrupoVeiculo;
	private String descrGrupo;
	private List<CategoriaVeiculo> categoriaVeiculo;
	private List<VeiculoForm> listaVeiculos;
	private BigDecimal valorDiaria;
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
	 * @return the categoriaVeiculo
	 */
	public List<CategoriaVeiculo> getCategoriaVeiculo() {
		return categoriaVeiculo;
	}
	/**
	 * @param categoriaVeiculo the categoriaVeiculo to set
	 */
	public void setCategoriaVeiculo(List<CategoriaVeiculo> categoriaVeiculo) {
		this.categoriaVeiculo = categoriaVeiculo;
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
	
	/**
	 * @return the listaVeiculos
	 */
	public List<VeiculoForm> getListaVeiculos() {
		return listaVeiculos;
	}
	
	/**
	 * @param listaVeiculos the listaVeiculos to set
	 */
	public void setListaVeiculos(List<VeiculoForm> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public GrupoDeVeiculos converter() {
		return new GrupoDeVeiculos(
				this.idGrupoVeiculo,
				this.descrGrupo, 
				categoriaVeiculo == null ? null : categoriaVeiculo.stream().collect(Collectors.toSet()), 
				listaVeiculos == null ? null : listaVeiculos.stream().map(veiculo -> (Veiculo) veiculo.converter()).collect(Collectors.toSet()),
				this.valorDiaria);
	}

}
