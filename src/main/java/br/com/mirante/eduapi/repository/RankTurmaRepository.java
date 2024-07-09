package br.com.mirante.eduapi.repository;


import br.com.mirante.eduapi.models.RankTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RankTurmaRepository extends JpaRepository<RankTurma, UUID>, JpaSpecificationExecutor<RankTurma> {
    RankTurma findByPrimeiro(String primeiro);
    RankTurma findBySegundo(String segundo);
    RankTurma findByTerceiro(String terceiro);
}
