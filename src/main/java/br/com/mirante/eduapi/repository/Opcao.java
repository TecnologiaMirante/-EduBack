package br.com.mirante.eduapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Opcao extends JpaRepository<Opcao, UUID>, JpaSpecificationExecutor<Opcao>{
}
