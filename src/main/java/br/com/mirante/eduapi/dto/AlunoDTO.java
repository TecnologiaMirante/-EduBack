package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.controller.UsuarioDTOPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO extends UsuarioDTOPost {
    //a fazer

    private UUID usuario;

    //objeto turma

    //keyclock gerenciar as permissoes
}
