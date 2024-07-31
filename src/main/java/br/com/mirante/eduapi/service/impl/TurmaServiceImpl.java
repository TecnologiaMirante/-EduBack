package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.TurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.TurmaMapper;
import br.com.mirante.eduapi.models.Turma;
import br.com.mirante.eduapi.repository.TurmaRepository;
import br.com.mirante.eduapi.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TurmaServiceImpl implements TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Page<Turma> findAll(Specification<Turma> spec, Pageable page) {
        return turmaRepository.findAll(spec, page);
    }

    @Override
    public TurmaDTO save(TurmaDTO turmaDTO) throws BusinessException {

        Turma turma = TurmaMapper.INSTANCE.Toturma(turmaDTO);

        if (turmaRepository.findByCodigo(turma.getCodigo()) != null){
            throw new BusinessException("Turma já existe com esse codigo");
        }
        turma = turmaRepository.save(turma);

        return TurmaMapper.INSTANCE.ToturmaDTO(turma);
    }

    @Override
    public Optional<TurmaDTO> findById(UUID id) {
        return turmaRepository.findById(id)
                .map(TurmaMapper.INSTANCE::ToturmaDTO);
    }

    @Override
    public Optional<TurmaDTO> update(UUID id, TurmaDTO turmaDTO) {
        if (turmaRepository.existsById(id)) {
            Turma turma = TurmaMapper.INSTANCE.Toturma(turmaDTO);
            turma.setId(id);
            turma = turmaRepository.save(turma);
            return Optional.of(TurmaMapper.INSTANCE.ToturmaDTO(turma));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
