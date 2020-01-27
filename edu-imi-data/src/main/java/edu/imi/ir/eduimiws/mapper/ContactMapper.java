package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.models.dto.ContactDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mappings({
            @Mapping(source = "accountId",target = "accountId",ignore = true),
            @Mapping(source = "salutationId",target = "salutationId"),
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
            @Mapping(source = "currencyId",target = "currencyId"),
            @Mapping(source = "department",target = "department"),
            @Mapping(source = "role",target = "role"),
            @Mapping(source = "managerId",target = "managerId"),
            @Mapping(source = "managerPhone",target = "managerPhone"),
            @Mapping(source = "assistantId",target = "assistantId"),
            @Mapping(source = "assistantPhone",target = "assistantPhone"),
            @Mapping(source = "gender",target = "gender"),
            @Mapping(source = "maritalStatus",target = "maritalStatus"),
            @Mapping(source = "partnerName",target = "partnerName"),
            @Mapping(source = "birthdate",target = "birthdate"),
            @Mapping(source = "anniversary",target = "anniversary"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "parentId",target = "parentId"),
            @Mapping(source = "countryId",target = "countryId"),
            @Mapping(source = "stateId",target = "stateId"),
            @Mapping(source = "cityId",target = "cityId"),
            @Mapping(source = "addressPhone",target = "addressPhone"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "companyId",target = "companyId"),
            @Mapping(source = "organizationId",target = "organizationId"),
            @Mapping(source = "leadSourceId",target = "leadSourceId"),
            @Mapping(source = "campaignId",target = "campaignId"),
            @Mapping(source = "teamId",target = "teamId"),
            @Mapping(source = "syncOutLook",target = "syncOutLook"),
            @Mapping(source = "preferredContactMethod",target = "preferredContactMethod"),
            @Mapping(source = "allowEmail",target = "allowEmail"),
            @Mapping(source = "allowBulkEmail",target = "allowBulkEmail"),
            @Mapping(source = "allowPhone",target = "allowPhone"),
            @Mapping(source = "allowFax",target = "allowFax"),
            @Mapping(source = "allowMail",target = "allowMail"),
            @Mapping(source = "addressTypeId",target = "addressTypeId"),
            @Mapping(source = "userCreatorId",target = "userCreatorId"),
            @Mapping(source = "fromCity",target = "fromCity"),
            @Mapping(source = "certificateNo",target = "certificateNo"),
            @Mapping(source = "nationCode",target = "nationCode"),
            @Mapping(source = "fatherName",target = "fatherName"),
            @Mapping(source = "birthCityId",target = "birthCityId"),
            @Mapping(source = "accessType",target = "accessType"),
            @Mapping(source = "image",target = "image"),
            @Mapping(source = "lfirstName",target = "lfirstName"),
            @Mapping(source = "llastName",target = "llastName"),
            @Mapping(source = "religionId",target = "religionId"),
            @Mapping(source = "militaryServiceId",target = "militaryServiceId"),
            @Mapping(source = "eduLevelId",target = "eduLevelId"),
            @Mapping(source = "fieldName",target = "fieldName"),
            @Mapping(source = "bankName",target = "bankName"),
            @Mapping(source = "branchName",target = "branchName"),
            @Mapping(source = "bankAccountNumber",target = "bankAccountNumber"),
            @Mapping(source = "bankAccoountType",target = "bankAccoountType"),
            @Mapping(source = "entranceDate",target = "entranceDate"),
            @Mapping(source = "contractTypeId",target = "contractTypeId"),
            @Mapping(source = "university",target = "university"),
            @Mapping(source = "insuranceKindId",target = "insuranceKindId"),
            @Mapping(source = "insuranceBoxId",target = "insuranceBoxId"),
            @Mapping(source = "gender1",target = "gender1"),
            @Mapping(source = "marital1",target = "marital1"),
            @Mapping(source = "military1",target = "military1"),
            @Mapping(source = "editTempRowFlag",target = "editTempRowFlag"),
            @Mapping(source = "createTempRowFlag",target = "createTempRowFlag"),
            @Mapping(source = "verified",target = "verified"),
            @Mapping(source = "postalCode",target = "postalCode"),
            @Mapping(source = "editDate",target = "editDate"),
            @Mapping(source = "createDate",target = "createDate"),
            @Mapping(source = "userEditorId",target = "userEditorId"),
            @Mapping(source = "convertDateWho",target = "convertDateWho"),
            @Mapping(source = "convertUniq",target = "convertUniq"),
            @Mapping(source = "lfatherName",target = "lfatherName"),
            @Mapping(source = "lfromCity",target = "lfromCity"),
            @Mapping(source = "lfromCityId",target = "lfromCityId")
    })
    ContactEntity ContactDtoToContactEntity(ContactDto contactDto);

    @InheritInverseConfiguration
    ContactDto ContactEntityToContactDto(ContactEntity contactEntity);
}
