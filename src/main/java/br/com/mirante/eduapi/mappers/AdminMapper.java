package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AdminDTO;
import br.com.mirante.eduapi.models.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mappings({
            @Mapping(source = "usuarioEscola.id", target = "escolaId"),
    })
    AdminDTO adminToAdminDTO(Admin admin);


    Admin adminDTOToAdmin(AdminDTO adminDTO);
}
