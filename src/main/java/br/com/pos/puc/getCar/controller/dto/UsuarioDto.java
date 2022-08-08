package br.com.pos.puc.getCar.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.Usuario;

public class UsuarioDto {
	private Long id;
	private String login;
	private String senha;
	private List<PerfilDto> perfis;
	
	/**
	 * @param id
	 * @param login
	 * @param senha
	 */
	public UsuarioDto(Long id, String login, String senha, List<PerfilDto> perfis) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.perfis = perfis;
	}
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getIdUsuario();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		List<PerfilDto> listPerfilDto = new ArrayList<>();
		for(Perfil perfil : usuario.getPerfis()) {
			listPerfilDto.add(new PerfilDto().converter(perfil));
		}
		this.perfis = listPerfilDto ;
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
	 * @return the perfis
	 */
	public List<PerfilDto> getPerfis() {
		return perfis;
	}

	/**
	 * @param perfis the perfis to set
	 */
	public void setPerfis(List<PerfilDto> perfis) {
		this.perfis = perfis;
	}

	
}
