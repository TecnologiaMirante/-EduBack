package br.com.mirante.eduapi.repository;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SerieRepository  extends JpaRepository<Serie, UUID>, JpaSpecificationExecutor<Serie> {

    Serie findByNome(String nome);
    Serie findByTurno(String turno);
}
