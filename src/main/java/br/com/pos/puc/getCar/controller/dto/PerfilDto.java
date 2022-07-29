package br.com.pos.puc.getCar.controller.dto;


import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.enums.TipoUsuario;

public class PerfilDto {
	
	private Long id;
	
	private TipoUsuario tipoUsuario;

	/**
	 * @param id
	 * @param tipoUsuario
	 */
	public PerfilDto(Long id, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.tipoUsuario = tipoUsuario;
	}
	
	/**
	 * 
	 */
	public PerfilDto() {
		super();
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
	 * @return the tipoUsuario
	 */
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public PerfilDto converter(Perfil perfil) {
		this.setId(perfil.getId());
		this.setTipoUsuario(perfil.getTipoUsuario());
		return this;
	}

}
