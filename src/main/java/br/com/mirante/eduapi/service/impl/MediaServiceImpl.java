package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.MediaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.MediaMapper;
import br.com.mirante.eduapi.models.Media;
import br.com.mirante.eduapi.repository.MediaRepository;
import br.com.mirante.eduapi.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public Page<Media> findAll(Specification<Media> spec, Pageable page) {
        return mediaRepository.findAll(spec, page);
    }

    @Override
    public MediaDTO save(MediaDTO mediaDTO) throws BusinessException {

        Media media = MediaMapper.INSTANCE.ToMedia(mediaDTO);

        if (mediaRepository.findById(media.getId()).isPresent()){
            throw new BusinessException("Media já existe com esse codigo");
        }
        media = mediaRepository.save(media);
        return MediaMapper.INSTANCE.ToMediaDTO(media);
    }

    @Override
    public Optional<MediaDTO> findById(UUID id) {
        return mediaRepository.findById(id)
                .map(MediaMapper.INSTANCE::ToMediaDTO);
    }

    @Override
    public Optional<MediaDTO> update(UUID id, MediaDTO mediaDTO) {
        if (mediaRepository.existsById(id)) {
            Media media = MediaMapper.INSTANCE.ToMedia(mediaDTO);
            media.setId(id);
            media = mediaRepository.save(media);
            return Optional.of(MediaMapper.INSTANCE.ToMediaDTO(media));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (mediaRepository.existsById(id)) {
            mediaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
