package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponsavelDTO {
    private UUID id;
    private String nome;
    private String email;
    private String sexo;
    private String cpf;
    private String matricula;
    //private TurmaDTO turma;
}
