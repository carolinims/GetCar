package br.com.pos.puc.getCar.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import br.com.pos.puc.getCar.domain.enums.TipoUsuario;

@Entity
public class Perfil implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	/**
	 * @param id
	 * @param tipoUsuario
	 */
	public Perfil(Long id, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * 
	 */
	public Perfil() {
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

	@Override
	public String getAuthority() {
		return tipoUsuario.getPerfilCod();
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
}
