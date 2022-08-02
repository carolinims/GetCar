package br.com.pos.puc.getCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Reserva;
import br.com.pos.puc.getCar.domain.ReservaPK;

public interface ReservaRepository extends JpaRepository<Reserva, ReservaPK>{

}
