package br.com.mirante.eduapi.repository;


import br.com.mirante.eduapi.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID>, JpaSpecificationExecutor<Professor> {

    Professor findByUserInfoCpf(String cpf);
    Professor findByUserInfoEmail(String email);
    Professor findByUserInfoMatricula(String matricula);
}
