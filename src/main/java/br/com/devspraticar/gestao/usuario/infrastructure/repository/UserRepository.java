package br.com.devspraticar.gestao.usuario.infrastructure.repository;

import br.com.devspraticar.gestao.usuario.domain.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT id, name, email, password, active FROM users WHERE email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}
