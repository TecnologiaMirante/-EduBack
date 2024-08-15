package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.MediaDTO;
import br.com.mirante.eduapi.models.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MediaMapper {
    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

    @Mapping(source = "aluno.id", target = "id_aluno")
    @Mapping(source = "disciplinaMedia.id", target = "id_disciplina")
    @Mapping(source = "bimestre.id", target = "id_bimestre")
    MediaDTO ToMediaDTO(Media media);

    @Mapping(source = "id_aluno", target = "aluno.id")
    @Mapping(source = "id_disciplina", target = "disciplinaMedia.id")
    @Mapping(source = "id_bimestre", target = "bimestre.id")
    Media ToMedia(MediaDTO mediaDTO);
}
