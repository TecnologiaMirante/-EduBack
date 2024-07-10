package br.com.mirante.eduapi.dto;

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

    private UUID usuario;


    private List<AulaDTO> aulas;
    private List<RankAlunoDTO> rankAlunoDTOS;

    //objeto turma

    //keyclock gerenciar as permissoes
}
