package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTOPost {
    private UUID id;
    private UserInfoDTO userInfo;
    private Permissoes permissoes = Permissoes.ALUNO;
    private UUID escolaId;
    //private UUID usuarioId;
}
