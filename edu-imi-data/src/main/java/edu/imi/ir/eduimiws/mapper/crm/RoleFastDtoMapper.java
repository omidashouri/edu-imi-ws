package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.RoleFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleFastDtoMapper {

    RoleFastDtoMapper INSTANCE = Mappers.getMapper(RoleFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "rolePublicId", target = "rolePublicId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "privilegeFastDtos", target = "privileges")
    })
    @BeanMapping(ignoreByDefault = true)
    RoleApiEntity toRoleApiEntity(RoleFastDto roleFastDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    RoleFastDto toRoleFastDto(RoleApiEntity roleApiEntity, @Context CycleAvoidingMappingContext context);

    List<RoleApiEntity> toRoleApiEntities(List<RoleFastDto> roleFastDtos, @Context CycleAvoidingMappingContext context);

    List<RoleFastDto> toRoleFastDtos(List<RoleApiEntity> roleApiEntities, @Context CycleAvoidingMappingContext context);

}
