package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO extends UsuarioDTOPost {
    //a fazer

    private UUID usuarioId;


    private List<AulaDTO> aulas;
    private List<RankAlunoDTO> rankAlunoDTOS;

    public AlunoDTO(Aluno entity) {
        Usuario usuario = new Usuario();
        usuarioId = entity.getId();
        usuario.setNome(entity.getNome());


    }


    //objeto turma

    //keyclock gerenciar as permissoes
}
