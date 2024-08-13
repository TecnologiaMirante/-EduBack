package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponsavelDTO {
    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String DataDeNascimento;
    private List<AlunoResponsavelDTO> alunos;
}
