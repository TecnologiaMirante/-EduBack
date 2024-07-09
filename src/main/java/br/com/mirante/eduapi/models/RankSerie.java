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
public class RankSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Primeiro_Lugar")
    private String primeiro;

    @Column(name = "Segundo_Lugar")
    private String segundo;

    @Column(name = "Terceiro_Lugar")
    private String terceiro;

    @ManyToMany(mappedBy = "RankSerieList")
    private  List<Serie> SerieList = new ArrayList<>();
    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
