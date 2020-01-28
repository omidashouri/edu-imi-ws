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
//           @Mapping(source = "personId",target = "personId",ignore = true),
           @Mapping(source = "personIdT",target = "personIdT"),
           @Mapping(source = "personPublicId",target = "personPublicId"),
//           @Mapping(source = "contactId",target = "contactId"),
           @Mapping(source = "contactIdT",target = "contactIdT"),
           @Mapping(source = "contactPublicId",target = "contactPublicId"),
           @Mapping(source = "userName",target = "userName"),
           @Mapping(source = "encryptedPassword",target = "encryptedPassword"),
           @Mapping(source = "emailVerificationToken",target = "emailVerificationToken"),
           @Mapping(source = "emailVerificationStatus",target = "emailVerificationStatus"),
           @Mapping(source = "mobileVerificationStatus",target = "mobileVerificationStatus"),
//           @Mapping(source = "creatorId",target = "creatorId"),
           @Mapping(source = "creatorIdT",target = "creatorIdT"),
           @Mapping(source = "createDateTs",target = "createDateTs"),
//           @Mapping(source = "editorId.id",target = "editorId.id",ignore = true),
           @Mapping(source = "editorIdT",target = "editorIdT"),
           @Mapping(source = "editDateTs",target = "editDateTs"),
           @Mapping(source = "description",target = "description")
    })
    PersonWebServiceEntity PersonWebServiceDtoToPersonWebServiceEntity(PersonWebServiceDto personWebServiceDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceDto PersonWebServiceEntityToPersonWebServiceDto (PersonWebServiceEntity personWebServiceEntity, @Context CycleAvoidingMappingContext context);
}
