package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    //a fazer

    private UUID usuario;


    private List<AulaDTO> aulas;

    //objeto turma

    //keyclock gerenciar as permissoes
}
