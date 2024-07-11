package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "titulo", nullable = false, insertable = false, updatable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "arquivo", nullable = false)
    private String arquivo;

    @Column(name = "titulo", nullable = false)
    private String avaliacao;

    @Column(name = "img", nullable = false)
    private String img;

    @Column(name = "data", nullable = false , length = 8)
    private Date data;

    @Column(name = "favoritar", nullable = false)
    private Boolean favoritar;

    @Column(name = "conteudo_realizado", nullable = false)
    private Boolean conteudoRealizado;

    @Column(name = "progresso")
    private Boolean progresso;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;



    @ManyToMany
    @JoinTable(
            name = "Aula_Conteudo",
            joinColumns = @JoinColumn(name = "id_aula"),
            inverseJoinColumns = @JoinColumn(name = "id_conteudo"))
    private List<Conteudo> conteudos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Aula_Interacao",
            joinColumns = @JoinColumn(name = "id_aula"),
            inverseJoinColumns = @JoinColumn(name = "id_interacao"))
    private List<AlunoInteracao> alunoInteracaos = new ArrayList<>();


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }


}