package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomTwo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {java.lang.StringBuilder.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiProjectionCustomTwoMapper {

    @Named("projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "creatorFullName", target = "creatorFullName"),
            @Mapping(source = "editorFullName", target = "editorFullName")
    })
    ProjectDepositCodeApiProjectionCustomTwoDto projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto(
            ProjectDepositCodeApiProjectionCustomTwo source);

    @IterableMapping(qualifiedByName = "projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto")
    List<ProjectDepositCodeApiProjectionCustomTwoDto> projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDtos
            (List<ProjectDepositCodeApiProjectionCustomTwo> sources);
}
