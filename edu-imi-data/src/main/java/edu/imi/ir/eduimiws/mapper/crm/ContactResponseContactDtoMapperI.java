package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@DecoratedWith(ContactResponseContactDtoMapperIDecorator.class)
public interface ContactResponseContactDtoMapperI {

    @Mappings({
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "accessType", target = "accessType"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "addressPhone", target = "addressPhone"),
            @Mapping(source = "addressTypePublicId", target = "addressTypePublicId"),
            @Mapping(source = "allowBulkEmail", target = "allowBulkEmail"),
            @Mapping(source = "allowEmail", target = "allowEmail"),
            @Mapping(source = "allowFax", target = "allowFax"),
            @Mapping(source = "allowMail", target = "allowMail"),
            @Mapping(source = "allowPhone", target = "allowPhone"),
            @Mapping(source = "anniversary", target = "anniversary"),
            @Mapping(source = "assistantPhone", target = "assistantPhone"),
            @Mapping(source = "assistantPublicId", target = "assistantPublicId"),
            @Mapping(source = "bankAccoountType", target = "bankAccoountType"),
            @Mapping(source = "bankAccountNumber", target = "bankAccountNumber"),
            @Mapping(source = "bankName", target = "bankName"),
            @Mapping(source = "birthCityPublicId", target = "birthCityPublicId"),
            @Mapping(source = "birthdate", target = "birthdate"),
            @Mapping(source = "branchName", target = "branchName"),
            @Mapping(source = "businessPhone", target = "businessPhone"),
            @Mapping(source = "certificateNo", target = "certificateNo"),
            @Mapping(source = "cityPublicId", target = "cityPublicId"),
            @Mapping(source = "companyPublicId", target = "companyPublicId"),
            @Mapping(source = "contractTypePublicId", target = "contractTypePublicId"),
            @Mapping(source = "convertDateWho", target = "convertDateWho"),
            @Mapping(source = "convertUniq", target = "convertUniq"),
            @Mapping(source = "countryPublicId", target = "countryPublicId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "createTempRowFlag", target = "createTempRowFlag"),
            @Mapping(source = "currencyPublicId", target = "currencyPublicId"),
            @Mapping(source = "department", target = "department"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editTempRowFlag", target = "editTempRowFlag"),
            @Mapping(source = "eduLevelPublicId", target = "eduLevelPublicId"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "entranceDate", target = "entranceDate"),
            @Mapping(source = "fatherName", target = "fatherName"),
            @Mapping(source = "faxNumber", target = "faxNumber"),
            @Mapping(source = "fieldName", target = "fieldName"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "fromCity", target = "fromCity"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "gender1", target = "gender1"),
            @Mapping(source = "homePhone", target = "homePhone"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "insuranceBoxPublicId", target = "insuranceBoxPublicId"),
            @Mapping(source = "insuranceKindPublicId", target = "insuranceKindPublicId"),
            @Mapping(source = "jobTitle", target = "jobTitle"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "lfatherName", target = "lfatherName"),
            @Mapping(source = "lfirstName", target = "lfirstName"),
            @Mapping(source = "lfromCity", target = "lfromCity"),
            @Mapping(source = "lfromCityEntityPublicId", target = "lfromCityEntityPublicId"),
            @Mapping(source = "llastName", target = "llastName"),
            @Mapping(source = "managerPhone", target = "managerPhone"),
            @Mapping(source = "managerPublicId", target = "managerPublicId"),
            @Mapping(source = "marital1", target = "marital1"),
            @Mapping(source = "maritalStatus", target = "maritalStatus"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "military1", target = "military1"),
            @Mapping(source = "militaryServicePublicId", target = "militaryServicePublicId"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "organizationPublicId", target = "organizationPublicId"),
            @Mapping(source = "pagerNumber", target = "pagerNumber"),
            @Mapping(source = "parentPublicId", target = "parentPublicId"),
            @Mapping(source = "partnerName", target = "partnerName"),
            @Mapping(source = "postalCode", target = "postalCode"),
            @Mapping(source = "preferredContactMethod", target = "preferredContactMethod"),
            @Mapping(source = "religionPublicId", target = "religionPublicId"),
            @Mapping(source = "role", target = "role"),
            @Mapping(source = "salutationPublicId", target = "salutationPublicId"),
            @Mapping(source = "statePublicId", target = "statePublicId"),
            @Mapping(source = "syncOutLook", target = "syncOutLook"),
            @Mapping(source = "university", target = "university"),
            @Mapping(source = "userCreatorPublicId", target = "userCreatorPublicId"),
            @Mapping(source = "userEditorPublicId", target = "userEditorPublicId"),
            @Mapping(source = "verified", target = "verified")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
            ignoreByDefault = true)
    ContactDto toContactDto(ContactResponse contactResponse, @Context CycleAvoidingMappingContext context);

    List<ContactDto> toContactDtos(List<ContactResponse> contactResponses,
                                   @Context CycleAvoidingMappingContext context);


}
