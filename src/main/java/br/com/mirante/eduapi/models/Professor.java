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
    public class Professor {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id", nullable = false)
        private UUID id;

        @Column(name = "turmas", nullable = false, length = 150)
        private String turmas;

        @Column(name = "materias", nullable = false, length = 100)
        private String materias;

        @Column(name = "formacao", nullable = false, length = 15)
        private String formacao;

        @Column(name = "experiencia", nullable = false, length = 2)
        private String experiencia;

        //RELACIONAMENTO PROFESSOR DISCIPLINA
        @ManyToMany(mappedBy = "Professor")
        private List<Disciplina> disciplinaProfessorList = new ArrayList<>();

        //RELACIONAMENTO PROFESSOR CONTEUDO
        @OneToMany(mappedBy = "Professor", cascade = CascadeType.ALL)
        private List<Conteudo> professorConteudoList = new ArrayList<>();

    }
