package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.RoleFastDto;
import edu.imi.ir.eduimiws.models.response.crm.RoleResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleResponseRoleFastDtoMapper {

    RoleResponseRoleFastDtoMapper INSTANCE = Mappers.getMapper(RoleResponseRoleFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "rolePublicId", target = "rolePublicId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "privilegeFastDtos", target = "privilegeResponses")
    })
    @BeanMapping(ignoreByDefault = true)
    RoleResponse toRoleResponse(RoleFastDto roleFastDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    RoleFastDto toRoleFastDto(RoleResponse roleResponse, @Context CycleAvoidingMappingContext context);

    List<RoleResponse> toRoleResponses(List<RoleFastDto> roleFastDtos, @Context CycleAvoidingMappingContext context);

    List<RoleFastDto> toRoleFastDtos(List<RoleResponse> roleResponses, @Context CycleAvoidingMappingContext context);

}
