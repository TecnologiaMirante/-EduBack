package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.dto.ConteudoDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.ConteudoMapper;
import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.mirante.eduapi.service.ConteudoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConteudoServiceImpl implements ConteudoService{
    @Autowired
    private ConteudoRepository conteudoRepository;

    @Override
    public Page<Conteudo> findAll(Specification<Conteudo> spec, Pageable page) {
        return conteudoRepository.findAll(spec, page);
    }

    @Override
    public ConteudoDTOpost save(ConteudoDTOpost conteudoDTOpost) throws BusinessException {

        Conteudo conteudo = ConteudoMapper.INSTANCE.PostToConteudo(conteudoDTOpost);

        if (conteudoRepository.findByTitulo(conteudo.getTitulo()) != null){
            throw new BusinessException("Conteudo já existe com esse Titulo");
        }
        conteudo = conteudoRepository.save(conteudo);

        return ConteudoMapper.INSTANCE.ToConteudoDTOpost(conteudo);
    }

    @Override
    public Optional<ConteudoDTO> findById(UUID id) {
        return conteudoRepository.findById(id)
                .map(ConteudoMapper.INSTANCE::ToConteudoDTO);
    }

    @Override
    public Optional<ConteudoDTOpost> update(UUID id, ConteudoDTOpost conteudoDTOpost) {
        if (conteudoRepository.existsById(id)) {
            Conteudo conteudo = ConteudoMapper.INSTANCE.PostToConteudo(conteudoDTOpost);
            conteudo.setId(id);
            conteudo = conteudoRepository.save(conteudo);
            return Optional.of(ConteudoMapper.INSTANCE.ToConteudoDTOpost(conteudo));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (conteudoRepository.existsById(id)) {
            conteudoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
