package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PersonApiDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonApiMapper {

    PersonApiMapper INSTANCE = Mappers.getMapper(PersonApiMapper.class);

//    omiddo:correct ignore by removing extra joins
    @Mappings({
           @Mapping(source = "person",target = "person"),
           @Mapping(source = "personId",target = "personId"),
           @Mapping(source = "personPublicId",target = "personPublicId"),
           @Mapping(source = "contact",target = "contact"),
           @Mapping(source = "contactId",target = "contactId"),
           @Mapping(source = "contactPublicId",target = "contactPublicId"),
           @Mapping(source = "userName",target = "userName"),
           @Mapping(source = "encryptedPassword",target = "encryptedPassword"),
           @Mapping(source = "emailVerificationToken",target = "emailVerificationToken"),
           @Mapping(source = "emailVerificationStatus",target = "emailVerificationStatus"),
           @Mapping(source = "mobileVerificationStatus",target = "mobileVerificationStatus"),
           @Mapping(source = "creator",target = "creator"),
           @Mapping(source = "creatorId",target = "creatorId"),
           @Mapping(source = "createDateTs",target = "createDateTs"),
           @Mapping(source = "editor",target = "editor"),
           @Mapping(source = "editorId",target = "editorId"),
           @Mapping(source = "editDateTs",target = "editDateTs"),
           @Mapping(source = "description",target = "description")
    })
    PersonApiEntity PersonWebServiceDtoToPersonWebServiceEntity(PersonApiDto personApiDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonApiDto PersonWebServiceEntityToPersonWebServiceDto (PersonApiEntity personApiEntity, @Context CycleAvoidingMappingContext context);
}
