package br.com.pos.puc.getCar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pos.puc.getCar.domain.Reserva;
import br.com.pos.puc.getCar.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByLogin(String login);

	@Query(value = "select * from usuario where usuario.perfis.tipo_usuario <> :tipoUsuario", nativeQuery = true )
	List<Usuario> listaUsuariosNaoCliente(@Param("tipoUsuario") String tipoUsuario);
}
