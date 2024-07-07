package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ConteudoRepository extends JpaRepository<Conteudo, UUID>, JpaSpecificationExecutor<Conteudo> {
    Conteudo findByTitulo(String titulo);
}
