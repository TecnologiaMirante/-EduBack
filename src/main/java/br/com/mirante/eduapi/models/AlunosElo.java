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
public class AlunosElo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 75, name = "pontuacao_aluno")
    private double pontuacaoDoAluno;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_elo")
    private Elo elo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_aluno")
    private Aluno aluno;


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
