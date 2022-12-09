package br.com.pos.puc.getCar.controller.form;

import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.domain.enums.StatusVeiculo;

public class VeiculoForm {
	
	private Long idVeiculo;
	private AgenciaAutomotivaForm agAutomotiva;
	private String placaVeiculo;
	private String renavam;
	private Long valorHodometro;
	private StatusVeiculo statusVeiculo; 
	private String cidadeVeiculo;
	private String estadoVeiculo;
	private ModeloForm modelo;
	private String imgVeiculo;
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
	 * @return the agAutomotiva
	 */
	public AgenciaAutomotivaForm getAgAutomotiva() {
		return agAutomotiva;
	}
	/**
	 * @param agAutomotiva the agAutomotiva to set
	 */
	public void setAgAutomotiva(AgenciaAutomotivaForm agAutomotiva) {
		this.agAutomotiva = agAutomotiva;
	}
	/**
	 * @return the modelo
	 */
	public ModeloForm getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(ModeloForm modelo) {
		this.modelo = modelo;
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
	public Veiculo converter() {
		return new Veiculo(this.idVeiculo, 
				agAutomotiva == null ? null : this.getAgAutomotiva().converter(), 
				placaVeiculo, 
				renavam, 
				valorHodometro, 
				statusVeiculo, 
				cidadeVeiculo, 
				estadoVeiculo, 
				imgVeiculo,
				modelo == null ? null : this.getModelo().converter());
	}
}
