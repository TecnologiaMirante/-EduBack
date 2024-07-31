package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, UUID>, JpaSpecificationExecutor<Turma> {
    Turma findByCodigo(String Codigo);
}
