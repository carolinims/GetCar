package br.com.pos.puc.getCar.controller.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.pos.puc.getCar.domain.AgenciaAutomotiva;
import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.domain.enums.StatusVeiculo;

public class VeiculoDto {
	
	private Long idVeiculo;
//	private AgenciaAutomotivaDto agAutomotiva;
	private String placaVeiculo;
	private String renavam;
	private Long valorHodometro;
	private StatusVeiculo statusVeiculo;
	private String cidadeVeiculo;
	private String estadoVeiculo;
	private ModeloDto modeloDto;
	private String imgVeiculo;
	
	
	/**
	 * 
	 */
	public VeiculoDto() {

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
	 * @param modeloDto
	 */
	public VeiculoDto(Long idVeiculo, AgenciaAutomotivaDto agAutomotiva, String placaVeiculo, String renavam,
			Long valorHodometro, StatusVeiculo statusVeiculo, String cidadeVeiculo, String estadoVeiculo,
			ModeloDto modeloDto, String imgVeiculo) {
		super();
		this.idVeiculo = idVeiculo;
//		this.agAutomotiva = agAutomotiva;
		this.placaVeiculo = placaVeiculo;
		this.renavam = renavam;
		this.valorHodometro = valorHodometro;
		this.statusVeiculo = statusVeiculo;
		this.cidadeVeiculo = cidadeVeiculo;
		this.estadoVeiculo = estadoVeiculo;
		this.modeloDto = modeloDto;
		this.imgVeiculo = imgVeiculo;
	}
	
	public VeiculoDto(Veiculo veiculo) {
		super();
		this.idVeiculo = veiculo.getIdVeiculo();
//		this.agAutomotiva = new AgenciaAutomotivaDto(veiculo.getAgAutomotiva());
		this.placaVeiculo = veiculo.getPlacaVeiculo();
		this.renavam = veiculo.getRenavam();
		this.valorHodometro = veiculo.getValorHodometro();
		this.statusVeiculo = veiculo.getStatusVeiculo();
		this.cidadeVeiculo = veiculo.getCidadeVeiculo();
		this.estadoVeiculo = veiculo.getEstadoVeiculo();
		this.modeloDto = new ModeloDto(veiculo.getModelo());
		this.imgVeiculo = veiculo.getImgVeiculo();
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
//	public AgenciaAutomotivaDto getAgAutomotiva() {
//		return agAutomotiva;
//	}
//
//	/**
//	 * @param agAutomotiva the agAutomotiva to set
//	 */
//	public void setAgAutomotiva(AgenciaAutomotivaDto agAutomotiva) {
//		this.agAutomotiva = agAutomotiva;
//	}

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
	 * @return the modeloDto
	 */
	public ModeloDto getModeloDto() {
		return modeloDto;
	}
	/**
	 * @param modeloDto the modeloDto to set
	 */
	public void setModeloDto(ModeloDto modeloDto) {
		this.modeloDto = modeloDto;
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

	public static Page<VeiculoDto> converter(Page<Veiculo> veiculos){
		return veiculos.map(VeiculoDto::new);
		
	}
	
	
}
