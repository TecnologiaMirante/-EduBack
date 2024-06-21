package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Progresso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //Pendente
    @Column(name = "progresso")
    private String progresso;

    @OneToMany(mappedBy = "Aula",cascade = CascadeType.ALL)
    private List<Aula> Aulalist = new ArrayList<>();

}