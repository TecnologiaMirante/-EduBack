package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    private UUID id;
    private UserInfoDTO userInfo;
    private Permissoes permissoes = Permissoes.ALUNO;
    private EscolaUsuarioDTO escola;

    //private UUID turmaId;
    //private UUID responsavelId;

   /* private List<AulaDTO> aulas;
    private List<RankAlunoDTO> rankAlunoDTOS;
    */

    //objeto turma

    //keyclock gerenciar as permissoes
}
