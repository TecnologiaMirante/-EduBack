
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
public class Bimestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "data", nullable = false, length = 150)
    private String data;

    //RELACIONAMENTO BIMESTRE CONTEUDO
    @OneToMany(mappedBy = "bimestre", cascade = CascadeType.ALL)
    private List<Conteudo> bimestreConteudoList = new ArrayList<>();

    //RELACIONAMENTO MEDIA BIMESTRE
    @OneToMany(mappedBy = "bimestre", cascade = CascadeType.ALL)
    private List<Media> bimestreMediaList = new ArrayList<>();


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
