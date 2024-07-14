package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Permissoes;
import br.com.mirante.eduapi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String cpf;
    private String matricula;
    private String avatar;
    private LocalDateTime dataDeNascimento;
    private String status;
    private String instagram;
    private String facebook;
    private String twitter;
    private String whatsApp;
    private String estado;
    private String cidade;
    private String bairro;
    private String numeroEndereco;
    private String complemento;
    private String cep;
    private String referencia;
    private Permissoes permissoes;
    private Escola escola;


    private List<ProfessorDTOGet> professores;

    private List<AlunoDTOGet> alunos;

    public UsuarioDTO(Usuario entity) {
        //Escola escola = entity.getUsuarioEscola();
       /* if (escola != null) {
            UUID id = escola.getId();
            escola.setId(id);
            escola.setNome(entity.getUsuarioEscola().getNome());
            escola.setEmail(entity.getUsuarioEscola().getEmail());
        }
        else {
            System.out.println("Usuário não está associado a nenhuma escola.");
        }*/


        entity.getProfessorList().forEach(professor -> {
            getProfessores()
                    .add(new ProfessorDTOGet(
                            professor.getId(), professor.getNome(), professor.getMatricula(), professor.getAvatar())
                    );
        });

        entity.getAlunoList().forEach(aluno -> getAlunos()
        .add(new AlunoDTOGet(
                aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getMatricula(), aluno.getSexo())));

    }

}
