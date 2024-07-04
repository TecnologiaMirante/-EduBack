package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.service.QuestoesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados das Questões", name = "Questoes")
@RequestMapping("/questoes")
public class QuestoesController {
    @Autowired
    private QuestoesService questoesService;


}
