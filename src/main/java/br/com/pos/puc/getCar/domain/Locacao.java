package br.com.pos.puc.getCar.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pos.puc.getCar.domain.enums.StatusLocacao;

@Entity
public class Locacao {
	
	@EmbeddedId
	private LocacaoPK locacaoPK;
	private Date DtHrDevolucaoVeiculo;
	
	@Enumerated(EnumType.STRING)
	private StatusLocacao statusLocacao;
	private Date DtHrPrevDevolucao;
	
	public Locacao() {
		super();
	}

	/**
	 * @param locacaoPK
	 * @param dtHrDevolucaoVeiculo
	 * @param statusLocacao
	 * @param dtHrPrevDevolucao
	 */
	public Locacao(LocacaoPK locacaoPK, Date dtHrDevolucaoVeiculo, StatusLocacao statusLocacao,
			Date dtHrPrevDevolucao) {
		super();
		this.locacaoPK = locacaoPK;
		DtHrDevolucaoVeiculo = dtHrDevolucaoVeiculo;
		this.statusLocacao = statusLocacao;
		DtHrPrevDevolucao = dtHrPrevDevolucao;
	}

	@Override
	public String toString() {
		return "Locacao [locacaoPK=" + locacaoPK.toString() + ", DtHrDevolucaoVeiculo=" + DtHrDevolucaoVeiculo + ", statusLocacao="
				+ statusLocacao + ", DtHrPrevDevolucao=" + DtHrPrevDevolucao + "]";
	}

	/**
	 * @return the locacaoPK
	 */
	public LocacaoPK getLocacaoPK() {
		return locacaoPK;
	}

	/**
	 * @param locacaoPK the locacaoPK to set
	 */
	public void setLocacaoPK(LocacaoPK locacaoPK) {
		this.locacaoPK = locacaoPK;
	}

	/**
	 * @return the dtHrDevolucaoVeiculo
	 */
	public Date getDtHrDevolucaoVeiculo() {
		return DtHrDevolucaoVeiculo;
	}

	/**
	 * @param dtHrDevolucaoVeiculo the dtHrDevolucaoVeiculo to set
	 */
	public void setDtHrDevolucaoVeiculo(Date dtHrDevolucaoVeiculo) {
		DtHrDevolucaoVeiculo = dtHrDevolucaoVeiculo;
	}

	/**
	 * @return the statusLocacao
	 */
	public StatusLocacao getStatusLocacao() {
		return statusLocacao;
	}

	/**
	 * @param statusLocacao the statusLocacao to set
	 */
	public void setStatusLocacao(StatusLocacao statusLocacao) {
		this.statusLocacao = statusLocacao;
	}

	/**
	 * @return the dtHrPrevDevolucao
	 */
	public Date getDtHrPrevDevolucao() {
		return DtHrPrevDevolucao;
	}

	/**
	 * @param dtHrPrevDevolucao the dtHrPrevDevolucao to set
	 */
	public void setDtHrPrevDevolucao(Date dtHrPrevDevolucao) {
		DtHrPrevDevolucao = dtHrPrevDevolucao;
	}

	
}
