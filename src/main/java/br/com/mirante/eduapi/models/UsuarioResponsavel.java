package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsuarioResponsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "cpf", nullable = false, length = 15)
    private String Cpf;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name= "Data_De_Nascimentos", nullable = false , length = 8)
    private String DataDeNascimento;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Aluno> responsavel = new ArrayList<>();
}
