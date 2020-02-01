package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.PersonWebServiceDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonWebServiceMapper {

    PersonWebServiceMapper INSTANCE = Mappers.getMapper(PersonWebServiceMapper.class);

//    omiddo:correct ignore by removing extra joins
    @Mappings({
//           @Mapping(source = "person",target = "person",ignore = true),
           @Mapping(source = "personId",target = "personId"),
           @Mapping(source = "personPublicId",target = "personPublicId"),
//           @Mapping(source = "contact",target = "contact"),
           @Mapping(source = "contactId",target = "contactId"),
           @Mapping(source = "contactPublicId",target = "contactPublicId"),
           @Mapping(source = "userName",target = "userName"),
           @Mapping(source = "encryptedPassword",target = "encryptedPassword"),
           @Mapping(source = "emailVerificationToken",target = "emailVerificationToken"),
           @Mapping(source = "emailVerificationStatus",target = "emailVerificationStatus"),
           @Mapping(source = "mobileVerificationStatus",target = "mobileVerificationStatus"),
//           @Mapping(source = "creator",target = "creator"),
           @Mapping(source = "creatorId",target = "creatorId"),
           @Mapping(source = "createDateTs",target = "createDateTs"),
//           @Mapping(source = "editor",target = "editor",ignore = true),
           @Mapping(source = "editorId",target = "editorId"),
           @Mapping(source = "editDateTs",target = "editDateTs"),
           @Mapping(source = "description",target = "description")
    })
    PersonWebServiceEntity PersonWebServiceDtoToPersonWebServiceEntity(PersonWebServiceDto personWebServiceDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceDto PersonWebServiceEntityToPersonWebServiceDto (PersonWebServiceEntity personWebServiceEntity, @Context CycleAvoidingMappingContext context);
}
