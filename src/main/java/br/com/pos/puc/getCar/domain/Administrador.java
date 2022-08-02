package br.com.pos.puc.getCar.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AD")
public class Administrador extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	/**
	 * 
	 */
	public Administrador() {
		super();
	}

	/**
	 * @param nome
	 */
	public Administrador(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Administrador [nome=" + nome + "]";
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
	
	
	
}
