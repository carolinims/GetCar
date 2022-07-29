package br.com.pos.puc.getCar.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoUsuario{
	ADMINISTRADOR("ADMINISTRADOR"),
	CLIENTE("CLIENTE"),
	ATENDENTE("ATENDENTE"),
	GERENTE("GERENTE");
	
	private String cod;
	
	private TipoUsuario(String cod) {
		this.cod = cod;
	}
	
	public String getPerfilCod() {
		return this.cod;
	}
	/**
	 * Retorna o perfil do usuario a partir do codigo
	 * @param value
	 * @return @PerfilUsuario
	 */
	
	@JsonCreator
	public static TipoUsuario getPerfilUsuario(String value) {
		for(TipoUsuario toUsuario : TipoUsuario.values()) {
			if(toUsuario.getPerfilCod().equals(value)) {
				return toUsuario;
			}
		}
		return null;
	}
}
