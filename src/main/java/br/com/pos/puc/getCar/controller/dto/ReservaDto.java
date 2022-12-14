package br.com.pos.puc.getCar.controller.dto;

import br.com.pos.puc.getCar.domain.Reserva;
import br.com.pos.puc.getCar.domain.enums.StatusReserva;

public class ReservaDto {
	private String idReserva;
	private ClienteDto cliente;
	private VeiculoDto veiculo;
	private String dtHrRetiradaVeiculo;
	private GrupoVeiculoDto grupoVeiculo;
	private String dtHrPrevDevolucao;
	private PagamentoDto pagamento;
	private StatusReserva statusReserva;
	
	/**
	 * @param idReserva
	 * @param cliente
	 * @param veiculo
	 * @param dtHrRetiradaVeiculo
	 * @param grupoVeiculo
	 * @param dtHrPrevDevolucao
	 * @param pagamento
	 */
	public ReservaDto(String idReserva, ClienteDto cliente, VeiculoDto veiculo, String dtHrRetiradaVeiculo,
			GrupoVeiculoDto grupoVeiculo, String dtHrPrevDevolucao, PagamentoDto pagamento, StatusReserva statusReserva) {
		super();
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dtHrRetiradaVeiculo = dtHrRetiradaVeiculo;
		this.grupoVeiculo = grupoVeiculo;
		this.dtHrPrevDevolucao = dtHrPrevDevolucao;
		this.pagamento = pagamento;
		this.statusReserva = statusReserva;
	}
	

	public ReservaDto(Reserva reserva) {
		this.idReserva = reserva.getReservaPK().getIdReserva();
		this.cliente = new ClienteDto(reserva.getReservaPK().getCliente());
		this.grupoVeiculo = new GrupoVeiculoDto(reserva.getGrupoVeiculo());
		this.dtHrPrevDevolucao = reserva.getDateDtHrPrevDevolucao().toString();
		this.dtHrRetiradaVeiculo = reserva.getReservaPK().getDtHrRetiradaVeiculo().toString();
		this.pagamento = new PagamentoDto(reserva.getPagamento());
		this.statusReserva = reserva.getStatusReserva();
	}

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
	public ClienteDto getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the veiculo
	 */
	public VeiculoDto getVeiculo() {
		return veiculo;
	}
	/**
	 * @param veiculo the veiculo to set
	 */
	public void setVeiculo(VeiculoDto veiculo) {
		this.veiculo = veiculo;
	}
	/**
	 * @return the dtHrRetiradaVeiculo
	 */
	public String getDtHrRetiradaVeiculo() {
		return dtHrRetiradaVeiculo;
	}
	/**
	 * @param dtHrRetiradaVeiculo the dtHrRetiradaVeiculo to set
	 */
	public void setDtHrRetiradaVeiculo(String dtHrRetiradaVeiculo) {
		this.dtHrRetiradaVeiculo = dtHrRetiradaVeiculo;
	}
	/**
	 * @return the grupoVeiculo
	 */
	public GrupoVeiculoDto getGrupoVeiculo() {
		return grupoVeiculo;
	}
	/**
	 * @param grupoVeiculo the grupoVeiculo to set
	 */
	public void setGrupoVeiculo(GrupoVeiculoDto grupoVeiculo) {
		this.grupoVeiculo = grupoVeiculo;
	}
	/**
	 * @return the dtHrPrevDevolucao
	 */
	public String getDtHrPrevDevolucao() {
		return dtHrPrevDevolucao;
	}
	/**
	 * @param dtHrPrevDevolucao the dtHrPrevDevolucao to set
	 */
	public void setDtHrPrevDevolucao(String dtHrPrevDevolucao) {
		this.dtHrPrevDevolucao = dtHrPrevDevolucao;
	}
	/**
	 * @return the pagamento
	 */
	public PagamentoDto getPagamento() {
		return pagamento;
	}
	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(PagamentoDto pagamento) {
		this.pagamento = pagamento;
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
	
}
