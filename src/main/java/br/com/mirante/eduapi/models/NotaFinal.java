package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NotaFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    //RELACIONAMENTO AVALIACAO NOTA
    @ManyToOne
    @JoinColumn(name = "id_avaliacao", nullable = false)
    private Avaliacao avaliacao;

    //RELACIONAMENTO DISCIPLINA NOTA
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
