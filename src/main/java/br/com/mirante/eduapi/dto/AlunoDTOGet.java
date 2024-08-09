package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTOGet {
    private UUID id;
    private String nome;
    private String cpf;
    private String matricula;
    private String sexo;
    private UUID usuarioId;
    private TipoUsuario tipoUsuario = TipoUsuario.ALUNO;
    private UsuarioResponsavelDTO responsavel;
    private EscolaDTOGet escola;

}
