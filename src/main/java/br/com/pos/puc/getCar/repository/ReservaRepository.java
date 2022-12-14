package br.com.pos.puc.getCar.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pos.puc.getCar.domain.Reserva;
import br.com.pos.puc.getCar.domain.ReservaPK;
import br.com.pos.puc.getCar.domain.enums.StatusReserva;

public interface ReservaRepository extends JpaRepository<Reserva, ReservaPK>{

	Optional<Reserva> findByReservaPKIdReserva(String idReserva);
	
	@Query(value = "select * from reserva where reserva.status_reserva like :status", nativeQuery = true )
	List<Reserva> listaReservasPorStatus(@Param("status") String statusReserva);
}
