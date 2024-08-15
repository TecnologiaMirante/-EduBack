package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.models.Media;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BimestreDTO {
    private UUID id;
    private String data;
    private List<ConteudoDTOget> conteudos;
    private List<MediaDTOget> medias;


}
