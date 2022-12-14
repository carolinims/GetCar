package br.com.pos.puc.getCar.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.Usuario;

public class UsuarioForm {

	@NotNull @NotEmpty @Length(min = 20)
	private String login;
	
	@NotNull @NotEmpty @Length (min = 8)
	private String senha;
	
	@NotNull @NotEmpty
	private List<PerfilForm> perfis;
	
	private Long idUsuario;
	
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

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario converter() {
		return new Usuario(this.idUsuario, this.login, this.senha, 
				perfis == null || perfis.isEmpty()? null : perfis.stream()
				.map(perfil -> (Perfil) perfil.converter())
				.collect(Collectors.toList()));
	}
	
}
