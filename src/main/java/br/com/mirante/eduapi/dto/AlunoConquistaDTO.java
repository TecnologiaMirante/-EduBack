package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoConquistaDTO {
    private UUID id;
    private String nome;
    private String cpf;
    private String matricula;
    private String sexo;
    private TipoUsuario tipoUsuario = TipoUsuario.ALUNO;
}
