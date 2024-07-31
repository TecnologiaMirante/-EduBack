package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.models.MaterialComplementar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface MaterialComplementarRepository extends JpaRepository<MaterialComplementar, UUID>, JpaSpecificationExecutor<MaterialComplementar> {
}
