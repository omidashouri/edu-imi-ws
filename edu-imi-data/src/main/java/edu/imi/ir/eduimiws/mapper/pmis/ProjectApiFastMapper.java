package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectApiFastMapper {
    ProjectApiFastMapper INSTANCE = Mappers.getMapper(ProjectApiFastMapper.class);

    @Mappings({
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "deletedProjectId", target = "deletedProjectId"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "executorPublicId", target = "executorPublicId"),
            @Mapping(source = "lastVersion", target = "lastVersion"),
            @Mapping(source = "managerPublicId", target = "managerPublicId"),
            @Mapping(source = "projectTypePublicId", target = "projectTypePublicId"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectRequestId", target = "projectRequestId"),
            @Mapping(source = "projectRequestPublicId", target = "projectRequestPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectApiDto toProjectApiDto(ProjectApiEntity projectApiEntity, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProjectApiEntity toProjectApiEntity(ProjectApiDto projectApiDto, @Context CycleAvoidingMappingContext context);

    List<ProjectApiEntity> toProjectApiEntities(List<ProjectApiDto> ProjectApiDtos, @Context CycleAvoidingMappingContext context);

    List<ProjectApiDto> toProjectApiDtos(List<ProjectApiEntity> projectApiEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleProjectApiPublicIds(ProjectApiEntity projectApiEntity, @MappingTarget ProjectApiDto projectApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(projectApiEntity);
    }
}
