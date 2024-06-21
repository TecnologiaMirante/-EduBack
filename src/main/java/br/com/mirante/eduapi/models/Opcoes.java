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
public class Opcoes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "descricao", nullable = false, length = 150)
    private String nota;

    @Column(name = "correto", nullable = false, length = 150)
    private Boolean correto;

    //RELACIONAMENTO QUESTOES OPCOES
    @ManyToOne
    @JoinColumn(name = "id_questoes", nullable = false)
    private Questoes questoes;
}
