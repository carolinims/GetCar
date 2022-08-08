package br.com.pos.puc.getCar.controller.dto;

import java.util.Date;
import java.util.stream.Collectors;

import br.com.pos.puc.getCar.domain.Cliente;

public class ClienteDto {
	
	private UsuarioDto usuario;
	private String nome;
	private Long documento;
	private Date dataNasc;
	private String cnh;
	private String genero;
	private Integer telefone;
	private String nacionalidade;
	private EnderecoDto endereco;
	
	/**
	 * @param usuario
	 * @param nome
	 * @param documento
	 * @param dataNasc
	 * @param cNH
	 * @param genero
	 * @param telefone
	 * @param nacionalidade
	 * @param endereco
	 */
	public ClienteDto(UsuarioDto usuario, String nome, Long documento, Date dataNasc, String cnh, String genero,
			Integer telefone, String nacionalidade, EnderecoDto endereco) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.documento = documento;
		this.dataNasc = dataNasc;
		this.cnh = cnh;
		this.genero = genero;
		this.telefone = telefone;
		this.nacionalidade = nacionalidade;
		this.endereco = endereco;
	}
	
	/**
	 * @param usuario
	 * @param nome
	 * @param documento
	 * @param dataNasc
	 * @param cNH
	 * @param genero
	 * @param telefone
	 * @param nacionalidade
	 * @param endereco
	 */
	public ClienteDto(Cliente cliente) {
		super();
		this.usuario = new UsuarioDto(cliente.getIdUsuario(), cliente.getLogin(), cliente.getSenha(), 
				cliente.getPerfis()
				.stream()
				.map(perfil -> new PerfilDto().converter(perfil))
				.collect(Collectors.toList()));
		
		this.nome = cliente.getNome();
		this.documento = cliente.getDocumento();
		this.dataNasc = cliente.getDataNasc();
		this.cnh = cliente.getCNH();
		this.genero = cliente.getGenero();
		this.telefone = cliente.getTelefone();
		this.nacionalidade = cliente.getNacionalidade();
		this.endereco = new EnderecoDto(cliente.getEndereco());
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDto getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
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
	public Long getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(Long documento) {
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
	public String getCNH() {
		return cnh;
	}
	/**
	 * @param cNH the cNH to set
	 */
	public void setCNH(String cNH) {
		cnh = cNH;
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
	/**
	 * @return the endereco
	 */
	public EnderecoDto getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}
}
