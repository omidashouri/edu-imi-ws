package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.PersonWebServiceDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonWebServiceMapper {

    PersonWebServiceMapper INSTANCE = Mappers.getMapper(PersonWebServiceMapper.class);

    @Mappings({
           @Mapping(source = "personId",target = "personId"),
           @Mapping(source = "personPublicId",target = "personPublicId"),
           @Mapping(source = "contactId",target = "contactId"),
           @Mapping(source = "contactPublicId",target = "contactPublicId"),
           @Mapping(source = "encryptedPassword",target = "encryptedPassword"),
           @Mapping(source = "emailVerificationToken",target = "emailVerificationToken"),
           @Mapping(source = "emailVerificationStatus",target = "emailVerificationStatus"),
           @Mapping(source = "creatorId",target = "creatorId"),
           @Mapping(source = "createDateTs",target = "createDateTs"),
           @Mapping(source = "editorId",target = "editorId"),
           @Mapping(source = "editDateTs",target = "editDateTs"),
           @Mapping(source = "description",target = "description")
    })
    PersonWebServiceEntity PersonWebServiceDtoToPersonWebServiceEntity(PersonWebServiceDto personWebServiceDto);

    @InheritInverseConfiguration
    PersonWebServiceDto PersonWebServiceEntityToPersonWebServiceDto (PersonWebServiceEntity personWebServiceEntity);
}
