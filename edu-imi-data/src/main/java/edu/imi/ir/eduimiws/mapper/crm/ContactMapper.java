package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mappings({
            @Mapping(source = "account",target = "account"),
//            @Mapping(source = "accountId",target = "accountId"),
            @Mapping(source = "salutation",target = "salutation"),
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
            @Mapping(source = "currency",target = "currency"),
            @Mapping(source = "department",target = "department"),
            @Mapping(source = "role",target = "role"),
            @Mapping(source = "manager",target = "manager"),
            @Mapping(source = "managerPhone",target = "managerPhone"),
            @Mapping(source = "assistant",target = "assistant"),
            @Mapping(source = "assistantPhone",target = "assistantPhone"),
            @Mapping(source = "gender",target = "gender"),
            @Mapping(source = "maritalStatus",target = "maritalStatus"),
            @Mapping(source = "partnerName",target = "partnerName"),
            @Mapping(source = "birthdate",target = "birthdate"),
            @Mapping(source = "anniversary",target = "anniversary"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "parent",target = "parent"),
            @Mapping(source = "country",target = "country"),
            @Mapping(source = "state",target = "state"),
            @Mapping(source = "city",target = "city"),
            @Mapping(source = "addressPhone",target = "addressPhone"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "company",target = "company"),
            @Mapping(source = "organization",target = "organization"),
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
            @Mapping(source = "addressType",target = "addressType"),
            @Mapping(source = "userCreator",target = "userCreator"),
            @Mapping(source = "fromCity",target = "fromCity"),
            @Mapping(source = "certificateNo",target = "certificateNo"),
            @Mapping(source = "nationCode",target = "nationCode"),
            @Mapping(source = "fatherName",target = "fatherName"),
            @Mapping(source = "birthCity",target = "birthCity"),
            @Mapping(source = "accessType",target = "accessType"),
            @Mapping(source = "image",target = "image"),
            @Mapping(source = "lfirstName",target = "lfirstName"),
            @Mapping(source = "llastName",target = "llastName"),
            @Mapping(source = "religion",target = "religion"),
            @Mapping(source = "militaryService",target = "militaryService"),
            @Mapping(source = "eduLevel",target = "eduLevel"),
            @Mapping(source = "fieldName",target = "fieldName"),
            @Mapping(source = "bankName",target = "bankName"),
            @Mapping(source = "branchName",target = "branchName"),
            @Mapping(source = "bankAccountNumber",target = "bankAccountNumber"),
            @Mapping(source = "bankAccoountType",target = "bankAccoountType"),
            @Mapping(source = "entranceDate",target = "entranceDate"),
            @Mapping(source = "contractType",target = "contractType"),
            @Mapping(source = "university",target = "university"),
            @Mapping(source = "insuranceKind",target = "insuranceKind"),
            @Mapping(source = "insuranceBox",target = "insuranceBox"),
            @Mapping(source = "gender1",target = "gender1"),
            @Mapping(source = "marital1",target = "marital1"),
            @Mapping(source = "military1",target = "military1"),
            @Mapping(source = "editTempRowFlag",target = "editTempRowFlag"),
            @Mapping(source = "createTempRowFlag",target = "createTempRowFlag"),
            @Mapping(source = "verified",target = "verified"),
            @Mapping(source = "postalCode",target = "postalCode"),
            @Mapping(source = "editDate",target = "editDate"),
            @Mapping(source = "createDate",target = "createDate"),
            @Mapping(source = "userEditor",target = "userEditor"),
            @Mapping(source = "convertDateWho",target = "convertDateWho"),
            @Mapping(source = "convertUniq",target = "convertUniq"),
            @Mapping(source = "lfatherName",target = "lfatherName"),
            @Mapping(source = "lfromCity",target = "lfromCity"),
            @Mapping(source = "lfromCityEntity",target = "lfromCityEntity")
    })
    ContactEntity ContactDtoToContactEntity(ContactDto contactDto , @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    ContactDto ContactEntityToContactDto(ContactEntity contactEntity, @Context CycleAvoidingMappingContext context);
}
