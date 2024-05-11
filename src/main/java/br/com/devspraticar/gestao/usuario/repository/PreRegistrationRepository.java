package br.com.devspraticar.gestao.usuario.repository;

import br.com.devspraticar.gestao.usuario.domain.model.PreRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PreRegistrationRepository extends CrudRepository<PreRegistration, Long> {

    Optional<PreRegistration> findByActivationKey(UUID activationKey);

}
