package br.com.pos.puc.getCar.controller;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pos.puc.getCar.controller.dto.GrupoVeiculoDto;
import br.com.pos.puc.getCar.controller.dto.ModeloDto;
import br.com.pos.puc.getCar.controller.dto.ReservaDto;
import br.com.pos.puc.getCar.controller.dto.VeiculoDto;
import br.com.pos.puc.getCar.controller.form.ReservaForm;
import br.com.pos.puc.getCar.domain.Cliente;
import br.com.pos.puc.getCar.domain.GrupoDeVeiculos;
import br.com.pos.puc.getCar.domain.Modelo;
import br.com.pos.puc.getCar.domain.Reserva;
import br.com.pos.puc.getCar.domain.ReservaPK;
import br.com.pos.puc.getCar.domain.Usuario;
import br.com.pos.puc.getCar.domain.Veiculo;
import br.com.pos.puc.getCar.domain.enums.StatusReserva;
import br.com.pos.puc.getCar.exception.BusinessException;
import br.com.pos.puc.getCar.exception.NotFoundException;
import br.com.pos.puc.getCar.repository.ClienteRepository;
import br.com.pos.puc.getCar.repository.GrupoDeVeiculosRepository;
import br.com.pos.puc.getCar.repository.ReservaRepository;
import br.com.pos.puc.getCar.repository.UsuarioRepository;
import br.com.pos.puc.getCar.repository.VeiculoRepository;

@RestController
@RequestMapping("/locacao")
@CrossOrigin(origins = "http://localhost:3000")
public class LocacaoController {
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private GrupoDeVeiculosRepository gruVeiculosRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	private final static Logger logger = Logger.getLogger(LocacaoController.class);
	
