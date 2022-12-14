package br.com.pos.puc.getCar.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Long documento;
	private Date dataNasc;
	private String cnh;
	private String genero;
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
	private Endereco endereco;
	private Integer telefone;
	private String nacionalidade;
	
	@OneToMany(mappedBy = "locacaoPK.idLocacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Locacao> listLocacoes;
		
	@OneToMany(mappedBy = "idMulta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Multa> listMultas;
	
	/**
	 * 
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nome
	 * @param documento
	 * @param dataNasc
	 * @param cnh
	 * @param genero
	 * @param endereco
	 * @param telefone
	 * @param nacionalidade
	 * @param listLocacoes
	 * @param listMultas
	 */
	public Cliente(Long id, String login, String senha, List<Perfil> perfis, String nome, Long documento, Date dataNasc, String cnh, String genero, Endereco endereco,
			Integer telefone, String nacionalidade, Set<Locacao> listLocacoes, Set<Multa> listMultas) {
		super(id, login, senha, perfis);
		this.nome = nome;
		this.documento = documento;
		this.dataNasc = dataNasc;
		this.cnh = cnh;
		this.genero = genero;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nacionalidade = nacionalidade;
		this.listLocacoes = listLocacoes;
		this.listMultas = listMultas;
	}

	/**
	 * @param nome
	 * @param documento
	 * @param dataNasc
	 * @param cnh
	 * @param genero
	 * @param endereco
	 * @param telefone
	 * @param nacionalidade
	 */
	public Cliente(Long id, String login, String senha, List<Perfil> perfis, String nome, Long documento, Date dataNasc, String cnh, String genero, Endereco endereco,
			Integer telefone, String nacionalidade) {
		super(id, login, senha, perfis);
		this.nome = nome;
		this.documento = documento;
		this.dataNasc = dataNasc;
		this.cnh = cnh;
		this.genero = genero;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nacionalidade = nacionalidade;
	}

	
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", documento=" + documento + ", dataNasc=" + dataNasc + ", cnh=" + cnh
				+ ", genero=" + genero + ", endereco=" + endereco + ", telefone=" + telefone + ", nacionalidade="
				+ nacionalidade + ", listLocacoes=" + listLocacoes + ", listMultas=" + listMultas + "]";
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

	/**
	 * @return the cnh
	 */
	public String getCnh() {
		return cnh;
	}

	/**
	 * @param cnh the cnh to set
	 */
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	/**
	 * @return the listLocacoes
	 */
	public Set<Locacao> getListLocacoes() {
		return listLocacoes;
	}

	/**
	 * @param listLocacoes the listLocacoes to set
	 */
	public void setListLocacoes(Set<Locacao> listLocacoes) {
		this.listLocacoes = listLocacoes;
	}

	/**
	 * @return the listMultas
	 */
	public Set<Multa> getListMultas() {
		return listMultas;
	}

	/**
	 * @param listMultas the listMultas to set
	 */
	public void setListMultas(Set<Multa> listMultas) {
		this.listMultas = listMultas;
	}
	
}
