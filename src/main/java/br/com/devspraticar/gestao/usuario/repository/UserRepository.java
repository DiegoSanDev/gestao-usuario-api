package br.com.devspraticar.gestao.usuario.repository;

import br.com.devspraticar.gestao.usuario.models.User;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

}
