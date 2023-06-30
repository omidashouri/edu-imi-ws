package edu.imi.ir.eduimiws.assemblers.mainparts;


import edu.imi.ir.eduimiws.controllers.mainparts.v1.ProjectDepositCodeApiController;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomThreeDto;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponseCustomThree;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler extends
        RepresentationModelAssemblerSupport<ProjectDepositCodeApiProjectionCustomThreeDto, ProjectDepositCodeApiResponseCustomThree> {

    private final ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper;

    public ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler(
            ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper) {
        super(ProjectDepositCodeApiController.class, ProjectDepositCodeApiResponseCustomThree.class);

        this.projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper =
                projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper;
    }


    public ProjectDepositCodeApiResponseCustomThree toModel(ProjectDepositCodeApiProjectionCustomThreeDto projectDepositCodeApiProjectionCustomThreeDto) {

        ProjectDepositCodeApiResponseCustomThree projectDepositCodeApiResponseCustomThree = projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoMapper
                .projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto(projectDepositCodeApiProjectionCustomThreeDto);

        return projectDepositCodeApiResponseCustomThree;
    }

    @Override
    public CollectionModel<ProjectDepositCodeApiResponseCustomThree> toCollectionModel(Iterable<? extends ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtos) {

        CollectionModel<ProjectDepositCodeApiResponseCustomThree> projectDepositCodeApiResponseCustomThrees = super.toCollectionModel(projectDepositCodeApiProjectionCustomThreeDtos);

        Pageable pageable = Pageable.unpaged();

        projectDepositCodeApiResponseCustomThrees
                .add(linkTo(
                        methodOn(ProjectDepositCodeApiController.class).getProjectDepositCodes(pageable))
                        .withRel("all"));

        return projectDepositCodeApiResponseCustomThrees;
    }
}


