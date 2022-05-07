package br.com.pos.puc.getCar.domain;

import java.util.Objects;

public class Endereco {
	private String logradouro;
	private Integer numero;
	private Integer CEP;
	private String complemento;
	private String cidade;
	private String estado;
	
	/**
	 * 
	 */
	public Endereco() {
		super();
	}

	/**
	 * @param logradouro
	 * @param numero
	 * @param cEP
	 * @param complemento
	 * @param cidade
	 * @param estado
	 */
	public Endereco(String logradouro, Integer numero, Integer cEP, String complemento, String cidade, String estado) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		CEP = cEP;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CEP, cidade, complemento, estado, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(CEP, other.CEP) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estado, other.estado)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero);
	}
	
}
