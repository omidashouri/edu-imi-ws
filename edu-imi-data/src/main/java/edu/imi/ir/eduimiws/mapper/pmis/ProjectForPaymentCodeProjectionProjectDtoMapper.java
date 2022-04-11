package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.projections.pmis.ProjectForPaymentCodeProjection;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectForPaymentCodeProjectionProjectDtoMapper {

    @Named("projectForPaymentCodeProjectionToProjectFastDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "lastVersion", target = "lastVersion")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDto projectForPaymentCodeProjectionToProjectDto(ProjectForPaymentCodeProjection projectForPaymentCodeProjection);

    @IterableMapping(qualifiedByName = "projectForPaymentCodeProjectionToProjectFastDto")
    List<ProjectDto> projectForPaymentCodeProjectionToProjectDtos(List<ProjectForPaymentCodeProjection> projectForPaymentCodeProjections);
}
