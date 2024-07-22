package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Permissoes;
import br.com.mirante.eduapi.models.Usuario;
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
    private Permissoes permissoes = Permissoes.ALUNO;
    private UsuarioResponsavelDTO responsavel;


}
