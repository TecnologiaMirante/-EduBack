package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.QuestoesMapper;
import br.com.mirante.eduapi.models.Questoes;
import br.com.mirante.eduapi.repository.QuestoesRepository;
import br.com.mirante.eduapi.service.QuestoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuestoesServiceImpl  implements QuestoesService {

    @Autowired
    private QuestoesRepository questoesRepository;

    @Override
    public Page<Questoes> findAll(Specification<Questoes> spec, Pageable page) {
        return questoesRepository.findAll(spec, page);
    }

    @Override
    public Optional<QuestoesDTO> findById(UUID id) {
        return questoesRepository.findById(id).map(QuestoesMapper.INSTANCE::questoesToQuestoesDTO);
    }

    @Override
    public QuestoesDTO save(QuestoesDTO questoesDTO) throws BusinessException {
        Questoes questoes = QuestoesMapper.INSTANCE.questoesDTOToQuestoes(questoesDTO);

        if (questoesRepository.findByTitulo(questoesDTO.getTitulo()) != null) {
            throw new BusinessException("Titulo ja encontrado");
        }
        questoes = questoesRepository.save(questoes);
        return QuestoesMapper.INSTANCE.questoesToQuestoesDTO(questoes);
    }

    @Override
    public Optional<QuestoesDTO> update(UUID id, QuestoesDTO questoesDTO) {
        if (questoesRepository.existsById(id)) {
            Questoes questoes = QuestoesMapper.INSTANCE.questoesDTOToQuestoes(questoesDTO);
            questoes.setId(id);
            questoes = questoesRepository.save(questoes);
            return Optional.of(QuestoesMapper.INSTANCE.questoesToQuestoesDTO(questoes));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (questoesRepository.existsById(id)) {
            questoesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