	@GetMapping("/buscaVeiPorPeriodo")
	public ResponseEntity<List<GrupoVeiculoDto>> buscaVeiculoPorPeriodo(@RequestParam String dtHoraRetirada, @RequestParam String dtHoraDevolucao) {
		LocalDateTime dtHrAtual = LocalDateTime.now(ZoneId.systemDefault());
		LocalDateTime dtHrRetirada = LocalDateTime.parse(dtHoraRetirada);
		LocalDateTime dtHrDevolucao = LocalDateTime.parse(dtHoraDevolucao);
		
		// criterios para data inicial
		if(dtHrRetirada.isBefore(dtHrAtual)) {
			throw new NotFoundException(String.format("A data [%s] de inicio da reserva não pode ser anterior a atual!", convertDateToString(convertLocalTimeToDate(dtHrRetirada))), null);
			
		} else if(dtHrDevolucao.isBefore(dtHrRetirada)) {
			throw new NotFoundException(String.format("A data [%s] de devolução não pode ser anterior ao incio da reserva!", convertDateToString(convertLocalTimeToDate(dtHrDevolucao))), null);
			
		} else if(dtHrDevolucao.isBefore(dtHrRetirada.plusHours(24))) {
			throw new NotFoundException(String.format("A reserva não pode ter menos de 24 horas de duração!"), null);
		}
		
		List<Reserva> listReservasAtivas = reservaRepository.listaReservasPorStatus(StatusReserva.ATIVA.toString());

		Map<Long, Integer> mapReservaPorGrupo = new HashMap<>();
		for(Reserva reservaAtiva : listReservasAtivas) {
			// nesse for verificamos quais grupos possuem reservas para a mesma data que esta sendo buscada, considarando intervalo de
			// 1 dia antes para retirada e um dia depois da devolução, pois deve haver24h para vistoria/limpeza do veiculo 
			LocalDateTime thisDataRetirada = convertDateToLocalDt(reservaAtiva.getReservaPK().getDtHrRetiradaVeiculo()).minusDays(1);
			LocalDateTime thisDataPrevDev = convertDateToLocalDt(reservaAtiva.getDateDtHrPrevDevolucao()).plusDays(1);

			// ANOTANDO LOGICA PARA NÃO ESQUECER
			/**
			 * para cada data que conflitar não vamos retonar exception, vamos armazenar tais reservas agrupadas por grupo de veiculo,
			 * assim saberemos quqantas reservas o grupo tem para aquele periodo requisitado, dai basta comparar se o grupo possui
			 * quantidade de veiculos suficientes para as reservas encontradas mais a nova reserva, se tiver libera o grupo, se não
			 * não retorna o grupo na listagem
			 */
					
			// sequencia de condicionais para verificar conflitos de datas
			if(dtHrRetirada.isAfter(thisDataRetirada) && dtHrRetirada.isBefore(thisDataPrevDev)) {
				mapReservaPorGrupo.put(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo(), 
						mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) == null ? 1 : mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) +1);
			
			} else if(dtHrDevolucao.isAfter(thisDataRetirada) && dtHrDevolucao.isBefore(thisDataPrevDev)) {
				mapReservaPorGrupo.put(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo(), 
						mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) == null ? 1 : mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) +1);
			
			} else if(thisDataRetirada.isAfter(dtHrRetirada) && thisDataRetirada.isBefore(dtHrDevolucao)) {
				mapReservaPorGrupo.put(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo(), 
						mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) == null ? 1 : mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) +1);
			
			} else if(thisDataPrevDev.isAfter(dtHrRetirada) && thisDataPrevDev.isBefore(dtHrDevolucao)) {
				mapReservaPorGrupo.put(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo(), 
						mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) == null ? 1 : mapReservaPorGrupo.get(reservaAtiva.getGrupoVeiculo().getIdGrupoVeiculo()) +1);

			}
		}
		
		System.out.println(mapReservaPorGrupo);
		
		List<GrupoDeVeiculos> listGruposDisponiveisParaReserva = new ArrayList<>();
		
		// Listar os grupos de veiculos
		List<GrupoDeVeiculos> listGrupos = gruVeiculosRepository.findAll();
		if(listGrupos.isEmpty()) {
			throw new BusinessException("Não foram encontrados grupos de veiculos cadastrados no sistema!", null);
		}
		
		for(GrupoDeVeiculos grupo : listGrupos) {
			// primeiro verifica de o grupo está na relação de grupos que possuem reservas
			if(mapReservaPorGrupo.get(grupo.getIdGrupoVeiculo()) != null) {
				// se o grupo tem reservas verificamos se a quantidade de veiculos que o grupo tem é 
				// maior doque a quantidade de reservas associadas a ele, se for disponibiliza para reservas
				if(grupo.getListVeiculo().size() > mapReservaPorGrupo.get(grupo.getIdGrupoVeiculo())){
					listGruposDisponiveisParaReserva.add(grupo);
				}
			} else if(!grupo.getListVeiculo().isEmpty()) {
				// eh necessario que o grupo possua veiculos para ser disponibilizado para locação
				listGruposDisponiveisParaReserva.add(grupo);
			}
		}
		
		System.out.println("Grupos disponiveis: " + listGruposDisponiveisParaReserva);
		
		List<GrupoVeiculoDto> listGruVeiculoDto = listGruposDisponiveisParaReserva
				.stream()
				.map(gru -> (GrupoVeiculoDto) new GrupoVeiculoDto(gru))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listGruVeiculoDto);
		
	}
	
	@PostMapping("/salvarReserva")
	@Transactional
	public ResponseEntity<?> salvarReserva(@RequestBody ReservaForm reservaForm, UriComponentsBuilder uriBuilder){
		Reserva reserva = reservaForm.converter();
		
		// verifica se cliente informado existe no sistema
		Optional<Cliente> cliente = clienteRepository.findById(reserva.getReservaPK().getCliente().getIdUsuario());
		if(!cliente.isPresent()) {
			// usuario já existe, retornar erro
			throw new BusinessException(String.format("Cliente de id [%s] não consta no sistema!", reserva.getReservaPK().getCliente().getIdUsuario()),
					null);
		}
		// se encontrou cliente relacionar o objeto do bd a reserva
		reserva.getReservaPK().setCliente(cliente.get());
		
		Optional<GrupoDeVeiculos> gruVeiculo = gruVeiculosRepository.findById(reserva.getGrupoVeiculo().getIdGrupoVeiculo());
		if(!gruVeiculo.isPresent()) {
			throw new NotFoundException(String.format("Grupo de id [%s] não encontrado", reserva.getGrupoVeiculo().getIdGrupoVeiculo()), null);
		}
		// se encontrou grupo relacionar o objeto do bd a reserva
		reserva.setGrupoVeiculo(gruVeiculo.get());
		
		// quando é criada a reserva deverá ser associado a ela um codigo, que fara parte da chave primaria
		Random r = new Random();
		String idAleatorio ="RE" + String.valueOf(reservaRepository.count() + 1) + "-" + r.nextInt(900000);
		reserva.getReservaPK().setIdReserva(idAleatorio);
		
		// setar status incial
		reserva.setStatusReserva(StatusReserva.ATIVA);
		
		reservaRepository.save(reserva);
		
		URI uri = uriBuilder.path("/consultarReserva/{id}").buildAndExpand(reserva.getReservaPK().getIdReserva()).toUri();		
		return ResponseEntity.created(uri).body(new ReservaDto(reserva));
		
	}
	
	@GetMapping("/listarReservas")
	public ResponseEntity<List<ReservaDto>> listarReservas(){
				
		List<Reserva> listaReserva;
		listaReserva = reservaRepository.findAll();
				
		if(!listaReserva.isEmpty()) {
			List<ReservaDto> listReservaDto = new ArrayList<ReservaDto>();
			listaReserva.stream().forEach(reserva -> {
				listReservaDto.add(new ReservaDto(reserva));
			});
			
			return ResponseEntity.ok(listReservaDto);
		}
		
		throw new NotFoundException(String.format("Nenhuma reserva encontrada"), "a lista de reservas está vazia");
	}	
	
	@GetMapping("/consultarReserva/{idReserva}")
	public ResponseEntity<ReservaDto> consultarReserva(@PathVariable String idReserva){
		Optional<Reserva> reserva = reservaRepository.findByReservaPKIdReserva(idReserva);
		
		if(reserva.isPresent()) {
			return ResponseEntity.ok(new ReservaDto(reserva.get()));
		}
		
		throw new NotFoundException(String.format("Reserva de id [%s] não encontrada", idReserva), null);
	}
	
	@DeleteMapping("/excluirReserva/{idReserva}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable String idReserva){
		Optional<Reserva> reserva = reservaRepository.findByReservaPKIdReserva(idReserva);
		if(reserva.isPresent()) {
			reservaRepository.deleteById(reserva.get().getReservaPK());
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	private Date convertLocalTimeToDate(LocalDateTime data) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(data.atZone(defaultZoneId).toInstant());
		return date;
	}
	
	private String convertDateToString(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(data);
	}
	
	private LocalDateTime convertDateToLocalDt(Date data) {
		LocalDateTime localDT = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		return localDT;
	}
}
