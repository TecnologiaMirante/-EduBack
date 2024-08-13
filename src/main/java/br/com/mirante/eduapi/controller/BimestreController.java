package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.BimestreDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.BimestreMapper;
import br.com.mirante.eduapi.models.Bimestre;
import br.com.mirante.eduapi.service.BimestreService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/Bimestre")
public class BimestreController {
    @Autowired
    private BimestreService bimestreService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.BIMESTRE_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar Bimestre.", description = "Endpoint para consultar Bimestre.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<BimestreDTO>> findAll(SpecTemplate.BimestreSpec spec, Pageable page){
        Page<Bimestre> consultaPage = bimestreService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(BimestreMapper.INSTANCE::ToBimestreDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(BimestreMapper.INSTANCE::ToBimestreDTO), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.BIMESTRE_CADASTRAR)")
    @PostMapping()
    @Operation(summary = "Cadastro de Bimestre.", description = "Endpoint para cadastrar Bimestre.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<BimestreDTO> create(@RequestBody BimestreDTO bimestreDTO) throws BusinessException {
        BimestreDTO savedBimestre = bimestreService.save(bimestreDTO);
        return ResponseEntity.ok(savedBimestre);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.BIMESTRE_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Bimestre por ID.", description = "Endpoint para buscar a Bimestre pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<BimestreDTO> getById(@PathVariable UUID id) {
        return bimestreService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.BIMESTRE_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Bimestre.", description = "Endpoint para atualizar os dados das Bimestre.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<BimestreDTO> update(@PathVariable UUID id, @RequestBody BimestreDTO bimestreDTO) {
        return bimestreService.update(id, bimestreDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.BIMESTRE_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Bimestre.", description = "Endpoint para remover uma Bimestre.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (bimestreService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
    
}
