package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponseCustomTwo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {String.class, Long.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper {

    @Named("ProjectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto")
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
    ProjectDepositCodeApiResponseCustomTwo projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto(
                                                                              ProjectDepositCodeApiProjectionCustomTwoDto source);

    @IterableMapping(qualifiedByName = "ProjectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto")
    List<ProjectDepositCodeApiResponseCustomTwo> projectDepositCodeApiEntitiesToProjectDepositCodeApiResponseCustomTwoDtos(
            List<ProjectDepositCodeApiProjectionCustomTwoDto> sources);

}
