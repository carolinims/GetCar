package br.com.pos.puc.getCar.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.Usuario;

public class UsuarioDto {
	private Long id;
	private String login;
	private String senha;
	private PerfilDto perfil;
	
	/**
	 * @param id
	 * @param login
	 * @param senha
	 */
	public UsuarioDto(Long id, String login, String senha, PerfilDto perfil) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getIdUsuario();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		List<PerfilDto> listPerfilDto = new ArrayList<>();
		for(Perfil perfil : usuario.getPerfis()) {
			listPerfilDto.add(new PerfilDto().converter(perfil));
		}
		this.perfil = listPerfilDto.get(0) ;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	public PerfilDto getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilDto perfil) {
		this.perfil = perfil;
	}

	
}
