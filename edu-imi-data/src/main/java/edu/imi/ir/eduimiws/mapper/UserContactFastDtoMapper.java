package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.PersonWebServiceDto;
import edu.imi.ir.eduimiws.models.dto.UserContactFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserContactFastDtoMapper {

    UserContactFastDtoMapper INSTANCE = Mappers.getMapper(UserContactFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId",target = "personPublicId"),
            @Mapping(source = "contact",target = "contactFastDto")
    })
    UserContactFastDto PersonWebServiceEntityToUserContactFastDto(PersonWebServiceEntity personWebServiceEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceDto UserContactFastDtoToPersonWebServiceEntity(UserContactFastDto userContactFastDto, @Context CycleAvoidingMappingContext context);

}
