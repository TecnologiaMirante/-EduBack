package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Opcoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcoes, UUID>,JpaSpecificationExecutor<Opcoes>{
    Opcoes findByDescricao(String descricao);
}
