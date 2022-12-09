package br.com.pos.puc.getCar.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.GrupoDeVeiculos;
import br.com.pos.puc.getCar.domain.enums.CategoriaVeiculo;

public class GrupoVeiculoDto {
	
	private Long idGrupoVeiculo;
	private String descrGrupo;
	private List<CategoriaVeiculo> categoriaVeiculo;
	private List<VeiculoDto> listaVeiculos;
	private BigDecimal valorDiaria;
	
	
	
	/**
	 * 
	 */
	public GrupoVeiculoDto(GrupoDeVeiculos gruVeiculos) {
		this.idGrupoVeiculo = gruVeiculos.getIdGrupoVeiculo();
		this.descrGrupo = gruVeiculos.getDescrGrupo();
		this.listaVeiculos = gruVeiculos.getListVeiculo() == null || gruVeiculos.getListVeiculo().isEmpty() ? null 
				: gruVeiculos.getListVeiculo().stream()
				.map(v -> (VeiculoDto) new VeiculoDto(v))
				.collect(Collectors.toList());
		this.categoriaVeiculo = gruVeiculos.getListCategoriaVeiculo() == null || gruVeiculos.getListCategoriaVeiculo().isEmpty()? null
				: gruVeiculos.getListCategoriaVeiculo()
				.stream()
				.collect(Collectors.toList());
		this.valorDiaria = gruVeiculos.getValorDiaria();
	}
	
	/**
	 * @param idGrupoVeiculo
	 * @param descrGrupo
	 * @param categoriaVeiculo
	 * @param listaVeiculos
	 * @param valorDiaria
	 */
	public GrupoVeiculoDto(Long idGrupoVeiculo, String descrGrupo, List<CategoriaVeiculo> categoriaVeiculo,
			List<VeiculoDto> listaVeiculos, BigDecimal valorDiaria) {
		super();
		this.idGrupoVeiculo = idGrupoVeiculo;
		this.descrGrupo = descrGrupo;
		this.categoriaVeiculo = categoriaVeiculo;
		this.listaVeiculos = listaVeiculos;
		this.valorDiaria = valorDiaria;
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
	 * @return the listaVeiculos
	 */
	public List<VeiculoDto> getListaVeiculos() {
		return listaVeiculos;
	}
	/**
	 * @param listaVeiculos the listaVeiculos to set
	 */
	public void setListaVeiculos(List<VeiculoDto> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
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
