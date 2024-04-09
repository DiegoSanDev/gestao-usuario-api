package br.com.devspraticar.gestao.usuario.repository;

import br.com.devspraticar.gestao.usuario.models.PreRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreRegistrationRepository extends CrudRepository<PreRegistration, Long> { }
