package br.com.devspraticar.gestao.usuario.infrastructure.repository;

import br.com.devspraticar.gestao.usuario.model.entities.PreRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PreRegistrationRepository extends CrudRepository<PreRegistration, Long> {

    Optional<PreRegistration> findByActivationKey(UUID activationKey);

}
