package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String cpf;
    private String matricula;
    private String avatar;
    private String dataDeNascimento;
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
    private TipoUsuario tipoUsuario = TipoUsuario.PROFESSOR;
    private String materias;
    private String formacao;
    private String experiencia;
    private EscolaUsuarioDTO escola;
    private List<TurmaDTOget> turmas;
    private List<ConteudoDTOget>conteudos;
}
