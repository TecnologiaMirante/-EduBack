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
public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private List<Aula> aulasDisponiveis ;

    @ManyToOne
    @JoinColumn(name = "Id_conteudo", nullable = false)
    private Avaliacao avaliacao;

    @OneToMany(mappedBy = "conteudosComplementares")
    private List<MaterialComplementar> materialComplementar;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}