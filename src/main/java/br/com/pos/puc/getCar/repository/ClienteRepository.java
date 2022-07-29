package br.com.pos.puc.getCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
