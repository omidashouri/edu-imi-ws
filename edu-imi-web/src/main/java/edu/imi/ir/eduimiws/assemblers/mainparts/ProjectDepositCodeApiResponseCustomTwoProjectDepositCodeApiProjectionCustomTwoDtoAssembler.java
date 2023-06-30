package edu.imi.ir.eduimiws.assemblers.mainparts;

import edu.imi.ir.eduimiws.controllers.mainparts.v1.ProjectDepositCodeApiController;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponseCustomTwo;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoAssembler extends
        RepresentationModelAssemblerSupport<ProjectDepositCodeApiProjectionCustomTwoDto, ProjectDepositCodeApiResponseCustomTwo> {

    //    -->
    private final ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper;

//    ProjectDepositCodeApiProjectionCustomTwoDto
//    ProjectDepositCodeApiResponseCustomTwo
//   (MAPPER)  ProjectDepositCodeApiProjectionCustomTwoDto -> ProjectDepositCodeApiResponseCustomTWO

    public ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoAssembler(
            ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper) {
        super(ProjectDepositCodeApiController.class, ProjectDepositCodeApiResponseCustomTwo.class);
//        -->
        this.projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper =
                projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper;
    }

    @Override
    public ProjectDepositCodeApiResponseCustomTwo toModel(ProjectDepositCodeApiProjectionCustomTwoDto projectDepositCodeApiProjectionCustomTwoDto) {


        ProjectDepositCodeApiResponseCustomTwo projectDepositCodeApiResponseCustomTwo = projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoMapper
                .projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto(projectDepositCodeApiProjectionCustomTwoDto);


/*        periodResponseCustomTwo
                .add(linkTo(
                        methodOn(
                                PeriodController.class)
                                .getPeriodByPeriodPublicId(periodProjectionCustomTwoDto.getPeriodPublicId()))
                        .withSelfRel());*/

/*        if (periodProjectionCustomTwoDto.getFieldPublicId() != null) {
            periodResponseCustomTwo.
                    add(linkTo(
                            methodOn(
                                    FieldController.class)
                                    .getFieldByFieldPublicId(periodProjectionCustomTwoDto.getFieldPublicId()))
                            .withRel("fields"));
        }

        if (periodProjectionCustomTwoDto.getEduCategoryPublicId() != null) {
            periodResponseCustomTwo.
                    add(linkTo(
                            methodOn(
                                    EduCategoryController.class)
                                    .getEduCategoryByEduCategoryPublicId(periodProjectionCustomTwoDto.getEduCategoryPublicId()))
                            .withRel("eduCategories"));
        }

        if (periodProjectionCustomTwoDto.getLevelPublicId() != null) {
            periodResponseCustomTwo.
                    add(linkTo(methodOn(
                            LevelController.class)
                            .getLevelByLevelPublicId(periodProjectionCustomTwoDto.getLevelPublicId()))
                            .withRel("levels"));
        }


        return periodResponseCustomTwo;*/
        return projectDepositCodeApiResponseCustomTwo;
    }


    @Override
    public CollectionModel<ProjectDepositCodeApiResponseCustomTwo> toCollectionModel(Iterable<? extends ProjectDepositCodeApiProjectionCustomTwoDto> projectDepositCodeApiProjectionCustomTwoDtos) {

        CollectionModel<ProjectDepositCodeApiResponseCustomTwo> projectDepositCodeApiResponseCustomTwos = super.toCollectionModel(projectDepositCodeApiProjectionCustomTwoDtos);

        Pageable pageable = Pageable.unpaged();

        projectDepositCodeApiResponseCustomTwos
                .add(linkTo(
                        methodOn(ProjectDepositCodeApiController.class).getProjectDepositCodes(pageable))
                        .withRel("all"));

        return projectDepositCodeApiResponseCustomTwos;
    }
}