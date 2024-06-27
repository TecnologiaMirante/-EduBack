package br.com.mirante.eduapi.repository;

import br.com.mirante.eduapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.DoubleStream;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario>{
    Usuario findByCpf(String cpf);
    Usuario findByEmail(String email);
    Usuario findByMatricula(String matricula);

}
