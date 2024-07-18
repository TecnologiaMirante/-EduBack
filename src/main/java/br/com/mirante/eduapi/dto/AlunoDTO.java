package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Permissoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
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
    private UUID escolaId;
    private UUID usuarioId;
    private EscolaUsuarioDTO escola;
    //private UUID turmaId;
    //private UUID responsavelId;




   /* private List<AulaDTO> aulas;
    private List<RankAlunoDTO> rankAlunoDTOS;
    */

    //objeto turma

    //keyclock gerenciar as permissoes
}
