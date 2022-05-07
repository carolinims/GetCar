package br.com.pos.puc.getCar.domain;

import java.util.Objects;

public class Usuario {
	private Integer id;
	private String login;
	private String senha;
	private PerfilUsuario perfil;

	/**
	 * 
	 */
	public Usuario() {
	}

	/**
	 * @param id
	 * @param login
	 * @param senha
	 * @param perfil
	 */
	public Usuario(Integer id, String login, String senha, PerfilUsuario perfil) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the perfil
	 */
	public PerfilUsuario getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}


}
