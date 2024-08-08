package br.com.mirante.eduapi.repository;


import br.com.mirante.eduapi.models.RankAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RankAlunoRepository extends JpaRepository<RankAluno, UUID>, JpaSpecificationExecutor<RankAluno> {
    @Query("SELECT p FROM RankAluno p ORDER BY p.points DESC, P.id ASC")
    List<RankAluno>findTop5();

    RankAluno findByApelido (String apelido);
}
