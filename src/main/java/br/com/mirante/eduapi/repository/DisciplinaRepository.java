package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, UUID>, JpaSpecificationExecutor<Disciplina> {
        Disciplina findByCodigo(String Codigo);
}
