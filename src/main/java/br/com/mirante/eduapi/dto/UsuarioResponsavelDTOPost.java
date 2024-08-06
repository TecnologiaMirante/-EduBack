package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponsavelDTOPost {
    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private LocalDateTime DataDeNascimento;
    private UUID alunoId;
}
