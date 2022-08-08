package br.com.pos.puc.getCar.controller.form;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pos.puc.getCar.domain.AgenciaAutomotiva;


public class AgenciaAutomotivaForm {
	
	@NotNull @NotEmpty
	private Long idAgenciaAuto;
	
	@NotNull @NotEmpty
	private String nomeAgencia;
	private EnderecoForm enderecoForm;
	private Set<AtendenteForm> listAtendenteForm;
	private Set<GerenteForm> listGerenteForm;
	private Set<VeiculoForm> listVeiculoForm;
	
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
	 * @return the enderecoForm
	 */
	public EnderecoForm getEnderecoForm() {
		return enderecoForm;
	}
	/**
	 * @param enderecoForm the enderecoForm to set
	 */
	public void setEnderecoForm(EnderecoForm enderecoForm) {
		this.enderecoForm = enderecoForm;
	}
	/**
	 * @return the listAtendenteForm
	 */
	public Set<AtendenteForm> getListAtendenteForm() {
		return listAtendenteForm;
	}
	/**
	 * @param listAtendenteForm the listAtendenteForm to set
	 */
	public void setListAtendenteForm(Set<AtendenteForm> listAtendenteForm) {
		this.listAtendenteForm = listAtendenteForm;
	}
	/**
	 * @return the listGerenteForm
	 */
	public Set<GerenteForm> getListGerenteForm() {
		return listGerenteForm;
	}
	/**
	 * @param listGerenteForm the listGerenteForm to set
	 */
	public void setListGerenteForm(Set<GerenteForm> listGerenteForm) {
		this.listGerenteForm = listGerenteForm;
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
	
	public AgenciaAutomotiva converter() {
		
		return new AgenciaAutomotiva(this.getIdAgenciaAuto(), 
				this.getNomeAgencia(), 
				getEnderecoForm() == null? null : this.getEnderecoForm().converter(),
				
				getListAtendenteForm() == null ? null : this.getListAtendenteForm()
				.stream()
				.map(atendenteForm -> atendenteForm.converter())
				.collect(Collectors.toSet()), 
				
				getListGerenteForm() == null ? null : this.getListGerenteForm()
				.stream()
				.map(gerenteForm -> gerenteForm.converter())
				.collect(Collectors.toSet()), 
								
				getListVeiculoForm() == null ? null : this.getListVeiculoForm()
				.stream()
				.map(veiculoForm -> veiculoForm.converter())
				.collect(Collectors.toSet()));
	}
	
	
}
