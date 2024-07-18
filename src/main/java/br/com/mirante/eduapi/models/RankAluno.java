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
public class RankAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "points")
    private String points;

    @Column(name = "img")
    private String img;

    @ManyToOne
    @JoinColumn(name = "rankAluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "rankEscola", nullable = false)
    private Escola escola;



    @ManyToMany(mappedBy = "rankAlunos")
    private List<Turma> rankAlunos = new ArrayList<>();

//    @OneToMany(mappedBy = "rankEscola")
//    private List<Escola> escolasRank = new ArrayList<>();

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}