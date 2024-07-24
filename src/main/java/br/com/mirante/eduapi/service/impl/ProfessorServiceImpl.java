package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.ProfessorMapper;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.repository.ProfessorRepository;
import br.com.mirante.eduapi.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProfessorServiceImpl implements ProfessorService {


    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Page<Professor> findAll(Specification<Professor> spec, Pageable pageable) {
        Page<Professor> professoresPage = professorRepository.findAll(spec, pageable);

        return professoresPage;
    }

    @Override
    public ProfessorDTO save(ProfessorDTO professorDTO) throws BusinessException {

        Professor professor = ProfessorMapper.INSTANCE.professorDTOToProfessor(professorDTO);


        if (professorRepository.findByUserInfoCpf(professor.getUserInfo().getCpf()) != null){
            throw new BusinessException("Usuario Ja existe com este cpf");
        } else if (professorRepository.findByUserInfoEmail(professor.getUserInfo().getEmail()) != null){
            throw new BusinessException("Usuario Ja existe com este email");
        } else if (professorRepository.findByUserInfoMatricula(professor.getUserInfo().getMatricula()) != null) {
            throw new BusinessException("Usuario Ja existe com esta matricula");
        }

        professor = professorRepository.save(professor);

        return ProfessorMapper.INSTANCE.professorToProfessorDTO(professor);
    }

    @Override
    public Optional<ProfessorDTO> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProfessorDTO> update(UUID id, ProfessorDTO professorDTO) {
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
