package br.com.pos.puc.getCar.domain;

import java.util.Date;

public class Cliente extends Usuario{

	private String nome;
	private Integer documento;
	private Date dataNasc;
	private Integer CNH;
	private String genero;
	private Endereco endereco;
	private Integer telefone;
	private String nacionalidade;
		
	/**
	 * 
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nome
	 * @param cPF
	 * @param dataNasc
	 * @param cNH
	 * @param genero
	 * @param endereco
	 */
	public Cliente(Integer id, String login, String senha, PerfilUsuario perfil, String nome, Integer documento, Date dataNasc, Integer CNH, String genero, Endereco endereco, Integer telefone, String nacionalidade) {
		super(id, login, senha, perfil);
		this.nome = nome;
		this.documento = documento;
		this.dataNasc = dataNasc;
		this.CNH = CNH;
		this.genero = genero;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nacionalidade = nacionalidade;
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
	 * @return the documento
	 */
	public Integer getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	/**
	 * @return the dataNasc
	 */
	public Date getDataNasc() {
		return dataNasc;
	}

	/**
	 * @param dataNasc the dataNasc to set
	 */
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	/**
	 * @return the cNH
	 */
	public Integer getCNH() {
		return CNH;
	}

	/**
	 * @param cNH the cNH to set
	 */
	public void setCNH(Integer cNH) {
		CNH = cNH;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public Integer getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}

	/**
	 * @param nacionalidade the nacionalidade to set
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
