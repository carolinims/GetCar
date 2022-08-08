package br.com.pos.puc.getCar.controller.form;

import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.AgenciaAutomotiva;
import br.com.pos.puc.getCar.domain.Gerente;

public class GerenteForm {
	
	private UsuarioForm usuarioForm;
	private String nome;
	private AgenciaAutomotiva agAutomotiva;
	/**
	 * @return the usuarioForm
	 */
	public UsuarioForm getUsuarioForm() {
		return usuarioForm;
	}
	/**
	 * @param usuarioForm the usuarioForm to set
	 */
	public void setUsuarioForm(UsuarioForm usuarioForm) {
		this.usuarioForm = usuarioForm;
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
	public AgenciaAutomotiva getAgAutomotiva() {
		return agAutomotiva;
	}
	/**
	 * @param agAutomotiva the agAutomotiva to set
	 */
	public void setAgAutomotiva(AgenciaAutomotiva agAutomotiva) {
		this.agAutomotiva = agAutomotiva;
	}
	
	public Gerente converter() {
		return new Gerente(null, 
				this.usuarioForm.getLogin(),
				this.getUsuarioForm().getSenha(),
				
				this.getUsuarioForm().getPerfis()
				.stream()
				.map(perfil -> perfil.converter())
				.collect(Collectors.toList()),

				this.nome,
				this.agAutomotiva);
	}
	
}
