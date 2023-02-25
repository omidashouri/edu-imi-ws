package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiResponseMapper {

    @Named("toProjectDepositCodeApiResponse")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "projectDto.projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectDto.projectCode", target = "projectCode"),
            @Mapping(source = "projectDto.projectName", target = "projectName")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDepositCodeApiResponse toProjectDepositCodeApiResponse(ProjectDepositCodeApiDto source);

    @IterableMapping(qualifiedByName = "toProjectDepositCodeApiResponse")
    List<ProjectDepositCodeApiResponse> toProjectDepositCodeApiResponses(List<ProjectDepositCodeApiDto> sources);


}
