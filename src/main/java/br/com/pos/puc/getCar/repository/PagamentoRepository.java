package br.com.pos.puc.getCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
