package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyApiDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CompanyMapper.class},
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CompanyApiMapper {

    CompanyApiMapper INSTANCE = Mappers.getMapper(CompanyApiMapper.class);


    @Mappings({
            @Mapping(source = "company", target = "company"),
            @Mapping(source = "company.id", target = "companyId"),
            @Mapping(source = "companyPublicId", target = "companyPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "deletedCompanyId", target = "deletedCompanyId"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "id", target = "id")
    })
    @BeanMapping(ignoreByDefault = true)
    CompanyApiDto toCompanyApiDto(CompanyApiEntity companyApiEntity
            , @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    CompanyApiEntity toCompanyApiEntity(CompanyApiDto companyApiDto
            , @Context CycleAvoidingMappingContext context);

    List<CompanyApiEntity> toCompanyApiEntities(List<CompanyApiDto> companyApiDtos,
                                                @Context CycleAvoidingMappingContext context);

    List<CompanyApiDto> toCompanyApiDtos(List<CompanyApiEntity> companyApiEntities,
                                         @Context CycleAvoidingMappingContext context);
}
