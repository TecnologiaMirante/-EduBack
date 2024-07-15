package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO extends UsuarioDTOPost {
    private UUID usuarioId;
    //private UUID turmaId;
    //private UUID responsavelId;




   /* private List<AulaDTO> aulas;
    private List<RankAlunoDTO> rankAlunoDTOS;
    */

    //objeto turma

    //keyclock gerenciar as permissoes
}
