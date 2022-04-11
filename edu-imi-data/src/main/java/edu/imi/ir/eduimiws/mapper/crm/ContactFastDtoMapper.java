package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {AccountMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactFastDtoMapper {

/*
    accountPublicId, salutationPublicId, currencyPublicId, managerPublicId, assistantPublicId, parentPublicId
    countryPublicId, statePublicId, cityPublicId, companyPublicId, organizationPublicId, leadSourcePublicId
    campaignPublicId, teamPublicId, addressTypePublicId, userCreatorPublicId, birthCityPublicId,
    religionPublicId, militaryServicePublicId, eduLevelPublicId, contractTypePublicId, insuranceKindPublicId,
    insuranceBoxPublicId, userEditorPublicId, lfromCityEntityPublicId

*/

    @Named("toContactFastDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "contactWebService.contactPublicId", target = "contactPublicId"),
            @Mapping(source = "contactWebService.account.id", target = "accountId"),
            @Mapping(source = "contactWebService.accountPublicId", target = "accountPublicId"),
            @Mapping(source = "contactWebService.company.id", target = "companyId"),
            @Mapping(source = "contactWebService.companyPublicId", target = "companyPublicId"),
            @Mapping(source = "contactWebService.organization.id", target = "organizationId"),
            @Mapping(source = "contactWebService.organizationPublicId", target = "organizationPublicId"),
            @Mapping(source = "contactWebService.country.id", target = "countryId"),
            @Mapping(source = "contactWebService.countryPublicId", target = "countryPublicId"),
            @Mapping(source = "contactWebService.state.id", target = "stateId"),
            @Mapping(source = "contactWebService.statePublicId", target = "statePublicId"),
            @Mapping(source = "contactWebService.city.id", target = "cityId"),
            @Mapping(source = "contactWebService.cityPublicId", target = "cityPublicId"),
            @Mapping(source = "contactWebService.birthCity.id", target = "birthCityId"),
            @Mapping(source = "contactWebService.birthCityPublicId", target = "birthCityPublicId"),
            @Mapping(source = "contactWebService.religion.id", target = "religionId"),
            @Mapping(source = "contactWebService.religionPublicId", target = "religionPublicId"),
            @Mapping(source = "contactWebService.militaryService.id", target = "militaryServiceId"),
            @Mapping(source = "contactWebService.militaryServicePublicId", target = "militaryServicePublicId"),
            @Mapping(source = "contactWebService.eduLevel.id", target = "eduLevelId"),
            @Mapping(source = "contactWebService.eduLevelPublicId", target = "eduLevelPublicId"),
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
    @BeanMapping(ignoreByDefault = true)
    ContactFastDto toContactFastDto(ContactEntity contactEntity, @Context CycleAvoidingMappingContext context);

    @Named("toContactEntity")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "account", target = "account")
    })
    ContactEntity toContactEntity(ContactFastDto contactFastDto, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toContactEntity")
    List<ContactEntity> toContactEntities(List<ContactFastDto> ContactFastDtos, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toContactFastDto")
    List<ContactFastDto> toContactFastDtos(List<ContactEntity> contactEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handlePersonPublicIds(ContactEntity contactEntity, @MappingTarget ContactFastDto contactFastDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(contactEntity);
    }

    @Mappings({
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "birthdate", target = "birthdate")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactByContactFactDtoForPaymentCode(ContactFastDto contactFastDto,
                                                     @MappingTarget ContactEntity contact);


    @Mappings({
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "birthdate", target = "birthdate")
    })
    @BeanMapping(ignoreByDefault = true)
     ContactEntity updateContactByContactFactDtoForPaymentCode(ContactFastDto contactFastDto);

}
