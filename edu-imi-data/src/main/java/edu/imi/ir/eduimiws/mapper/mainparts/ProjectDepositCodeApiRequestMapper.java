package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ProjectService.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiRequestMapper {

    @Named("toProjectDepositCodeApiDto")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "projectPublicId", target = "projectDto",
                    qualifiedBy = {MappingUtil.ProjectService.class,
                            MappingUtil.ProjectPublicIdToProjectDto.class}),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description")

    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDepositCodeApiDto toProjectDepositCodeApiDto(ProjectDepositCodeApiRequest source);

    @IterableMapping(qualifiedByName = "toProjectDepositCodeApiDto")
    List<ProjectDepositCodeApiDto> toProjectDepositCodeApiDtos(List<ProjectDepositCodeApiRequest> sources);

    @Mappings({
            @Mapping(source = "projectPublicId", target = "projectDto",
                    qualifiedBy = {MappingUtil.ProjectService.class,
                            MappingUtil.ProjectPublicIdToProjectDto.class}),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectDepositCodeApiDto(ProjectDepositCodeApiRequest source,
                                        @MappingTarget ProjectDepositCodeApiDto target);

}
