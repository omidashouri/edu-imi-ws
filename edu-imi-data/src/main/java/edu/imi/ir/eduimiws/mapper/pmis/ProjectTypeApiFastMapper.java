package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectTypeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectTypeEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectTypeApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectTypeDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectTypeApiFastMapper {

    ProjectTypeApiFastMapper INSTANCE = Mappers.getMapper(ProjectTypeApiFastMapper.class);

    @Mappings({
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deletedProjectTypeId", target = "deletedProjectTypeId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectTypePublicId", target = "projectTypePublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectTypeApiDto toProjectTypeApiDto(ProjectTypeApiEntity projectTypeApiEntity, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProjectTypeApiEntity toProjectTypeApiEntity(ProjectTypeApiDto projectTypeApiDto, @Context CycleAvoidingMappingContext context);

    List<ProjectTypeApiEntity> toProjectTypeApiEntities(List<ProjectTypeApiDto> ProjectTypeApiDtos, @Context CycleAvoidingMappingContext context);

    List<ProjectTypeApiDto> toProjectTypeApiDtos(List<ProjectTypeApiEntity> projectTypeApiEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleProjectTypeApiPublicIds(ProjectTypeApiEntity projectTypeApiEntity, @MappingTarget ProjectTypeApiDto projectTypeApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(projectTypeApiEntity);
    }
}
