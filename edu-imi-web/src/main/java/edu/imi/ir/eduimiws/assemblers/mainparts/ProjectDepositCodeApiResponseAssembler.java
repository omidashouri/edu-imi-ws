package edu.imi.ir.eduimiws.assemblers.mainparts;

import edu.imi.ir.eduimiws.controllers.mainparts.v1.ProjectDepositCodeApiController;
import edu.imi.ir.eduimiws.controllers.mainparts.v1.VoucherListItemsController;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiResponseMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProjectDepositCodeApiResponseAssembler extends RepresentationModelAssemblerSupport<ProjectDepositCodeApiDto, ProjectDepositCodeApiResponse> {

    private final ProjectDepositCodeApiResponseMapper projectDepositCodeApiResponseMapper;


    public ProjectDepositCodeApiResponseAssembler(ProjectDepositCodeApiResponseMapper projectDepositCodeApiResponseMapper) {
        super(VoucherListItemsController.class, ProjectDepositCodeApiResponse.class);
        this.projectDepositCodeApiResponseMapper = projectDepositCodeApiResponseMapper;
    }

    @Override
    public ProjectDepositCodeApiResponse toModel(ProjectDepositCodeApiDto projectDepositCodeApiDto) {

        ProjectDepositCodeApiResponse projectDepositCodeApiResponse = projectDepositCodeApiResponseMapper
                .toProjectDepositCodeApiResponse(projectDepositCodeApiDto);

        if (projectDepositCodeApiDto.getPublicId() != null) {
            projectDepositCodeApiResponse
                    .add(linkTo(
                            methodOn(
                                    ProjectDepositCodeApiController.class)
                                    .getByPublicId(projectDepositCodeApiDto.getPublicId()))
                            .withSelfRel());
        }

        return projectDepositCodeApiResponse;
    }


    @Override
    public CollectionModel<ProjectDepositCodeApiResponse> toCollectionModel(Iterable<? extends ProjectDepositCodeApiDto> projectDepositCodeApiDtos) {

        CollectionModel<ProjectDepositCodeApiResponse> projectDepositCodeApiResponseCollectionModel = super.toCollectionModel(projectDepositCodeApiDtos);

        Pageable pageable = Pageable.unpaged();
//todo: remove comment when find all is created
/*        projectDepositCodeApiResponseCollectionModel
                .add(linkTo(methodOn(ProjectDepositCodeApiController.class)
                        .getProjectDepositCodeApis(pageable)).withRel("projectDepositCodeApis"));*/

        return projectDepositCodeApiResponseCollectionModel;
    }

}