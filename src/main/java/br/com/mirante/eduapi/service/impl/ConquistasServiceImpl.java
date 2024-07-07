package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.ConquistasDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.ConquistaMapper;
import br.com.mirante.eduapi.models.Conquistas;
import br.com.mirante.eduapi.repository.ConquistaRepository;
import br.com.mirante.eduapi.service.ConquistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConquistasServiceImpl  implements ConquistaService {

    @Autowired
    private ConquistaRepository conquistaRepository;


    @Override
    public Page<Conquistas> findAll(Specification<Conquistas> spec, Pageable page) {
        return conquistaRepository.findAll(spec, page);
    }

    @Override
    public ConquistasDTO save(ConquistasDTO conquistasDTO) throws BusinessException {
        Conquistas conquistas = ConquistaMapper.INSTANCE.DTOtoConquistas(conquistasDTO);
        conquistas = conquistaRepository.save(conquistas);

        return ConquistaMapper.INSTANCE.conquistasToDTO(conquistas);
    }

    @Override
    public Optional<ConquistasDTO> findById(UUID id) {
        return conquistaRepository.findById(id)
                .map(ConquistaMapper.INSTANCE::conquistasToDTO);
    }

    @Override
    public Optional<ConquistasDTO> update(UUID id, ConquistasDTO conquistasDTO) {
        if (conquistaRepository.existsById(id)) {
            Conquistas conquista = ConquistaMapper.INSTANCE.DTOtoConquistas(conquistasDTO);
            conquista.setId(id);
            conquista = conquistaRepository.save(conquista);
            return Optional.of(ConquistaMapper.INSTANCE.conquistasToDTO(conquista));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (conquistaRepository.existsById(id)) {
            conquistaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
