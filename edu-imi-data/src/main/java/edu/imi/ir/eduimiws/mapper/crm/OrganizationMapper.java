package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.OrganizationDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {AccountMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrganizationMapper {


    @Named("toOrganizationDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "account.id", target = "accountId"),
            @Mapping(source = "organizationApi.accountPublicId", target = "accountPublicId"),
            @Mapping(source = "billAddress", target = "billAddress"),
            @Mapping(source = "billCity.id", target = "billCityId"),
//          later add public id it in API
            @Mapping(source = "billCity.parameterApi.parameterPublicId", target = "billCityPublicId"),
            @Mapping(source = "billCountry.id", target = "billCountryId"),
//          later add public id it in API
            @Mapping(source = "billCountry.parameterApi.parameterPublicId", target = "billCountryPublicId"),
            @Mapping(source = "billState.id", target = "billStateId"),
//          later add public id it in API
            @Mapping(source = "billState.parameterApi.parameterPublicId", target = "billStatePublicId"),
            @Mapping(source = "nameLo", target = "nameLo"),
            @Mapping(source = "billZipcode", target = "billZipcode"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "fax", target = "fax"),
            @Mapping(source = "isActive", target = "isActive"),
            @Mapping(source = "mainPhone", target = "mainPhone"),
            @Mapping(source = "otherPhone", target = "otherPhone"),
            @Mapping(source = "shipAddress", target = "shipAddress"),
            @Mapping(source = "parent.id", target = "parentId"),
//          later add public id it in API
            @Mapping(source = "parent.organizationApi.organizationPublicId", target = "parentPublicId"),
            @Mapping(source = "shipCountry.id", target = "shipCountryId"),
//          later add public id it in API
            @Mapping(source = "shipCountry.parameterApi.parameterPublicId", target = "shipCountryPublicId"),
            @Mapping(source = "shipCity.id", target = "shipCityId"),
//          later add public id it in API
            @Mapping(source = "shipCity.parameterApi.id", target = "shipCityPublicId"),
            @Mapping(source = "shipState.id", target = "shipStateId"),
//          later add public id it in API
            @Mapping(source = "shipState.parameterApi.parameterPublicId", target = "shipStatePublicId"),
            @Mapping(source = "shipZipcode", target = "shipZipcode"),
            @Mapping(source = "website", target = "website")
    })
    @BeanMapping(ignoreByDefault = true)
    OrganizationDto toOrganizationDto(OrganizationEntity organizationEntity
            , @Context CycleAvoidingMappingContext context);


    @Named("toOrganization")
    @InheritInverseConfiguration
    OrganizationEntity toOrganization(OrganizationDto organizationDto, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toOrganizationDto")
    List<OrganizationDto> toOrganizationDtos(List<OrganizationEntity> organizationEntities, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toOrganization")
    List<OrganizationEntity> toOrganizationEntities(List<OrganizationDto> organizationDtos, @Context CycleAvoidingMappingContext context);



    @BeforeMapping
    default void handleLazyInitialization(OrganizationEntity organization, @MappingTarget OrganizationDto organizationDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(organization);
    }

}
