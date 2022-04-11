package edu.imi.ir.eduimiws.assemblers.pmis;

import edu.imi.ir.eduimiws.controllers.pmis.v1.ProjectController;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectResponseForPaymentCodeProjectDtoMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponseForPaymentCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProjectResponseForPaymentCodeProjectDtoAssembler extends RepresentationModelAssemblerSupport<ProjectDto, ProjectResponseForPaymentCode> {

    private final ProjectResponseForPaymentCodeProjectDtoMapper projectResponseForPaymentCodeProjectDtoMapper;

    public ProjectResponseForPaymentCodeProjectDtoAssembler(ProjectResponseForPaymentCodeProjectDtoMapper projectResponseForPaymentCodeProjectDtoMapper) {
        super(ProjectController.class, ProjectResponseForPaymentCode.class);
        this.projectResponseForPaymentCodeProjectDtoMapper = projectResponseForPaymentCodeProjectDtoMapper;
    }

    @Override
    public ProjectResponseForPaymentCode toModel(ProjectDto projectDto) {

        ProjectResponseForPaymentCode projectResponseForPaymentCode = projectResponseForPaymentCodeProjectDtoMapper
                .projectDtoToProjectResponseForPaymentCode(projectDto);

        Map<String, String> queryParams = new HashMap<>();

        if (projectDto.getProjectPublicId() != null) {
            projectResponseForPaymentCode
                    .add(linkTo(
                            methodOn(
                                    ProjectController.class)
                                    .getProjectByProjectPublicIdForPaymentCode(projectDto.getProjectPublicId()))
                            .withRel("/publicId/"+projectDto.getProjectPublicId()+"/forPaymentCode"));
        }

/*        if(projectDto.getProjectCode() != null){
            projectResponseForPaymentCode
                    .add(linkTo(
                            methodOn(ProjectController.class)
                                    .getProjectResponseForPaymentCodeWithParameter(queryParams))
                            .withSelfRel());
        }*/

        return projectResponseForPaymentCode;
    }

    @Override
    public CollectionModel<ProjectResponseForPaymentCode> toCollectionModel(Iterable<? extends ProjectDto> projectDtos) {
        CollectionModel<ProjectResponseForPaymentCode> projectResponseCollectionModel = super.toCollectionModel(projectDtos);

        Pageable defaultPageable = PageRequest
                .of(0, 10, Sort.Direction.fromString("DESC"), "projectName");

        projectResponseCollectionModel
                .add(linkTo(methodOn(ProjectController.class).getProjectsForPaymentCode(defaultPageable)).withRel("forPaymentCodes"));

        return projectResponseCollectionModel;
    }
}
