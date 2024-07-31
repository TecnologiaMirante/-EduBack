package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.MediaDTO;
import br.com.mirante.eduapi.models.Media;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MediaMapper {
    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);
    MediaDTO ToMediaDTO(Media media);
    Media ToMedia(MediaDTO mediaDTO);
}
