package br.com.pos.puc.getCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long>{

}
