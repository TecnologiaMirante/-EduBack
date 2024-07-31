package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Questoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestoesRepository extends JpaRepository<Questoes, UUID>, JpaSpecificationExecutor<Questoes> {
    Questoes findByTitulo(String titulo);
}
