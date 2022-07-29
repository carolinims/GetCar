package br.com.pos.puc.getCar.controller.dto;

import br.com.pos.puc.getCar.domain.Endereco;

public class EnderecoDto {
	private Long id;
	private String logradouro;
	private Integer numero;
	private String cep;
	private String complemento;
	private String cidade;
	private String estado;
	
	/**
	 * @param id
	 * @param logradouro
	 * @param numero
	 * @param cEP
	 * @param complemento
	 * @param cidade
	 * @param estado
	 */
	public EnderecoDto(Long id, String logradouro, Integer numero, String cEP, String complemento, String cidade,
			String estado) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cEP;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

	/**
	 * @param id
	 * @param logradouro
	 * @param numero
	 * @param cEP
	 * @param complemento
	 * @param cidade
	 * @param estado
	 */
	public EnderecoDto(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.cep = endereco.getCEP();
		this.complemento = endereco.getComplemento();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
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
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
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

}
