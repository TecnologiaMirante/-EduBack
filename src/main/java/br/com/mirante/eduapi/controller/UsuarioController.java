package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.dto.UsuarioDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.UsuarioMapper;
import br.com.mirante.eduapi.models.Usuario;
import br.com.mirante.eduapi.service.UsuarioService;
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
@Tag(description = "Retorna Dados dos Usuarios", name = "Usuario")
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os usuarios", description = "Endpoint para consultar usuarios. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<UsuarioDTO>> findAll(SpecTemplate.UsuarioSpec spec, Pageable page) {
        Page<Usuario> consultaPage = usuarioService.findAll(spec, page);

        if (consultaPage.isEmpty()){
            return  new ResponseEntity<>(consultaPage.map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO), HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(consultaPage.map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO), HttpStatus.OK);
        }
    }
    @PostMapping("/")
    @Operation(summary = "Cadastro de Usuarios.", description = "Endpoint para cadastrar Usuarios.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTOPost> create(@RequestBody UsuarioDTOPost usuarioDTO) throws BusinessException {

        UsuarioDTOPost usuarioSaved = usuarioService.save(usuarioDTO);

        return ResponseEntity.ok(usuarioSaved);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Usuarios por ID.", description = "Endpoint para buscar o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> getById(@PathVariable("id") UUID id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Usuarios por ID.", description = "Endpoint para atualizar o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> update(@PathVariable UUID id, @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.update(id, usuarioDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Usuarios por ID.", description = "Endpoint para remover, o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> delete(@PathVariable UUID id){
        if (usuarioService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
