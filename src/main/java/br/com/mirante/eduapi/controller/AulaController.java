package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.AulaDTO;
import br.com.mirante.eduapi.mappers.AulaMapper;
import br.com.mirante.eduapi.models.Aula;
import br.com.mirante.eduapi.service.AulaService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados da Aula", name = "Aula")
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;


    public ResponseEntity <Page<AulaDTO>> findAll(SpecTemplate.AulaSpec spec, Pageable page){
        Page<Aula> consultaPage = aulaService.findAll(spec,page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(AulaMapper.INSTANCE))
        }
    }

}
