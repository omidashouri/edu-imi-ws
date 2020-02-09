package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.PersonWebServiceFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonWebServiceFastDtoMapper {

    PersonWebServiceFastDtoMapper INSTANCE = Mappers.getMapper(PersonWebServiceFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId",target = "personPublicId"),
            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "userName",target = "userName"),
            @Mapping(source = "encryptedPassword",target = "encryptedPassword"),
            @Mapping(source = "personId",target = "personId"),
            @Mapping(source = "contactId",target = "contactId"),
            @Mapping(source = "creatorId",target = "creatorId"),
            @Mapping(source = "editorId",target = "editorId"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "createDateTs",target = "createDateTs"),
            @Mapping(source = "editDateTs",target = "editDateTs"),
            @Mapping(source = "emailVerificationStatus",target = "emailVerificationStatus"),
            @Mapping(source = "emailVerificationToken",target = "emailVerificationToken"),
            @Mapping(source = "mobileVerificationStatus",target = "mobileVerificationStatus")
    })
    PersonWebServiceFastDto PersonWebServiceEntityToPersonWebServiceFastDto(PersonWebServiceEntity personWebServiceEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceEntity PersonWebServiceFastDtoToPersonWebServiceEntity(PersonWebServiceFastDto userLoginMinimalDto, @Context CycleAvoidingMappingContext context);

}
