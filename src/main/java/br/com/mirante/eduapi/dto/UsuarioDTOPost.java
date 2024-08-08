package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTOPost {

    private UUID id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private UUID escolaId;

}
