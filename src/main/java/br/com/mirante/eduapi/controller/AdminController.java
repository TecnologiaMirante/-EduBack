package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.AdminDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AdminMapper;
import br.com.mirante.eduapi.models.Admin;
import br.com.mirante.eduapi.service.AdminService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados dos admin", name = "Admin")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar os admins.", description = "Endpoint para consultar os admins.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AdminDTO>> findAll(SpecTemplate.AdminSpec spec, Pageable page) {
        Page<Admin> consultaPage = adminService.findAll(spec, page);

        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(AdminMapper.INSTANCE::adminToAdminDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(AdminMapper.INSTANCE::adminToAdminDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de admin.", description = "Endpoint para cadastrar uma admin.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AdminDTO> create(@RequestBody AdminDTO adminDTO) throws BusinessException {
        AdminDTO savedAdmin = adminService.save(adminDTO);

        return ResponseEntity.ok(savedAdmin);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar admin por ID.", description = "Endpoint para buscar o admin pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AdminDTO> getById(@PathVariable UUID id){
        return adminService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização do admin.", description = "Endpoint para atualizar os dados dos admin.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AdminDTO> update(@PathVariable UUID id, @RequestBody AdminDTO adminDTO) {
        return adminService.update(id, adminDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de admin.", description = "Endpoint para remover um admin.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (adminService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
