package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.AdminDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AdminMapper;
import br.com.mirante.eduapi.models.Admin;

import br.com.mirante.eduapi.repository.AdminRepository;
import br.com.mirante.eduapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Page<Admin> findAll(Specification<Admin> spec, Pageable page) {
        return adminRepository.findAll(spec, page);
    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) throws BusinessException {
        Admin admin = AdminMapper.INSTANCE.adminDTOToAdmin(adminDTO);

        admin = adminRepository.save(admin);

        return AdminMapper.INSTANCE.adminToAdminDTO(admin);
    }

    @Override
    public Optional<AdminDTO> findById(UUID id) {
        return adminRepository.findById(id).map(AdminMapper.INSTANCE::adminToAdminDTO);
    }

    @Override
    public Optional<AdminDTO> update(UUID id, AdminDTO adminDTO) {
        if (adminRepository.existsById(id)) {
            Admin admin = AdminMapper.INSTANCE.adminDTOToAdmin(adminDTO);
            admin.setId(id);
            adminRepository.save(admin);

            return Optional.of(AdminMapper.INSTANCE.adminToAdminDTO(admin));
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (adminRepository.existsById(id)){
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
