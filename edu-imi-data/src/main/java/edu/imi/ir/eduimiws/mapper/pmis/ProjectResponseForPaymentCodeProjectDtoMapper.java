package edu.imi.ir.eduimiws.mapper.pmis;


import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponseForPaymentCode;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectResponseForPaymentCodeProjectDtoMapper {

    @Named("projectDtoToProjectResponseForPaymentCode")
    @Mappings({
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectName", target = "projectName")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectResponseForPaymentCode projectDtoToProjectResponseForPaymentCode(ProjectDto source);

    @IterableMapping(qualifiedByName = "projectDtoToProjectResponseForPaymentCode")
    List<ProjectResponseForPaymentCode> projectResponseForPaymentCodeToProjectDtos(List<ProjectDto> sources);
}
