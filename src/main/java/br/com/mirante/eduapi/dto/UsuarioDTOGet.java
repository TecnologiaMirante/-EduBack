package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTOGet {
    private UUID id;
    private String nome;
    private String sexo;
    private String cpf;
    private String matricula;
    private Permissoes permissoes;
}
