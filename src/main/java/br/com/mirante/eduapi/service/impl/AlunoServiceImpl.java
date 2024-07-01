package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AlunoMapper;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.repository.AlunoRepository;
import br.com.mirante.eduapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public Page<Aluno> findAll(Specification<Aluno> spec, Pageable page) {
        return alunoRepository.findAll(spec, page);
    }

    @Override
    public AlunoDTO save(AlunoDTO alunoDTO) throws BusinessException {
        Aluno aluno = AlunoMapper.INSTANCE.alunoDTOToAluno(alunoDTO);

        if (alunoRepository.findByCpf(aluno.getCpf()) != null){
            throw new BusinessException("Aluno já cadastrado");
        } else if (alunoRepository.findByMatricula(aluno.getMatricula()) != null) {
            throw new BusinessException("Aluno já cadastrado");
        }

        aluno = alunoRepository.save(aluno);

        return AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno);
    }

    @Override
    public Optional<AlunoDTO> findById(UUID id) {
        return alunoRepository.findById(id)
                .map(AlunoMapper.INSTANCE::alunoToAlunoDTO);
    }

    @Override
    public Optional<AlunoDTO> update(UUID id, AlunoDTO alunoDTO) {
        if (alunoRepository.existsById(id)) {
            Aluno aluno = AlunoMapper.INSTANCE.alunoDTOToAluno(alunoDTO);
            aluno.setId(id);
            alunoRepository.save(aluno);

            return Optional.of(AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {

        if (alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
