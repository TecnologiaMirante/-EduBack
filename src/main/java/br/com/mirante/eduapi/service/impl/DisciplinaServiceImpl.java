package br.com.mirante.eduapi.service.impl;
import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.dto.DisciplinaDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.DisciplinaMapper;
import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.repository.DisciplinaRepository;
import br.com.mirante.eduapi.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public Page<Disciplina> findAll(Specification<Disciplina> spec, Pageable page) {
        return disciplinaRepository.findAll(spec, page);
    }

    @Override
    public DisciplinaDTOpost save(DisciplinaDTOpost disciplinaDTOpost) throws BusinessException {

        Disciplina disciplina = DisciplinaMapper.INSTANCE.postToDisciplina(disciplinaDTOpost);

        if (disciplinaRepository.findByCodigo(disciplina.getCodigo()) != null){
            throw new BusinessException("Disciplina já existe com esse codigo");
        }
        disciplina = disciplinaRepository.save(disciplina);

        return DisciplinaMapper.INSTANCE.ToDisciplinaDTOpost(disciplina);
    }

    @Override
    public Optional<DisciplinaDTO> findById(UUID id) {
        return disciplinaRepository.findById(id)
                .map(DisciplinaMapper.INSTANCE::ToDisciplinaDTO);
    }

    @Override
    public Optional<DisciplinaDTO> update(UUID id, DisciplinaDTO disciplinaDTO) {
        if (disciplinaRepository.existsById(id)) {
            Disciplina disciplina = DisciplinaMapper.INSTANCE.ToDisciplina(disciplinaDTO);
            disciplina.setId(id);
            disciplina = disciplinaRepository.save(disciplina);
            return Optional.of(DisciplinaMapper.INSTANCE.ToDisciplinaDTO(disciplina));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
