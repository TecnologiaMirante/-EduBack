package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario>{
    Usuario findByUserInfoCpf(String cpf);
    Usuario findByUserInfoEmail(String email);
    Usuario findByUserInfoMatricula(String matricula);

}
