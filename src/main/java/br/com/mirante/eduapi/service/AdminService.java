package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.AdminDTO;
import br.com.mirante.eduapi.dto.AlunoInteracaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Admin;
import br.com.mirante.eduapi.models.AlunoInteracao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AdminService {

    Page<Admin> findAll(Specification<Admin> spec, Pageable page);

    AdminDTO save(AdminDTO adminDTO) throws BusinessException;

    Optional<AdminDTO> findById(UUID id);

    Optional<AdminDTO> update(UUID id, AdminDTO adminDTO);

    boolean deleteById(UUID id);
}
