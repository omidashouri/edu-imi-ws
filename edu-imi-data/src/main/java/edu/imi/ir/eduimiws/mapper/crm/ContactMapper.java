package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

//NU
@Mapper(componentModel = "spring",
        uses = {AccountMapper.class},
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mappings({
            @Mapping(source = "accountDto", target = "account"),
            @Mapping(source = "accountId", target = "account.id"),
            @Mapping(source = "salutationDto", target = "salutation"),
            @Mapping(source = "salutationId", target = "salutation.id"),
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
            @Mapping(source = "currencyDto", target = "currency"),
            @Mapping(source = "currencyId", target = "currency.id"),
            @Mapping(source = "department", target = "department"),
            @Mapping(source = "role", target = "role"),
            @Mapping(source = "managerDto", target = "manager"),
            @Mapping(source = "managerId", target = "manager.id"),
            @Mapping(source = "managerPhone", target = "managerPhone"),
            @Mapping(source = "assistantDto", target = "assistant"),
            @Mapping(source = "assistantId", target = "assistant.id"),
            @Mapping(source = "assistantPhone", target = "assistantPhone"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "maritalStatus", target = "maritalStatus"),
            @Mapping(source = "partnerName", target = "partnerName"),
            @Mapping(source = "birthdate", target = "birthdate"),
            @Mapping(source = "anniversary", target = "anniversary"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "parentDto", target = "parent"),
            @Mapping(source = "parentId", target = "parent.id"),
            @Mapping(source = "countryDto", target = "country"),
            @Mapping(source = "countryId", target = "country.id"),
            @Mapping(source = "stateDto", target = "state"),
            @Mapping(source = "stateId", target = "state.id"),
            @Mapping(source = "cityDto", target = "city"),
            @Mapping(source = "cityId", target = "city.id"),
            @Mapping(source = "addressPhone", target = "addressPhone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "companyDto", target = "company"),
            @Mapping(source = "companyId", target = "company.id"),
            @Mapping(source = "organizationDto", target = "organization"),
            @Mapping(source = "organizationId", target = "organization.id"),
            @Mapping(source = "leadSourceId", target = "leadSourceId"),
            @Mapping(source = "campaignId", target = "campaignId"),
            @Mapping(source = "teamId", target = "teamId"),
            @Mapping(source = "syncOutLook", target = "syncOutLook"),
            @Mapping(source = "preferredContactMethod", target = "preferredContactMethod"),
            @Mapping(source = "allowEmail", target = "allowEmail"),
            @Mapping(source = "allowBulkEmail", target = "allowBulkEmail"),
            @Mapping(source = "allowPhone", target = "allowPhone"),
            @Mapping(source = "allowFax", target = "allowFax"),
            @Mapping(source = "allowMail", target = "allowMail"),
            @Mapping(source = "addressTypeDto", target = "addressType"),
            @Mapping(source = "addressTypeId", target = "addressType.id"),
            @Mapping(source = "userCreatorDto", target = "userCreator"),
            @Mapping(source = "userCreatorId", target = "userCreator.id"),
            @Mapping(source = "fromCity", target = "fromCity"),
            @Mapping(source = "certificateNo", target = "certificateNo"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "fatherName", target = "fatherName"),
            @Mapping(source = "birthCityDto", target = "birthCity"),
            @Mapping(source = "birthCityId", target = "birthCity.id"),
            @Mapping(source = "accessType", target = "accessType"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "lfirstName", target = "lfirstName"),
            @Mapping(source = "llastName", target = "llastName"),
            @Mapping(source = "religionDto", target = "religion"),
            @Mapping(source = "religionId", target = "religion.id"),
            @Mapping(source = "militaryServiceDto", target = "militaryService"),
            @Mapping(source = "militaryServiceId", target = "militaryService.id"),
            @Mapping(source = "eduLevelDto", target = "eduLevel"),
            @Mapping(source = "eduLevelId", target = "eduLevel.id"),
            @Mapping(source = "fieldName", target = "fieldName"),
            @Mapping(source = "bankName", target = "bankName"),
            @Mapping(source = "branchName", target = "branchName"),
            @Mapping(source = "bankAccountNumber", target = "bankAccountNumber"),
            @Mapping(source = "bankAccoountType", target = "bankAccoountType"),
            @Mapping(source = "entranceDate", target = "entranceDate"),
            @Mapping(source = "contractTypeDto", target = "contractType"),
            @Mapping(source = "contractTypeId", target = "contractType.id"),
            @Mapping(source = "university", target = "university"),
            @Mapping(source = "insuranceKindDto", target = "insuranceKind"),
            @Mapping(source = "insuranceKindId", target = "insuranceKind.id"),
            @Mapping(source = "insuranceBoxDto", target = "insuranceBox"),
            @Mapping(source = "insuranceBoxId", target = "insuranceBox.id"),
            @Mapping(source = "gender1", target = "gender1"),
            @Mapping(source = "marital1", target = "marital1"),
            @Mapping(source = "military1", target = "military1"),
            @Mapping(source = "editTempRowFlag", target = "editTempRowFlag"),
            @Mapping(source = "createTempRowFlag", target = "createTempRowFlag"),
            @Mapping(source = "verified", target = "verified"),
            @Mapping(source = "postalCode", target = "postalCode"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "userEditorDto", target = "userEditor"),
            @Mapping(source = "convertDateWho", target = "convertDateWho"),
            @Mapping(source = "convertUniq", target = "convertUniq"),
            @Mapping(source = "lfatherName", target = "lfatherName"),
            @Mapping(source = "lfromCity", target = "lfromCity"),
            @Mapping(source = "lfromCityEntityDto", target = "lfromCityEntity"),
            @Mapping(source = "lfromCityEntityId", target = "lfromCityEntity.id")
    })
    ContactEntity toContactEntity(ContactDto contactDto , @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    ContactDto toContactDto(ContactEntity contactEntity, @Context CycleAvoidingMappingContext context);

    List<ContactEntity> toContactEntities(List<ContactDto> ContactDtos, @Context CycleAvoidingMappingContext context);

    List<ContactDto> toContactDtos(List<ContactEntity> contactEntities, @Context CycleAvoidingMappingContext context);
}
