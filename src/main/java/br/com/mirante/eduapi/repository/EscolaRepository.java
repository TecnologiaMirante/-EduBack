package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long>, JpaSpecificationExecutor<Escola>{
}