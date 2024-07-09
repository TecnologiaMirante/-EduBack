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
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Disciplina disciplinaMedia;

    //RELACIONAMENTO MEDIA ALUNO
//    @ManyToOne
//    @JoinColumn(name = "id_aluno", nullable = false)
//    private Aluno aluno;


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}