package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
public class AlunoInteracao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "anotar", nullable = false)
    private String anotar;

    @Column(name = "avaliar", nullable = false)
    private String avaliar;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_Aluno")
    private Aluno aluno;

    @ManyToMany(mappedBy = "alunoInteracaos")
    private List<Aula> aulas ;

}
