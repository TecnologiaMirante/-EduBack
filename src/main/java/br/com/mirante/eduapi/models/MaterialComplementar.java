package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MaterialComplementar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "material", nullable = false, length = 150)
    private String material; //url de links, arquivos

    @Column(name = "progresso")
    private Boolean progresso;

    @ManyToOne
    @JoinColumn(name = "Id_conteudo")
    private Conteudo conteudosComplementares;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
