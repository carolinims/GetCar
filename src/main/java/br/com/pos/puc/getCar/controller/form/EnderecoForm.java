package br.com.pos.puc.getCar.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.pos.puc.getCar.domain.Endereco;

public class EnderecoForm {
	
	@NotNull @NotEmpty
	private String logradouro;
	
	@NotNull @NotEmpty
	private Integer numero;
	
	@NotNull @NotEmpty
	private String cep;
	
	@NotNull @NotEmpty
	private String complemento;
	
	@NotNull @NotEmpty
	private String cidade;
	
	@NotNull @NotEmpty
	private String estado;

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the cEP
	 */
	public String getCEP() {
		return cep;
	}

	/**
	 * @param cEP the cEP to set
	 */
	public void setCEP(String cEP) {
		cep = cEP;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Endereco converter() {
		return new Endereco(null, logradouro, numero, cep, complemento, cidade, estado);
	}
}
