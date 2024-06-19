package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "Nota", nullable = false, length = 150)
    private String nota;

    //RELACIONAMENTO MEDIA BIMESTRE
    @ManyToOne
    @JoinColumn(name = "id_bimestre", nullable = false)
    private Bimestre bimestre;

    //RELACIONAMENTO MEDIA DISCIPLINA
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id")
    private Disciplina disciplina;

    //RELACIONAMENTO MEDIA ALUNO
//    @ManyToOne
//    @JoinColumn(name = "id_aluno", nullable = false)
//    private Aluno aluno;

}
