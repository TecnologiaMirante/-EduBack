package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.dto.SerieDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.SerieMapper;
import br.com.mirante.eduapi.models.Serie;
import br.com.mirante.eduapi.repository.SerieRepository;
import br.com.mirante.eduapi.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SerieServiceImpl implements SerieService{

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public Page<Serie> findAll(Specification<Serie> spec, Pageable page) {
        return serieRepository.findAll(spec, page);
    }

    @Override
    public SerieDTOpost save(SerieDTOpost serieDTOpost) throws BusinessException {

        Serie serie = SerieMapper.INSTANCE.DTOtoSerie(serieDTOpost);

        if (serieRepository.findByNome(serie.getNome()) != null && serieRepository.findByTurno(serie.getTurno()) != null && serieRepository.findByTurma(serie.getTurma())!= null){
            throw new BusinessException("Série já existe com esse nome, turno e turma");
        }
        serie = serieRepository.save(serie);

        return SerieMapper.INSTANCE.ToSerieDTOpost(serie);
    }

    @Override
    public Optional<SerieDTO> findById(UUID id) {
        return serieRepository.findById(id)
                .map(SerieMapper.INSTANCE::ToserieDTO);
    }

    @Override
    public Optional<SerieDTOpost> update(UUID id, SerieDTOpost serieDTOpost) {
        if (serieRepository.existsById(id)) {
            Serie serie = SerieMapper.INSTANCE.DTOtoSerie(serieDTOpost);
            serie.setId(id);
            serie = serieRepository.save(serie);
            return Optional.of(SerieMapper.INSTANCE.ToSerieDTOpost(serie));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (serieRepository.existsById(id)) {
            serieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
