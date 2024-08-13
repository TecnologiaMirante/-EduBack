package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.MediaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.MediaMapper;
import br.com.mirante.eduapi.models.Media;
import br.com.mirante.eduapi.service.MediaService;
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
@RequestMapping(value = "/Media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.MEDIA_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar Media.", description = "Endpoint para consultar Media.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<MediaDTO>> findAll(SpecTemplate.MediaSpec spec, Pageable page){
        Page<Media> consultaPage = mediaService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(MediaMapper.INSTANCE::ToMediaDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(MediaMapper.INSTANCE::ToMediaDTO), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MEDIA_CADASTRAR)")
    @PostMapping()
    @Operation(summary = "Cadastro de Media.", description = "Endpoint para cadastrar Media.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<MediaDTO> create(@RequestBody MediaDTO mediaDTO) throws BusinessException {
        MediaDTO savedMedia = mediaService.save(mediaDTO);
        return ResponseEntity.ok(savedMedia);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MEDIA_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Media por ID.", description = "Endpoint para buscar a Media pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<MediaDTO> getById(@PathVariable UUID id) {
        return mediaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MEDIA_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Media.", description = "Endpoint para atualizar os dados das Media.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<MediaDTO> update(@PathVariable UUID id, @RequestBody MediaDTO mediaDTO) {
        return mediaService.update(id, mediaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MEDIA_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Media.", description = "Endpoint para remover uma Media.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (mediaService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
