package br.com.pos.puc.getCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
