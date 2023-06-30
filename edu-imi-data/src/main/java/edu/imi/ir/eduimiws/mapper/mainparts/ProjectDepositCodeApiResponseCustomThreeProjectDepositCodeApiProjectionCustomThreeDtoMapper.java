package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomThreeDto;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponseCustomThree;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {String.class, Long.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper {

    @Named("ProjectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto")
    @Mappings({
            @Mapping(source = "publicI", target = "publicId"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectCreateDate", target = "projectCreateDate"),
            @Mapping(source = "projectStatusId", target = "projectStatusId"),
            @Mapping(source = "projectTypeName", target = "projectTypeName"),
            @Mapping(source = "startDatePlan", target = "startDatePlan"),
            @Mapping(source = "endDatePlan", target = "endDatePlan"),
            @Mapping(source = "lastVersion", target = "lastVersion"),
            @Mapping(source = "statusForTimeshit", target = "statusForTimeshit"),
            @Mapping(source = "creatorFullName", target = "creatorFullName"),
            @Mapping(source = "editorFullName", target = "editorFullName"),
            @Mapping(source = "executor", target = "executor"),
            @Mapping(source = "projectPublicId", target = "projectPublicId")
    })
    ProjectDepositCodeApiResponseCustomThree projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto(
            ProjectDepositCodeApiProjectionCustomThreeDto source);

    @IterableMapping(qualifiedByName = "ProjectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto")
    List<ProjectDepositCodeApiResponseCustomThree> projectDepositCodeApiEntitiesToProjectDepositCodeApiResponseCustomThreeDtos(
            List<ProjectDepositCodeApiProjectionCustomThreeDto> sources);
}

