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
    private UserInfoDTO userInfo;
    private Permissoes permissoes;
    private EscolaUsuarioDTO escola;

   /* private List<ProfessorDTOGet> professores;

    private List<AlunoDTOGet> alunos;*/

}