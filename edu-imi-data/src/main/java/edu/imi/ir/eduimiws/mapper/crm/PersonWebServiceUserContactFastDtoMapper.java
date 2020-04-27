package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PersonApiDto;
import edu.imi.ir.eduimiws.models.dto.crm.UserContactFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonWebServiceUserContactFastDtoMapper {

    PersonWebServiceUserContactFastDtoMapper INSTANCE = Mappers.getMapper(PersonWebServiceUserContactFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId",target = "personPublicId"),
            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "contact",target = "userContactResponseDto")

    })
    UserContactFastDto PersonWebServiceEntityToUserContactFastDto(PersonApiEntity personApiEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonApiDto UserContactFastDtoToPersonWebServiceEntity(UserContactFastDto userContactFastDto, @Context CycleAvoidingMappingContext context);

    List<UserContactFastDto> PersonWebServiceEntityToUserContactFastDtoes(List<PersonApiEntity> personWebServiceEntities, @Context CycleAvoidingMappingContext context);

    List<PersonApiDto> UserContactFastDtoToPersonWebServiceEntities(List<UserContactFastDto> userContactFastDtos, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleContactFastDtoContactPublicId(PersonApiEntity personApiEntity, @MappingTarget UserContactFastDto userContactFastDto) {
      userContactFastDto.getUserContactResponseDto().setContactPublicId(personApiEntity.getContactPublicId());
    }


}
