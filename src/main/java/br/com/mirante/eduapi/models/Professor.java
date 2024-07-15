
package br.com.mirante.eduapi.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Professor extends Usuario {

    @Column(name = "materias", nullable = false, length = 100)
    private String materias;

    @Column(name = "formacao", nullable = false, length = 100)
    private String formacao;

    @Column(name = "experiencia", nullable = false, length = 10)
    private String experiencia;


    @Enumerated(EnumType.STRING)
    private Permissoes permissoes;

    //RELACIONAMENTO PROFESSOR DISCIPLINA
    @ManyToMany(mappedBy = "professorDisciplinaList")
    private List<Disciplina> disciplinaProfessorList = new ArrayList<>();

    //RELACIONAMENTO PROFESSOR CONTEUDO
    @OneToMany(mappedBy = "professorConteudo", cascade = CascadeType.ALL)
    private List<Conteudo> professorConteudoList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioProfessor;


    @ManyToMany(mappedBy = "professorTurma")
    private List<Turma>turmasProfessor = new ArrayList<>();

}
