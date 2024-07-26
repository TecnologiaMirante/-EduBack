package br.com.mirante.eduapi.dto;
import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private Permissoes permissoes;
    private EscolaUsuarioDTO escola;
}