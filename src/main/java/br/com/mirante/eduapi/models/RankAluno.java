package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RankAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Apelido")
    private String apelido;

    @Column(name = "points")
    private Integer points;

    @Column(name = "img")
    private String img;

    @ManyToOne
    @JoinColumn(name = "rankAluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "rankEscola", nullable = false)
    private Escola escola;


    @ManyToOne
    @JoinColumn(name = "RankAlunoSerieList")
    private  Serie SerieListSerie ;

    @ManyToOne
    @JoinColumn(name = "rankAlunos")
    private Turma rankAlunos ;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
