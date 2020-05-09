package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PrivilegeFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PrivilegeFastDtoMapper {

    PrivilegeFastDtoMapper INSTANCE = Mappers.getMapper(PrivilegeFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "privilegePublicId", target = "privilegePublicId"),
            @Mapping(source = "name", target = "name")
    })
    @BeanMapping(ignoreByDefault = true)
    PrivilegeApiEntity toPrivilegeApiEntity(PrivilegeFastDto privilegeFastDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PrivilegeFastDto toPrivilegeFastDto(PrivilegeApiEntity privilegeApiEntity, @Context CycleAvoidingMappingContext context);

    List<PrivilegeApiEntity> toPrivilegeApiEntities(List<PrivilegeFastDto> privilegeFastDtos, @Context CycleAvoidingMappingContext context);

    List<PrivilegeFastDto> toPrivilegeFastDtos(List<PrivilegeApiEntity> privilegeApiEntities, @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handleContactPublicIds(PrivilegeApiEntity personEntity, @MappingTarget PrivilegeFastDto privilegeFastDto) {
        if(!Hibernate.isInitialized(privilegeApiEntity.getContact())) {
            privilegeApiEntity.setContact(null);
        }
        if(privilegeApiEntity.getContact()!=null) {
            if (privilegeApiEntity.getContact().getContactWebService() != null) {
                privilegeFastDto.setContactPublicId(privilegeApiEntity.getContact().getContactWebService().getContactPublicId());
            }
            if (privilegeApiEntity.getContact().getNationCode() != null) {
                privilegeFastDto.setNationCode(privilegeApiEntity.getContact().getNationCode());
            }
        }
    }*/
}
