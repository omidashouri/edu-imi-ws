package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponse;
import edu.imi.ir.eduimiws.services.crm.ContactPublicIdzService;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
,imports = {ContactPublicIdzService.class})
public interface ContactResponseContactFastDtoMapper {

    ContactResponseContactFastDtoMapper INSTANCE = Mappers.getMapper(ContactResponseContactFastDtoMapper.class);


    @Mappings({
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "personPublicId", target = "userPublicId"),
            @Mapping(source = "companyPublicId", target = "companyPublicId"),
            @Mapping(source = "organizationPublicId", target = "organizationPublicId"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "countryPublicId", target = "countryPublicId"),
            @Mapping(source = "statePublicId", target = "statePublicId"),
            @Mapping(source = "cityPublicId", target = "cityPublicId"),
            @Mapping(source = "birthCityPublicId", target = "birthCityPublicId"),
            @Mapping(source = "religionPublicId", target = "religionPublicId"),
            @Mapping(source = "militaryServicePublicId", target = "militaryServicePublicId"),
            @Mapping(source = "eduLevelPublicId", target = "eduLevelPublicId"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "jobTitle", target = "jobTitle"),
            @Mapping(source = "businessPhone", target = "businessPhone"),
            @Mapping(source = "homePhone", target = "homePhone"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "faxNumber", target = "faxNumber"),
            @Mapping(source = "pagerNumber", target = "pagerNumber"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "department", target = "department"),
            @Mapping(source = "role", target = "role"),
            @Mapping(source = "managerPhone", target = "managerPhone"),
            @Mapping(source = "assistantPhone", target = "assistantPhone"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "maritalStatus", target = "maritalStatus"),
            @Mapping(source = "partnerName", target = "partnerName"),
            @Mapping(source = "birthdate", target = "birthdate"),
            @Mapping(source = "anniversary", target = "anniversary"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "addressPhone", target = "addressPhone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "syncOutLook", target = "syncOutLook"),
            @Mapping(source = "preferredContactMethod", target = "preferredContactMethod"),
            @Mapping(source = "allowEmail", target = "allowEmail"),
            @Mapping(source = "allowBulkEmail", target = "allowBulkEmail"),
            @Mapping(source = "allowPhone", target = "allowPhone"),
            @Mapping(source = "allowFax", target = "allowFax"),
            @Mapping(source = "allowMail", target = "allowMail"),
            @Mapping(source = "fromCity", target = "fromCity"),
            @Mapping(source = "certificateNo", target = "certificateNo"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "fatherName", target = "fatherName"),
            @Mapping(source = "accessType", target = "accessType"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "lfirstName", target = "lfirstName"),
            @Mapping(source = "llastName", target = "llastName"),
            @Mapping(source = "fieldName", target = "fieldName"),
            @Mapping(source = "bankName", target = "bankName"),
            @Mapping(source = "branchName", target = "branchName"),
            @Mapping(source = "bankAccountNumber", target = "bankAccountNumber"),
            @Mapping(source = "bankAccoountType", target = "bankAccoountType"),
            @Mapping(source = "entranceDate", target = "entranceDate"),
            @Mapping(source = "university", target = "university"),
            @Mapping(source = "gender1", target = "gender1"),
            @Mapping(source = "marital1", target = "marital1"),
            @Mapping(source = "military1", target = "military1"),
            @Mapping(source = "editTempRowFlag", target = "editTempRowFlag"),
            @Mapping(source = "createTempRowFlag", target = "createTempRowFlag"),
            @Mapping(source = "verified", target = "verified"),
            @Mapping(source = "postalCode", target = "postalCode"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "convertDateWho", target = "convertDateWho"),
            @Mapping(source = "convertUniq", target = "convertUniq"),
            @Mapping(source = "lfatherName", target = "lfatherName"),
            @Mapping(source = "lfromCity", target = "lfromCity")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
            ignoreByDefault = true)
    ContactResponse toContactResponse(ContactFastDto contactFastDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
            ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "id",
            expression = "java(new ContactPublicIdzService().findContactIdByContactPublicId(" +
                    "contactResponse.getContactPublicId()))"),
            @Mapping(target = "account",
            expression = "java(new ContactPublicIdzService().findAccountDtoByAccountPublicId(" +
                    "contactResponse.getAccountPublicId()))"),
            @Mapping(target = "company",
                    expression = "java(new ContactPublicIdzService().findCompanyDtoByCompanyPublicId(" +
                            "contactResponse.getCompanyPublicId()))"),
            @Mapping(target = "organization",
                    expression = "java(new ContactPublicIdzService().findOrganizationDtoByOrganizationPublicId(" +
                            "contactResponse.getOrganizationPublicId()))")
    })
    @InheritInverseConfiguration
    ContactFastDto toContactFastDto(ContactResponse contactResponse, @Context CycleAvoidingMappingContext context);

    List<ContactResponse> toContactResponses(List<ContactFastDto> ContactFastDtos, @Context CycleAvoidingMappingContext context);

    List<ContactFastDto> toContactFastDtos(List<ContactResponse> contactResponses, @Context CycleAvoidingMappingContext context);

}
