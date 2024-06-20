package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    //RELACIONAMENTO DISCIPLINA CONTEUDO
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    //RELACIONAMENTO PROFESSOR CONTEUDO
    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;

    //RELACIONAMENTO BIMESTRE CONTEUDO
    @ManyToOne
    @JoinColumn(name = "id_bimestre", nullable = false)
    private Bimestre bimestre;

    @ManyToMany(mappedBy = "conteudos")
    private List<Aula> aulas = new ArrayList<>();


}
