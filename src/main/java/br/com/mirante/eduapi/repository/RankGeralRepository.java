package br.com.mirante.eduapi.repository;



import br.com.mirante.eduapi.models.RankGeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RankGeralRepository extends JpaRepository<RankGeral, UUID>, JpaSpecificationExecutor<RankGeral> {
    RankGeral findByPrimeiro(String primeiro);
    RankGeral findBySegundo(String segundo);
    RankGeral findByTerceiro(String terceiro);
}
