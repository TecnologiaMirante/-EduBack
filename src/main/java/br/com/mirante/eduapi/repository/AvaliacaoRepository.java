package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, UUID>, JpaSpecificationExecutor<Avaliacao> {
}
