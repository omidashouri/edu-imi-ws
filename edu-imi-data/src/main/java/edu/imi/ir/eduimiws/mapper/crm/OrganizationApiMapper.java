package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.OrganizationApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.AccountApiDto;
import edu.imi.ir.eduimiws.models.dto.crm.OrganizationApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {AccountMapper.class, OrganizationMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrganizationApiMapper {

    OrganizationApiMapper INSTANCE = Mappers.getMapper(OrganizationApiMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "account", target = "account"),
            @Mapping(source = "account.id", target = "accountId"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "deletedOrganizationId", target = "deletedOrganizationId"),
            @Mapping(source = "deletedDateTs", target = "deletedDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "organizationPublicId", target = "organizationPublicId"),
            @Mapping(source = "organization", target = "organization"),
            @Mapping(source = "organization.id", target = "organizationId")
    })
    @BeanMapping(ignoreByDefault = true)
    OrganizationApiDto toOrganizationApiDto(OrganizationApiEntity organizationApiEntity
            , @Context CycleAvoidingMappingContext context);


    @InheritInverseConfiguration
    OrganizationApiEntity toOrganizationApi(OrganizationApiDto organizationApiDto, @Context CycleAvoidingMappingContext context);

    List<OrganizationApiEntity> toOrganizationApiEntities(List<OrganizationApiDto> organizationApiDtos, @Context CycleAvoidingMappingContext context);

    List<OrganizationApiDto> toOrganizationApiDtos(List<OrganizationApiEntity> organizationApiEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleLazyInitialization(OrganizationApiEntity organizationApi, @MappingTarget OrganizationApiDto organizationApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(organizationApi);
    }

}
