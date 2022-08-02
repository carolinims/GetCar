package br.com.pos.puc.getCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.puc.getCar.domain.Locacao;
import br.com.pos.puc.getCar.domain.LocacaoPK;

public interface LocacaoRepository extends JpaRepository<Locacao, LocacaoPK>{

}
