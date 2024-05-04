package br.com.devspraticar.gestao.usuario.infrastructure.repository;

import br.com.devspraticar.gestao.usuario.domain.model.PreRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreRegistrationRepository extends CrudRepository<PreRegistration, Long> { }
