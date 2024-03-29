package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ContactMapper.class, PersonMapper.class, CompanyMapper.class,
                AccountMapper.class, OrganizationMapper.class, ParameterMapper.class,},
        imports = {PublicIdUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactApiMapper {

    @Named("contactApiEntityToContactApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "contact", target = "contactDto", qualifiedByName = "toContactDto"),
            @Mapping(source = "contact.id", target = "contactId"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "creator.personApiEntity.personPublicId", target = "creatorPublicId"),
            @Mapping(source = "creator", target = "creatorDto", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "editor.personApiEntity.personPublicId", target = "editorPublicId"),
            @Mapping(source = "editor", target = "editorDto", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "contactEditDate", target = "contactEditDate"),
            @Mapping(source = "company.id", target = "companyId"),
            @Mapping(source = "companyPublicId", target = "companyPublicId"),
            @Mapping(source = "company", target = "companyDto",qualifiedByName = "toCompanyDto"),
            @Mapping(source = "account.id", target = "accountId"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "account", target = "accountDto", qualifiedByName = "toAccountDto"),
            @Mapping(source = "organization.id", target = "organizationId"),
            @Mapping(source = "organizationPublicId", target = "organizationPublicId"),
            @Mapping(source = "organization", target = "organizationDto", qualifiedByName = "toOrganizationDto"),
            @Mapping(source = "country.id", target = "countryId"),
            @Mapping(source = "countryPublicId", target = "countryPublicId"),
            @Mapping(source = "country", target = "countryDto", qualifiedByName = "parameterEntityToParameterDto"),
            @Mapping(source = "state.id", target = "stateId"),
            @Mapping(source = "statePublicId", target = "statePublicId"),
            @Mapping(source = "state", target = "stateDto", qualifiedByName = "parameterEntityToParameterDto"),
            @Mapping(source = "city.id", target = "cityId"),
            @Mapping(source = "cityPublicId", target = "cityPublicId"),
            @Mapping(source = "city", target = "cityDto", qualifiedByName = "parameterEntityToParameterDto"),
            @Mapping(source = "birthCity.id", target = "birthCityId"),
            @Mapping(source = "birthCityPublicId", target = "birthCityPublicId"),
            @Mapping(source = "birthCity", target = "birthCityDto"),
            @Mapping(source = "religion.id", target = "religionId"),
            @Mapping(source = "religionPublicId", target = "religionPublicId"),
            @Mapping(source = "religion", target = "religionDto", qualifiedByName = "parameterEntityToParameterDto"),
            @Mapping(source = "eduLevel.id", target = "eduLevelId"),
            @Mapping(source = "eduLevelPublicId", target = "eduLevelPublicId"),
            @Mapping(source = "eduLevel", target = "eduLevelDto", qualifiedByName = "parameterEntityToParameterDto"),
            @Mapping(source = "militaryService.id", target = "militaryServiceId"),
            @Mapping(source = "militaryServicePublicId", target = "militaryServicePublicId"),
            @Mapping(source = "militaryService", target = "militaryServiceDto", qualifiedByName = "parameterEntityToParameterDto")
    })
    @BeanMapping(ignoreByDefault = true)
    ContactApiDto contactApiEntityToContactApiDto(ContactApiEntity contactApiEntity,
                                                  @Context CycleAvoidingMappingContext context);
//    ContactApiEntity is Generated By Trigger

    @IterableMapping(qualifiedByName = "contactApiEntityToContactApiDto")
    List<ContactApiDto> contactApiEntitiesToContactApiDtos(List<ContactApiEntity> contactApiEntities,
                                                           @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "contactApiEntityToContactApiDto")
    default void handleContactApiPublicIds(ContactApiEntity contactApiEntity,
                                           @MappingTarget ContactApiDto contactApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(contactApiEntity);
    }

}
