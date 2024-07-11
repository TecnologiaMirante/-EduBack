package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTOGet {
    private String nome;
    private String cpf;
    private String matricula;
    private String sexo;


}
