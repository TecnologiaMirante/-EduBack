package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, UUID>, JpaSpecificationExecutor<Escola>{
    Escola findByCpfCnpj(String cpfCnpj);
}