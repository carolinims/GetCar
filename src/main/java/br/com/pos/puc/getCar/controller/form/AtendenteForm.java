package br.com.pos.puc.getCar.controller.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.AgenciaAutomotiva;
import br.com.pos.puc.getCar.domain.Atendente;
import br.com.pos.puc.getCar.domain.Perfil;

public class AtendenteForm {
	
	private UsuarioForm usuario;
	private String nome;
	private AgenciaAutomotivaForm agAutomotiva;
	
	/**
	 * @return the usuario
	 */
	public UsuarioForm getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioForm usuario) {
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
	public AgenciaAutomotivaForm getAgAutomotiva() {
		return agAutomotiva;
	}
	/**
	 * @param agAutomotiva the agAutomotiva to set
	 */
	public void setAgAutomotiva(AgenciaAutomotivaForm agAutomotiva) {
		this.agAutomotiva = agAutomotiva;
	}
	public Atendente converter() {
		List<Perfil> p = new ArrayList<>();
		p.add(getUsuario().getPerfil().converter());
		return new Atendente(null, 
				this.usuario.getLogin(),
				this.getUsuario().getSenha(),
				p,

				this.nome,
				getAgAutomotiva() == null? null : this.agAutomotiva.converter()) ;
	}
}
