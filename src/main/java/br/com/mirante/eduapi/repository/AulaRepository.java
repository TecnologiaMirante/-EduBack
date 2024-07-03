package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AulaRepository  extends JpaRepository<Aula, UUID>, JpaSpecificationExecutor<Aula> {
    Aula findByTitulo(String titulo);
}
