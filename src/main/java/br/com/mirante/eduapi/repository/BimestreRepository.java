package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Bimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BimestreRepository extends JpaRepository<Bimestre, UUID>, JpaSpecificationExecutor<Bimestre> {
}
