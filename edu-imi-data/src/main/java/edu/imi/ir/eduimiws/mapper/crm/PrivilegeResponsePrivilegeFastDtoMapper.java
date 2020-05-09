package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PrivilegeFastDto;
import edu.imi.ir.eduimiws.models.response.crm.PrivilegeResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PrivilegeResponsePrivilegeFastDtoMapper {

    PrivilegeResponsePrivilegeFastDtoMapper INSTANCE = Mappers.getMapper(PrivilegeResponsePrivilegeFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "privilegePublicId", target = "privilegePublicId"),
            @Mapping(source = "name", target = "name")
    })
    @BeanMapping(ignoreByDefault = true)
    PrivilegeResponse toPrivilegeResponse(PrivilegeFastDto privilegeFastDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PrivilegeFastDto toPrivilegeFastDto(PrivilegeResponse privilegeResponse, @Context CycleAvoidingMappingContext context);

    List<PrivilegeResponse> toPrivilegeResponses(List<PrivilegeFastDto> privilegeFastDtos, @Context CycleAvoidingMappingContext context);

    List<PrivilegeFastDto> toPrivilegeFastDtos(List<PrivilegeResponse> privilegeResponses, @Context CycleAvoidingMappingContext context);


}
