package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.ContactFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactFastDtoMapper {

    ContactFastDtoMapper INSTANCE = Mappers.getMapper(ContactFastDtoMapper.class);


    @Mappings({

            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "contact.firstName",target = "firstName"),
            @Mapping(source = "contact.lastName",target = "lastName"),
            @Mapping(source = "contact.mobilePhone",target = "mobilePhone"),
            @Mapping(source = "contact.email",target = "email"),
            @Mapping(source = "contact.gender",target = "gender"),
            @Mapping(source = "contact.birthdate",target = "birthdate"),
            @Mapping(source = "contact.fromCity",target = "fromCity"),
            @Mapping(source = "contact.certificateNo",target = "certificateNo"),
            @Mapping(source = "contact.nationCode",target = "nationCode"),
            @Mapping(source = "contact.fatherName",target = "fatherName"),
            @Mapping(source = "contact.description",target = "description"),
            @Mapping(source = "contact.address",target = "address"),
            @Mapping(source = "contact.lfirstName",target = "lfirstName"),
            @Mapping(source = "contact.llastName",target = "llastName"),
            @Mapping(source = "contact.postalCode",target = "postalCode"),
            @Mapping(source = "contact.lfatherName",target = "lfatherName"),
            @Mapping(source = "contact.lfromCity",target = "lfromCity")
    })
    ContactFastDto PersonWebServiceEntityToContactFastDto(PersonWebServiceEntity personWebServiceEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceEntity ContactFastDtoToPersonWebServiceEntity(ContactFastDto userContactDto, @Context CycleAvoidingMappingContext context);

}
