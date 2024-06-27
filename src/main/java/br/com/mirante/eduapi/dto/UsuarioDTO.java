package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String cpf;
    private String matricula;
    private String avatar;
    private LocalDateTime dataDeNascimento;
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

    //fazer depois para colocar um id no usuario_prof, ususario_admin e usuario_aluno
    //private UUID escola;
}
