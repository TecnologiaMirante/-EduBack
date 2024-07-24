package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>, JpaSpecificationExecutor<Aluno> {

    Aluno findByUserInfoCpf(String cpf);
    Aluno findByUserInfoMatricula(String matricula);
}
