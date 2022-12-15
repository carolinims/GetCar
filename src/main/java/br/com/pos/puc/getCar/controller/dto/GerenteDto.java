package br.com.pos.puc.getCar.controller.dto;

import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.Gerente;

public class GerenteDto {
	
	private UsuarioDto usuario;
	private String nome;
	private AgenciaAutomotivaDto agAutomotiva;
	
	/**
	 * @param usuario
	 * @param nome
	 * @param agAutomotiva
	 */
	public GerenteDto(UsuarioDto usuario, String nome, AgenciaAutomotivaDto agAutomotiva) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.agAutomotiva = agAutomotiva;
	}
		
	/**
	 * 
	 */
	public GerenteDto(Gerente gerente) {
		super();
		this.usuario = new UsuarioDto(gerente.getIdUsuario(), 
				gerente.getLogin(),
				gerente.getNome(), 
				gerente.getPerfis().stream()
				.map(perfil -> new PerfilDto().converter(perfil))
				.collect(Collectors.toList()).get(0));
		this.nome = gerente.getNome();
		this.agAutomotiva = new AgenciaAutomotivaDto(gerente.getAgAutomotiva());
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDto getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the agAutomotiva
	 */
	public AgenciaAutomotivaDto getAgAutomotiva() {
		return agAutomotiva;
	}
	/**
	 * @param agAutomotiva the agAutomotiva to set
	 */
	public void setAgAutomotiva(AgenciaAutomotivaDto agAutomotiva) {
		this.agAutomotiva = agAutomotiva;
	}
	
}
