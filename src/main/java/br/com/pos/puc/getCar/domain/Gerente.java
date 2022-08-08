package br.com.pos.puc.getCar.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("G")
public class Gerente extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idAgenciaAuto")
	private AgenciaAutomotiva agAutomotiva;

	public Gerente() {
		super();
	}

	/**
	 * @param nome
	 * @param agAutomotiva
	 */
	public Gerente(Long id, String login, String senha, List<Perfil> perfis, String nome, AgenciaAutomotiva agAutomotiva) {
		super(id, login, senha, perfis);
		this.nome = nome;
		this.agAutomotiva = agAutomotiva;
	}

	@Override
	public String toString() {
		return "Gerente [nome=" + nome + ", agAutomotiva=" + agAutomotiva + "]";
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

	/**
	 * @return the agAutomotiva
	 */
	public AgenciaAutomotiva getAgAutomotiva() {
		return agAutomotiva;
	}

	/**
	 * @param agAutomotiva the agAutomotiva to set
	 */
	public void setAgAutomotiva(AgenciaAutomotiva agAutomotiva) {
		this.agAutomotiva = agAutomotiva;
	}

	
}
