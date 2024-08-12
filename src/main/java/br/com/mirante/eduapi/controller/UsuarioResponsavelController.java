package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.dto.UsuarioResponsavelDTO;
import br.com.mirante.eduapi.dto.UsuarioResponsavelDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.UsuarioResponsavelMapper;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import br.com.mirante.eduapi.service.UsuarioResponsavelService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados dos Usuarios que são responsaveis", name = "Usuario Responsavel")
@RequestMapping("/usuarioResponsavel")
public class UsuarioResponsavelController {

    @Autowired
    private UsuarioResponsavelService usuarioResponsavelService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.RESPONSAVEL_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar Usuarios Responsaveis.", description = "Endpoint para consultar usuarios responsaveis.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<UsuarioResponsavelDTO>> findAll(SpecTemplate.UsuarioResponsavelSpec spec, Pageable page) {
        Page<UsuarioResponsavel> consultaPage = usuarioResponsavelService.findAll(spec, page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(
                    UsuarioResponsavelMapper.INSTANCE::usuarioResponsavelToUsuarioResponsavelDTO), HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(consultaPage.map(
                    UsuarioResponsavelMapper.INSTANCE::usuarioResponsavelToUsuarioResponsavelDTO), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RESPONSAVEL_CADASTRAR)")
    @PostMapping("/")
    @Operation(summary = "Cadastrar Usuarios Responsaveis.", description = "Endpoint para cardastrar usuarios responsaveis.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioResponsavelDTOPost> create(@RequestBody UsuarioResponsavelDTOPost usuarioResponsavelDTO) throws BusinessException {

        UsuarioResponsavelDTOPost usuarioResponsavelSaved = usuarioResponsavelService.save(usuarioResponsavelDTO);

        return ResponseEntity.ok(usuarioResponsavelSaved);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RESPONSAVEL_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Usuarios Responsaveis por ID.", description = "Endpoint para buscar usuarios responsaveis pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioResponsavelDTO> getById(@PathVariable UUID id) {
        return usuarioResponsavelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RESPONSAVEL_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização de responsavel.", description = "Endpoint para atualizar os dados do responsavel.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioResponsavelDTO> update(@PathVariable UUID id, @RequestBody UsuarioResponsavelDTO usuarioResponsavelDTO) {
        return usuarioResponsavelService.update(id, usuarioResponsavelDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RESPONSAVEL_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de responsavel.", description = "Endpoint para remover uma responsavel.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (usuarioResponsavelService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
