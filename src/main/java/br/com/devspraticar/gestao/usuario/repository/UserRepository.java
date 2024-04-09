package br.com.devspraticar.gestao.usuario.repository;

import br.com.devspraticar.gestao.usuario.models.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(@Param("email") String email);

}
