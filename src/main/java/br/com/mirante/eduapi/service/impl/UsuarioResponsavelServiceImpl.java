package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.UsuarioResponsavelDTO;
import br.com.mirante.eduapi.dto.UsuarioResponsavelDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.UsuarioResponsavelMapper;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import br.com.mirante.eduapi.repository.AlunoRepository;
import br.com.mirante.eduapi.repository.UsuarioResponsavelRepository;
import br.com.mirante.eduapi.service.UsuarioResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UsuarioResponsavelServiceImpl implements UsuarioResponsavelService {

    @Autowired
    private UsuarioResponsavelRepository usuarioResponsavelRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Page<UsuarioResponsavel> findAll(Specification<UsuarioResponsavel> spec, Pageable pageable) {
        return usuarioResponsavelRepository.findAll(spec, pageable);
    }

    @Override
    public UsuarioResponsavelDTOPost save(UsuarioResponsavelDTOPost usuarioResponsavelDTO) throws BusinessException {
        Pattern patternCpf = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        UsuarioResponsavel usuarioResponsavel = UsuarioResponsavelMapper.INSTANCE
                .usuarioResponsavelDTOPostToUsuarioResponsavel(usuarioResponsavelDTO);


        if (!patternCpf.matcher(usuarioResponsavel.getCpf()).matches()){
            throw new BusinessException("CPF invalido");
        }

        if (usuarioResponsavelRepository.findByCpf(usuarioResponsavel.getCpf()) != null){
            throw new BusinessException("O usuario responsavel ja existe com este cpf");
        }
        Aluno aluno = alunoRepository.findById(usuarioResponsavelDTO.getAlunoId())
                .orElseThrow(() -> new BusinessException("Aluno com este Id não foi encontrado"));
        aluno.setResponsavelAluno(usuarioResponsavel);
        usuarioResponsavel.getAlunos().add(aluno);

       usuarioResponsavel = usuarioResponsavelRepository.save(usuarioResponsavel);

        return UsuarioResponsavelMapper.INSTANCE.usuarioResponsavelToUsuarioResponsavelDTOPost(usuarioResponsavel);
    }

    @Override
    public Optional<UsuarioResponsavelDTO> findById(UUID id) {


        return usuarioResponsavelRepository.findById(id)
                .map(UsuarioResponsavelMapper.INSTANCE::usuarioResponsavelToUsuarioResponsavelDTO);
    }

    @Override
    public Optional<UsuarioResponsavelDTO> update(UUID id, UsuarioResponsavelDTO usuarioResponsavelDTO) {
        if (usuarioResponsavelRepository.existsById(id)){
            UsuarioResponsavel usuarioResponsavel = UsuarioResponsavelMapper.INSTANCE.usuarioResponsavelDTOToUsuarioResponsavel(usuarioResponsavelDTO);
            usuarioResponsavel.setId(id);

            List<Aluno> alunos = usuarioResponsavelDTO.getAlunos().stream()
                    .map(alunoDTO -> alunoRepository.findById(alunoDTO.getId())
                            .orElseThrow(() -> new RuntimeException("Aluno não encontrado")))
                    .collect(Collectors.toList());
            for (Aluno aluno : alunos) {
                aluno.setResponsavelAluno(usuarioResponsavel);
            }
            usuarioResponsavel.setAlunos(alunos);
            alunoRepository.saveAll(alunos);

            usuarioResponsavel = usuarioResponsavelRepository.save(usuarioResponsavel);

            return Optional.of(UsuarioResponsavelMapper.INSTANCE.usuarioResponsavelToUsuarioResponsavelDTO(usuarioResponsavel));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (usuarioResponsavelRepository.existsById(id)) {
            usuarioResponsavelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
