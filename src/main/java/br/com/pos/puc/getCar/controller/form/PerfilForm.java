package br.com.pos.puc.getCar.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pos.puc.getCar.domain.Perfil;
import br.com.pos.puc.getCar.domain.enums.TipoUsuario;

public class PerfilForm {
	
	@NotNull @NotEmpty
	private Long id;
	
	private TipoUsuario tipoUsuario;

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
	
	public Perfil converter() {
		return new Perfil(this.id, this.tipoUsuario);
	}
	
}
