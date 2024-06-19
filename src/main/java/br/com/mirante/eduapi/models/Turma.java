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
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "codigo", nullable = false, length = 100)
    private String codigo;

    @Column(name = "turno", nullable = false, length = 15)
    private String turno;

    @Column(name = "status", nullable = false, length = 15)
    private Boolean status;

    //RELACIONAMENTO TURMA DISCIPLINA
    @ManyToMany(mappedBy = "Turma")
    private List<Disciplina> turmaDisciplinaList = new ArrayList<>();

    //RELACIONAMENTO TURMA SERIE
    @ManyToOne
    @JoinColumn(name = "id_serie", nullable = false)
    private Serie serie;
}
