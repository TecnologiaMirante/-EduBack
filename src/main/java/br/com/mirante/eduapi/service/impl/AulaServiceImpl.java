package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.AulaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AulaMapper;
import br.com.mirante.eduapi.models.Aula;
import br.com.mirante.eduapi.repository.AulaRepository;
import br.com.mirante.eduapi.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AulaServiceImpl implements AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public Page<Aula> findAll(Specification<Aula> spec , Pageable page){
        return aulaRepository.findAll(spec, page);
    }

    @Override
    public Optional<AulaDTO> findById(UUID id) {
        return aulaRepository.findById(id)
                .map(AulaMapper.INSTANCE::aulaToAulaDTO);
    }

    @Override
    public AulaDTO save(AulaDTO aulaDTO) throws BusinessException {
        Aula aula = AulaMapper.INSTANCE.aulaDTOToAula(aulaDTO);

        if(aulaRepository.findByTitulo(aulaDTO.getTitulo()) != null){
            throw new BusinessException("Titulo ja existente");
        }
        aulaRepository.save(aula);
        return AulaMapper.INSTANCE.aulaToAulaDTO(aula);
    }

    @Override
    public Optional<AulaDTO> update(UUID id, AulaDTO aulaDTO) throws BusinessException{
        Aula aula = AulaMapper.INSTANCE.aulaDTOToAula(aulaDTO);

        if (aulaRepository.existsById(id)){
            if (aulaRepository.findByTitulo(aulaDTO.getTitulo()) != null){
                throw new BusinessException("Esse titulo ja existe");
            }
            aula.setId(id);
            aula = aulaRepository.save(aula);
            return Optional.of(AulaMapper.INSTANCE.aulaToAulaDTO(aula));
        }
        return Optional.empty();
    }

    @Override
    public  boolean deleteById(UUID id){
        if(aulaRepository.existsById(id)){
            aulaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
