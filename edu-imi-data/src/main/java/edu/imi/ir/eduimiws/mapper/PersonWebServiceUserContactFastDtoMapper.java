package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.PersonWebServiceDto;
import edu.imi.ir.eduimiws.models.dto.UserContactFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonWebServiceUserContactFastDtoMapper {

    PersonWebServiceUserContactFastDtoMapper INSTANCE = Mappers.getMapper(PersonWebServiceUserContactFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId",target = "personPublicId"),
            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "contact",target = "userContactResponseDto")

    })
    UserContactFastDto PersonWebServiceEntityToUserContactFastDto(PersonWebServiceEntity personWebServiceEntity,@Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceDto UserContactFastDtoToPersonWebServiceEntity(UserContactFastDto userContactFastDto, @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleContactFastDtoContactPublicId(PersonWebServiceEntity personWebServiceEntity, @MappingTarget UserContactFastDto userContactFastDto) {
      userContactFastDto.getUserContactResponseDto().setContactPublicId(personWebServiceEntity.getContactPublicId());
    }
}
