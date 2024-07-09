package br.com.mirante.eduapi.repository;


import br.com.mirante.eduapi.models.Questoes;
import br.com.mirante.eduapi.models.RankAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RankAlunoRepository extends JpaRepository<RankAluno, UUID>, JpaSpecificationExecutor<RankAluno> {
}
