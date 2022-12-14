package br.com.pos.puc.getCar.controller.form;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.pos.puc.getCar.domain.Cliente;
import br.com.pos.puc.getCar.domain.Usuario;

public class ClienteForm {
	
	@NotNull @NotEmpty
	private UsuarioForm usuario;
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private Long documento;
	
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { "M/d/yy", "dd.MM.yyyy" }) @NotNull @NotEmpty
	private Date dataNasc;
	
	@NotNull @NotEmpty
	private String cnh;
	
	@NotNull @NotEmpty
	private String genero;
	
	@NotNull @NotEmpty
	private Integer telefone;
	
	@NotNull @NotEmpty
	private String nacionalidade;
	
	@NotNull @NotEmpty
	private EnderecoForm endereco;

	/**
	 * @return the usuario
	 */
	public UsuarioForm getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioForm usuario) {
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
	public EnderecoForm getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoForm endereco) {
		this.endereco = endereco;
	}

	public Cliente converter() {
		Usuario u = usuario != null ? this.usuario.converter() : null;
		return new Cliente(u == null ? null : u.getIdUsuario(),
				u == null ? null : u.getLogin(), 
				u == null ? null : u.getSenha(), 
				u == null ? null : u.getPerfis(), 
				nome, 
				documento, 
				dataNasc, 
				cnh, 
				genero, 
				this.endereco == null? null : this.endereco.converter(), 
				telefone, 
				nacionalidade);
	}
}
