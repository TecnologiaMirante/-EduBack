package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.ConquistaDTOPost;
import br.com.mirante.eduapi.dto.ConquistasDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.ConquistaMapper;
import br.com.mirante.eduapi.models.Conquistas;
import br.com.mirante.eduapi.service.ConquistaService;
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
@Tag(description = "Retorna Dados das conquistas", name = "conquistas")
@RequestMapping("/conquistas")
public class ConquistaController {
    @Autowired
    private ConquistaService conquistaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar as Conquistas.", description = "Endpoint para consultar as Conquistas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<ConquistasDTO>> findAll(SpecTemplate.ConquistaSpec spec, Pageable page) {
        Page<Conquistas> consultaPage = conquistaService.findAll(spec, page);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(ConquistaMapper.INSTANCE::conquistasToDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(ConquistaMapper.INSTANCE::conquistasToDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de conquista.", description = "Endpoint para cadastrar conquista.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ConquistaDTOPost> create(@RequestBody ConquistaDTOPost conquistasDTO) throws BusinessException {
        ConquistaDTOPost savedConqusta = conquistaService.save(conquistasDTO);
        return ResponseEntity.ok(savedConqusta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar conquista por ID.", description = "Endpoint para buscar a conquista pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ConquistasDTO> getById(@PathVariable UUID id) {
        return conquistaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de conquista.", description = "Endpoint para atualizar os dados das conquista.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ConquistasDTO> update(@PathVariable UUID id, @RequestBody ConquistasDTO conquistasDTO) {
        return conquistaService.update(id, conquistasDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de conquista.", description = "Endpoint para remover uma conquista.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (conquistaService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
