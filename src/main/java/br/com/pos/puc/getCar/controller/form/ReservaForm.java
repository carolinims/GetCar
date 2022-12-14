package br.com.pos.puc.getCar.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.pos.puc.getCar.domain.Reserva;
import br.com.pos.puc.getCar.domain.ReservaPK;
import br.com.pos.puc.getCar.domain.enums.StatusReserva;

public class ReservaForm {
	private String idReserva;
	private ClienteForm cliente;
	private VeiculoForm veiculo;
	private String dtHrRetiradaVeiculo;
	private GrupoVeiculoForm grupoVeiculo;
	private String dtHrPrevDevolucao;
	private PagamentoForm pagamento;
	private StatusReserva statusReserva;
	/**
	 * @return the idReserva
	 */
	public String getIdReserva() {
		return idReserva;
	}
	/**
	 * @param idReserva the idReserva to set
	 */
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	/**
	 * @return the cliente
	 */
	public ClienteForm getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteForm cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the veiculo
	 */
	public VeiculoForm getVeiculo() {
		return veiculo;
	}
	/**
	 * @param veiculo the veiculo to set
	 */
	public void setVeiculo(VeiculoForm veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * @return the grupoVeiculo
	 */
	public GrupoVeiculoForm getGrupoVeiculo() {
		return grupoVeiculo;
	}
	/**
	 * @param grupoVeiculo the grupoVeiculo to set
	 */
	public void setGrupoVeiculo(GrupoVeiculoForm grupoVeiculo) {
		this.grupoVeiculo = grupoVeiculo;
	}
	/**
	 * @return the pagamento
	 */
	public PagamentoForm getPagamento() {
		return pagamento;
	}
	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(PagamentoForm pagamento) {
		this.pagamento = pagamento;
	}
	/**
	 * @return the dtHrRetiradaVeiculo
	 */
	public String getDtHrRetiradaVeiculo() {
		return dtHrRetiradaVeiculo;
	}
		
	/**
	 * @return the statusReserva
	 */
	public StatusReserva getStatusReserva() {
		return statusReserva;
	}
	/**
	 * @param statusReserva the statusReserva to set
	 */
	public void setStatusReserva(StatusReserva statusReserva) {
		this.statusReserva = statusReserva;
	}
	
	/**
	 * @return the dtHrRetiradaVeiculo
	 */
	public Date getDtHrRetiradaVeiculoConvertida() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss"); 
		Date data = null;
		try {
			data = formato.parse(dtHrRetiradaVeiculo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * @param dtHrRetiradaVeiculo the dtHrRetiradaVeiculo to set
	 */
	public void setDtHrRetiradaVeiculo(String dtHrRetiradaVeiculo) {
		this.dtHrRetiradaVeiculo = dtHrRetiradaVeiculo;
	}
	/**
	 * @return the dtHrPrevDevolucao
	 */
	public String getDtHrPrevDevolucao() {
		return dtHrPrevDevolucao;
	}
	
	/**
	 * @return the dtHrPrevDevolucao
	 */
	public Date getDtHrPrevDevolucaoConvertida() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss"); 
		Date data = null;
		try {
			data = formato.parse(dtHrPrevDevolucao);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * @param dtHrPrevDevolucao the dtHrPrevDevolucao to set
	 */
	public void setDtHrPrevDevolucao(String dtHrPrevDevolucao) {
		this.dtHrPrevDevolucao = dtHrPrevDevolucao;
	}
	
	@Override
	public String toString() {
		return "ReservaForm [idReserva=" + idReserva + ", cliente=" + cliente + ", veiculo=" + veiculo
				+ ", dtHrRetiradaVeiculo=" + dtHrRetiradaVeiculo + ", grupoVeiculo=" + grupoVeiculo
				+ ", dtHrPrevDevolucao=" + dtHrPrevDevolucao + ", pagamento=" + pagamento + "]";
	}
	public Reserva converter() {
		ReservaPK pk = new ReservaPK(this.getCliente().converter(), 
				veiculo == null ? null : veiculo.converter(), 
				this.getDtHrRetiradaVeiculoConvertida());
		return new Reserva(pk, 
				this.getGrupoVeiculo().converter(), 
				this.getDtHrPrevDevolucaoConvertida(), 
				this.getPagamento().converter(),
				this.getStatusReserva());
	}
}
