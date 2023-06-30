package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomThreeDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomThree;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring",
        imports = {java.lang.StringBuilder.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiProjectionCustomThreeMapper {

    @Named("projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto")
    @Mappings({
            @Mapping(source = "publicId", target = "publicI"),
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
    ProjectDepositCodeApiProjectionCustomThreeDto projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto(
            ProjectDepositCodeApiProjectionCustomThree source);

    @IterableMapping(qualifiedByName = "projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto")
    List<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDtos
            (List<ProjectDepositCodeApiProjectionCustomThree> sources);

}
