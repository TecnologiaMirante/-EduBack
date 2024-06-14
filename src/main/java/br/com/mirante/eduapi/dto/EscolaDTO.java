package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EscolaDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String logradouro;
    private String complemento;
    private String cep;
    private String referencia;
    private String cpfCnpj;
}
