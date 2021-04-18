package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectTypeEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectTypeDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectTypeFastMapper {

    ProjectTypeFastMapper INSTANCE = Mappers.getMapper(ProjectTypeFastMapper.class);

    @Mappings({
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creatorId", target = "creatorId"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editorId", target = "editorId"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectTypeApi.projectTypePublicId", target = "projectTypePublicId"),
            @Mapping(source = "projectTypeName", target = "projectTypeName")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectTypeDto toProjectTypeDto(ProjectTypeEntity projectTypeEntity, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProjectTypeEntity toProjectTypeEntity(ProjectTypeDto projectTypeDto, @Context CycleAvoidingMappingContext context);

    List<ProjectTypeEntity> toProjectTypeEntities(List<ProjectTypeDto> ProjectTypeDtos, @Context CycleAvoidingMappingContext context);

    List<ProjectTypeDto> toProjectTypeDtos(List<ProjectTypeEntity> projectTypeEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleProjectTypePublicIds(ProjectTypeEntity projectTypeEntity, @MappingTarget ProjectTypeDto projectTypeDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(projectTypeEntity);
    }
}
