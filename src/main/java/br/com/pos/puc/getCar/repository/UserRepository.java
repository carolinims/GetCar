package br.com.pos.puc.getCar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pos.puc.getCar.domain.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByLogin(String login);

}
