package br.com.pos.puc.getCar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	Veiculo findByPlacaVeiculo(String placa);
	
	Boolean findByRenavam(String renavam);
	
	Page<Veiculo> findByModeloMarca(String marca, Pageable paginacao);

	
//	Boolean existsPlacaVeiculo(String placa);
}
