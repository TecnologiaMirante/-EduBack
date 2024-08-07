package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTOPost {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private UUID escolaId;

}
