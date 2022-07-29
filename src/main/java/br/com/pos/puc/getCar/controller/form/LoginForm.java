package br.com.pos.puc.getCar.controller.form;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.pos.puc.getCar.domain.Perfil;

public class LoginForm {
	private String login;
	private String senha;
	private List<PerfilForm> perfis;
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
	 * @return the perfis
	 */
	public List<PerfilForm> getPerfis() {
		return perfis;
	}
	/**
	 * @param perfis the perfis to set
	 */
	public void setPerfis(List<PerfilForm> perfis) {
		this.perfis = perfis;
	}
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}
}
