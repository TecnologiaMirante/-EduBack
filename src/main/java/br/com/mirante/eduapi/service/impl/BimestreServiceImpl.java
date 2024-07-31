package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.BimestreDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.BimestreMapper;
import br.com.mirante.eduapi.models.Bimestre;
import br.com.mirante.eduapi.repository.BimestreRepository;
import br.com.mirante.eduapi.service.BimestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BimestreServiceImpl implements BimestreService {
    @Autowired
    private BimestreRepository bimestreRepository;

    @Override
    public Page<Bimestre> findAll(Specification<Bimestre> spec, Pageable page) {
        return bimestreRepository.findAll(spec, page);
    }

    @Override
    public BimestreDTO save(BimestreDTO bimestreDTO) throws BusinessException {

        Bimestre bimestre = BimestreMapper.INSTANCE.ToBimestre(bimestreDTO);

        if (bimestreRepository.findById(bimestre.getId()).isPresent()){
            throw new BusinessException("Bimestre já existe com esse codigo");
        }
        bimestre = bimestreRepository.save(bimestre);
        return BimestreMapper.INSTANCE.ToBimestreDTO(bimestre);
    }

    @Override
    public Optional<BimestreDTO> findById(UUID id) {
        return bimestreRepository.findById(id)
                .map(BimestreMapper.INSTANCE::ToBimestreDTO);
    }

    @Override
    public Optional<BimestreDTO> update(UUID id, BimestreDTO bimestreDTO) {
        if (bimestreRepository.existsById(id)) {
            Bimestre bimestre = BimestreMapper.INSTANCE.ToBimestre(bimestreDTO);
            bimestre.setId(id);
            bimestre = bimestreRepository.save(bimestre);
            return Optional.of(BimestreMapper.INSTANCE.ToBimestreDTO(bimestre));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (bimestreRepository.existsById(id)) {
            bimestreRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
