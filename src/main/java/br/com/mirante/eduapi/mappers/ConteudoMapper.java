package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.dto.ConteudoDTOpost;
import br.com.mirante.eduapi.models.Aula;
import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.models.MaterialComplementar;
import br.com.mirante.eduapi.models.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mapper
public interface ConteudoMapper{
    ConteudoMapper INSTANCE = Mappers.getMapper(ConteudoMapper.class);

    @Mapping(source = "aulasDisponiveis", target = "aulas")
    @Mapping(source = "materialComplementar", target = "materiais")
    @Mapping(source = "bimestre.id", target = "id_bimestre")
    @Mapping(source = "disciplinaConteudo.id", target = "id_disciplina")
    @Mapping(source = "professorConteudo.id", target = "id_professor")
    ConteudoDTO ToConteudoDTO(Conteudo conteudo);

    @Mapping(source = "aulas", target = "aulasDisponiveis")
    @Mapping(source = "materiais", target = "materialComplementar")
    @Mapping(source = "id_bimestre", target = "bimestre.id")
    @Mapping(source = "id_disciplina", target = "disciplinaConteudo.id")
    @Mapping(source = "id_professor", target = "professorConteudo.id")
    Conteudo ToConteudo(ConteudoDTO conteudoDTO);


    @Mapping(source = "aulasDisponiveis", target = "id_aula",  qualifiedByName = "aulaListToFirstId")
    @Mapping(source = "materialComplementar", target = "id_materiais",  qualifiedByName = "materialListToFirstId")
    ConteudoDTOpost ToConteudoDTOpost(Conteudo conteudo);
    @Mapping(source = "id_aula", target = "aulasDisponiveis",  qualifiedByName = "uuidToAulaList")
    @Mapping(source = "id_materiais", target = "materialComplementar",  qualifiedByName = "uuidToMateriaisList")
    Conteudo PostToConteudo(ConteudoDTOpost conteudoDTOpost);

    @Named("aulaListToFirstId")
    static UUID aulaListToFirstId(List<Aula> aulas) {
        return aulas.isEmpty() ? null : aulas.get(0).getId();
    }

    @Named("materialListToFirstId")
    static UUID meaterialListToFirstId(List<MaterialComplementar> materialComplementars) {
        return materialComplementars.isEmpty() ? null : materialComplementars.get(0).getId();
    }

    @Named("uuidToAulaList")
    static List<Aula> uuidToAulaList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Aula aula = new Aula();
        aula.setId(uuid);
        return Collections.singletonList(aula);
    }

    @Named("uuidToMateriaisList")
    static List<MaterialComplementar> uuidToMateriaisList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        MaterialComplementar materialComplementar = new MaterialComplementar();
        materialComplementar.setId(uuid);
        return Collections.singletonList(materialComplementar);
    }
}


