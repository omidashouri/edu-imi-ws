package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.ClientApiEntity;
import edu.imi.ir.eduimiws.models.dto.crm.ClientApiDto;
import edu.imi.ir.eduimiws.models.response.crm.ClientApiResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientApiMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "clientPublicId", target = "clientPublicId"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "companyName", target = "companyName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "personApiId", target = "personApiId"),
            @Mapping(source = "personApi.personPublicId", target = "personPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(target = "clientSecret", ignore = true),
            @Mapping(target = "clientCredentialsBase64", ignore = true)
    })
    @BeanMapping(ignoreByDefault = true)
    ClientApiDto toClientApiDto(ClientApiEntity entity);

    List<ClientApiDto> toClientApiDtos(List<ClientApiEntity> entities);

    @Mappings({
            @Mapping(source = "clientPublicId", target = "clientPublicId"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "companyName", target = "companyName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "enabled", target = "enabled"),
            @Mapping(source = "personPublicId", target = "personPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "clientSecret", target = "clientSecret"),
            @Mapping(source = "clientCredentialsBase64", target = "clientCredentialsBase64")
    })
    @BeanMapping(ignoreByDefault = true)
    ClientApiResponse toClientApiResponse(ClientApiDto dto);

    List<ClientApiResponse> toClientApiResponses(List<ClientApiDto> dtos);
}
