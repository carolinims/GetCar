package br.com.pos.puc.getCar.controller.dto;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.AgenciaAutomotiva;

public class AgenciaAutomotivaDto {
	
	private Long idAgenciaAuto;
	private String nomeAgencia;
	private EnderecoDto endereco;
	private Set<AtendenteDto> atendente;
	private Set<GerenteDto> gerente;
	private Set<VeiculoDto> veiculo;
	
	/**
	 * @param idAgenciaAuto
	 * @param nomeAgencia
	 * @param endereco
	 * @param atendente
	 * @param gerente
	 * @param veiculo
	 */
	public AgenciaAutomotivaDto(Long idAgenciaAuto, String nomeAgencia, EnderecoDto endereco,
			Set<AtendenteDto> atendente, Set<GerenteDto> gerente, Set<VeiculoDto> veiculo) {
		super();
		this.idAgenciaAuto = idAgenciaAuto;
		this.nomeAgencia = nomeAgencia;
		this.endereco = endereco;
		this.atendente = atendente;
		this.gerente = gerente;
		this.veiculo = veiculo;
	}
	
	/**
	 * 
	 */
	public AgenciaAutomotivaDto(AgenciaAutomotiva agAutomotiva) {
		super();
		this.idAgenciaAuto = agAutomotiva.getIdAgenciaAuto();
		this.nomeAgencia = agAutomotiva.getNomeAgencia();
		this.endereco = new EnderecoDto(agAutomotiva.getEndereco());
		this.atendente = agAutomotiva.getListAtendente() == null? null : agAutomotiva.getListAtendente()
				.stream()
				.map(atendente -> new AtendenteDto(atendente))
				.collect(Collectors.toSet());
		this.gerente =  agAutomotiva.getListGerente() == null? null : agAutomotiva.getListGerente()
				.stream()
				.map(gerente -> new GerenteDto(gerente))
				.collect(Collectors.toSet());
		this.veiculo = agAutomotiva.getListVeiculo() == null? null : agAutomotiva.getListVeiculo()
				.stream()
				.map(veiculo -> new VeiculoDto(veiculo))
				.collect(Collectors.toSet());
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
	public EnderecoDto getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the atendente
	 */
	public Set<AtendenteDto> getAtendente() {
		return atendente;
	}

	/**
	 * @param atendente the atendente to set
	 */
	public void setAtendente(Set<AtendenteDto> atendente) {
		this.atendente = atendente;
	}

	/**
	 * @return the gerente
	 */
	public Set<GerenteDto> getGerente() {
		return gerente;
	}

	/**
	 * @param gerente the gerente to set
	 */
	public void setGerente(Set<GerenteDto> gerente) {
		this.gerente = gerente;
	}

	/**
	 * @return the veiculo
	 */
	public Set<VeiculoDto> getVeiculo() {
		return veiculo;
	}

	/**
	 * @param veiculo the veiculo to set
	 */
	public void setVeiculo(Set<VeiculoDto> veiculo) {
		this.veiculo = veiculo;
	}	
}
