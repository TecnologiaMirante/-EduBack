package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponsavelDTOGet {
    private UUID id;
    private String nome;
    private String cpf;
    private String matricula;
    private String sexo;
    private Permissoes permissoes = Permissoes.ALUNO;

    public UsuarioResponsavelDTOGet(UUID id) {
    }
}
