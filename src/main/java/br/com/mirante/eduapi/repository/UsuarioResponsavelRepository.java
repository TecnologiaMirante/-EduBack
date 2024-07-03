package br.com.mirante.eduapi.repository;


import br.com.mirante.eduapi.models.UsuarioResponsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioResponsavelRepository extends JpaRepository<UsuarioResponsavel, UUID>, JpaSpecificationExecutor<UsuarioResponsavel> {

    UsuarioResponsavel findByCpf(String cpf);
}
