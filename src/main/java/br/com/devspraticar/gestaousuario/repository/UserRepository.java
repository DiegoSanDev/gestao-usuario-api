package br.com.devspraticar.gestaousuario.repository;

import br.com.devspraticar.gestaousuario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}