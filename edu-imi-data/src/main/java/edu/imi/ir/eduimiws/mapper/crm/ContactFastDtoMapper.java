package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactFastDtoMapper {

    ContactFastDtoMapper INSTANCE = Mappers.getMapper(ContactFastDtoMapper.class);

/*
    accountPublicId, salutationPublicId, currencyPublicId, managerPublicId, assistantPublicId, parentPublicId
    countryPublicId, statePublicId, cityPublicId, companyPublicId, organizationPublicId, leadSourcePublicId
    campaignPublicId, teamPublicId, addressTypePublicId, userCreatorPublicId, birthCityPublicId,
    religionPublicId, militaryServicePublicId, eduLevelPublicId, contractTypePublicId, insuranceKindPublicId,
    insuranceBoxPublicId, userEditorPublicId, lfromCityEntityPublicId

*/

    @Mappings({
            @Mapping(source = "contactPublicId",target = "contactWebService.contactPublicId"),
            @Mapping(source = "firstName",target = "firstName"),
            @Mapping(source = "middleName",target = "middleName"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "jobTitle",target = "jobTitle"),
            @Mapping(source = "businessPhone",target = "businessPhone"),
            @Mapping(source = "homePhone",target = "homePhone"),
            @Mapping(source = "mobilePhone",target = "mobilePhone"),
            @Mapping(source = "faxNumber",target = "faxNumber"),
            @Mapping(source = "pagerNumber",target = "pagerNumber"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "department",target = "department"),
            @Mapping(source = "role",target = "role"),
            @Mapping(source = "managerPhone",target = "managerPhone"),
            @Mapping(source = "assistantPhone",target = "assistantPhone"),
            @Mapping(source = "gender",target = "gender"),
            @Mapping(source = "maritalStatus",target = "maritalStatus"),
            @Mapping(source = "partnerName",target = "partnerName"),
            @Mapping(source = "birthdate",target = "birthdate"),
            @Mapping(source = "anniversary",target = "anniversary"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "addressPhone",target = "addressPhone"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "syncOutLook",target = "syncOutLook"),
            @Mapping(source = "preferredContactMethod",target = "preferredContactMethod"),
            @Mapping(source = "allowEmail",target = "allowEmail"),
            @Mapping(source = "allowBulkEmail",target = "allowBulkEmail"),
            @Mapping(source = "allowPhone",target = "allowPhone"),
            @Mapping(source = "allowFax",target = "allowFax"),
            @Mapping(source = "allowMail",target = "allowMail"),
            @Mapping(source = "fromCity",target = "fromCity"),
            @Mapping(source = "certificateNo",target = "certificateNo"),
            @Mapping(source = "nationCode",target = "nationCode"),
            @Mapping(source = "fatherName",target = "fatherName"),
            @Mapping(source = "accessType",target = "accessType"),
            @Mapping(source = "image",target = "image"),
            @Mapping(source = "lfirstName",target = "lfirstName"),
            @Mapping(source = "llastName",target = "llastName"),
            @Mapping(source = "fieldName",target = "fieldName"),
            @Mapping(source = "bankName",target = "bankName"),
            @Mapping(source = "branchName",target = "branchName"),
            @Mapping(source = "bankAccountNumber",target = "bankAccountNumber"),
            @Mapping(source = "bankAccoountType",target = "bankAccoountType"),
            @Mapping(source = "entranceDate",target = "entranceDate"),
            @Mapping(source = "university",target = "university"),
            @Mapping(source = "gender1",target = "gender1"),
            @Mapping(source = "marital1",target = "marital1"),
            @Mapping(source = "military1",target = "military1"),
            @Mapping(source = "editTempRowFlag",target = "editTempRowFlag"),
            @Mapping(source = "createTempRowFlag",target = "createTempRowFlag"),
            @Mapping(source = "verified",target = "verified"),
            @Mapping(source = "postalCode",target = "postalCode"),
            @Mapping(source = "editDate",target = "editDate"),
            @Mapping(source = "createDate",target = "createDate"),
            @Mapping(source = "convertDateWho",target = "convertDateWho"),
            @Mapping(source = "convertUniq",target = "convertUniq"),
            @Mapping(source = "lfatherName",target = "lfatherName"),
            @Mapping(source = "lfromCity",target = "lfromCity")
    })
    @BeanMapping(ignoreByDefault = true)
    ContactEntity toContactEntity(ContactFastDto contactFastDto , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ContactFastDto toContactFastDto(ContactEntity contactEntity, @Context CycleAvoidingMappingContext context);

    List<ContactEntity> toContactEntities(List<ContactFastDto> ContactFastDtos, @Context CycleAvoidingMappingContext context);

    List<ContactFastDto> toContactFastDtos(List<ContactEntity> contactEntities, @Context CycleAvoidingMappingContext context);

}
