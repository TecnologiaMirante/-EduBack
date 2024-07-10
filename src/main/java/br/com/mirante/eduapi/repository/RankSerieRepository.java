package br.com.mirante.eduapi.repository;


import br.com.mirante.eduapi.models.RankSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RankSerieRepository extends JpaRepository<RankSerie, UUID>, JpaSpecificationExecutor<RankSerie> {
    RankSerie findByPrimeiro(String primeiro);
    RankSerie findBySegundo(String segundo);
    RankSerie findByTerceiro(String terceiro);
}
