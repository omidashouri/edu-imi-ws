package edu.imi.ir.eduimiws.assemblers.pmis;

import edu.imi.ir.eduimiws.controllers.crm.v1.UserController;
import edu.imi.ir.eduimiws.controllers.pmis.v1.ProjectController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectResponseProjectDtoMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class ProjectResponseAssembler extends RepresentationModelAssemblerSupport<ProjectDto, ProjectResponse> {

    private final ProjectResponseProjectDtoMapper projectResponseProjectDtoMapper;

    public ProjectResponseAssembler(ProjectResponseProjectDtoMapper projectResponseProjectDtoMapper) {
        super(ProjectController.class, ProjectResponse.class);
        this.projectResponseProjectDtoMapper = projectResponseProjectDtoMapper;
    }

    @Override
    public ProjectResponse toModel(ProjectDto projectDto) {

        ProjectResponse projectResponse = projectResponseProjectDtoMapper
                .toProjectResponse(projectDto, new CycleAvoidingMappingContext());

        if (projectDto.getProjectPublicId() != null) {
            projectResponse
                    .add(linkTo(
                            methodOn(
                                    ProjectController.class)
                                    .getProjectByProjectPublicId(projectDto.getProjectPublicId()))
                            .withSelfRel());
        }

        if (projectDto.getExecuterPublicId() != null) {
            projectResponse
                    .add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(projectDto.getExecuterPublicId()))
                            .withRel("Executor"));
        }

        if (projectDto.getManagerPublicId() != null) {
            projectResponse
                    .add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(projectDto.getManagerPublicId()))
                            .withRel("Manager"));
        }

/*        if(projectDto.getNationCode() != null){
            projectResponse
                    .add(linkTo(
                            methodOn(ProjectController.class)
                                    .getProjectByNationalCode(projectDto.getNationCode()))
                            .withRel("nationalCode"));
        }*/

        return projectResponse;
    }

    @Override
    public CollectionModel<ProjectResponse> toCollectionModel(Iterable<? extends ProjectDto> projectDtos) {
        CollectionModel<ProjectResponse> projectResponseCollectionModel = super.toCollectionModel(projectDtos);

        Pageable defaultPageable = PageRequest
                .of(0, 10, Sort.Direction.fromString("DESC"), "createDate");

        projectResponseCollectionModel
                .add(linkTo(methodOn(ProjectController.class).getProjects(defaultPageable)).withRel("projects"));

        return projectResponseCollectionModel;
    }
}
