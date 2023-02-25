package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjection;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface ProjectDepositCodeApiProjectionMapper {

    @Named("toProjectDepositCodeApiProjectionDto")
    @Mappings({
            @Mapping(source = "projectPublicId", target = "projectId"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectLastVersion", target = "projectLastVersion")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDepositCodeApiDto toProjectDepositCodeApiProjectionDto(ProjectDepositCodeApiProjection source,
                                                                  @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toProjectDepositCodeApiProjectionDto")
    List<ProjectDepositCodeApiDto> toProjectDepositCodeApiProjectionDtos(List<ProjectDepositCodeApiProjection> sources,
                                                                         @Context CycleAvoidingMappingContext context);

}
