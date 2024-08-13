package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.BimestreDTO;
import br.com.mirante.eduapi.dto.BimestreDTOget;
import br.com.mirante.eduapi.dto.BimestreDTOpost;
import br.com.mirante.eduapi.dto.ConteudoDTOget;
import br.com.mirante.eduapi.models.Bimestre;
import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.models.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mapper
public interface BimestreMapper {
    BimestreMapper INSTANCE = Mappers.getMapper(BimestreMapper.class);

    @Mapping(source = "bimestreConteudoList", target = "conteudos")
    @Mapping(source = "bimestreMediaList", target = "medias")
    BimestreDTO ToBimestreDTO(Bimestre bimestre);

    @Mapping(source = "conteudos", target = "bimestreConteudoList")
    @Mapping(source = "medias", target = "bimestreMediaList")
    Bimestre ToBimestre(BimestreDTO bimestreDTO);

    @Mapping(source = "bimestreConteudoList", target = "conteudo_id", qualifiedByName = "conteudoListToFirstId")
    @Mapping(source = "bimestreMediaList", target = "media_id", qualifiedByName = "mediaListToFirstId")
    BimestreDTOpost ToBimestreDTOpost(Bimestre bimestre);

    @Mapping(source = "conteudo_id", target = "bimestreConteudoList", qualifiedByName = "uuidToConteudoList")
    @Mapping(source = "media_id", target = "bimestreMediaList", qualifiedByName = "uuidToMediaList")
    Bimestre BimestreDTOpostToBimestre(BimestreDTOpost bimestreDTOpost);

    @Named("conteudoListToFirstId")
    static UUID conteudoListToFirstId(List<Conteudo> conteudos) {
        return conteudos.isEmpty() ? null : conteudos.get(0).getId();
    }

    @Named("mediaListToFirstId")
    static UUID mediaListToFirstId(List<Media> medias) {
        return medias.isEmpty() ? null : medias.get(0).getId();
    }

    @Named("uuidToConteudoList")
    static List<Conteudo> uuidToConteudoList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Conteudo conteudo = new Conteudo();
        conteudo.setId(uuid);
        return Collections.singletonList(conteudo);
    }

    @Named("uuidToMediaList")
    static List<Media> uuidToMediaList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Media media = new Media();
        media.setId(uuid);
        return Collections.singletonList(media);
    }
}

