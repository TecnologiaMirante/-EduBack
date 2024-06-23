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
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "codigo", nullable = false, length = 100)
    private String codigo;

    @Column(name = "status", nullable = false, length = 15)
    private Boolean status;

    //RELACIONAMENTO PROFESSOR DISCIPLINA
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Disciplina_Professor",
            joinColumns = @JoinColumn(name = "id_professor"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
    private List<Professor> professorDisciplinaList;

    //RELACIONAMENTO TURMA DISCIPLINA
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Turma_Disciplina",
            joinColumns = @JoinColumn(name = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
    private List<Turma> turmaDisciplinaList = new ArrayList<>();

    //RELACIONAMENTO CONTEUDO DISCIPLINA
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
    private List<Conteudo> conteudoDisciplinaList = new ArrayList<>();

    //RELACIONAMENTO MEDIA DISCIPLINA
    @OneToOne(mappedBy = "disciplina", cascade = CascadeType.ALL)
    private Media media;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "disciplina_Aluno",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina")
    )
    private List<Aluno> alunoDisciplina = new ArrayList<>();

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
