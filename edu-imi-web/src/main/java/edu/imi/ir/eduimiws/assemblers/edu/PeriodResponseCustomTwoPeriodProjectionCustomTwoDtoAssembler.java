package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.EduCategoryController;
import edu.imi.ir.eduimiws.controllers.edu.v1.FieldController;
import edu.imi.ir.eduimiws.controllers.edu.v1.LevelController;
import edu.imi.ir.eduimiws.controllers.edu.v1.PeriodController;
import edu.imi.ir.eduimiws.mapper.edu.PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseCustomTwo;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler extends
        RepresentationModelAssemblerSupport<PeriodProjectionCustomTwoDto, PeriodResponseCustomTwo> {

    private final PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper periodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper;


    public PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler(PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper periodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper) {
        super(PeriodController.class, PeriodResponseCustomTwo.class);
        this.periodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper = periodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper;
    }

    @Override
    public PeriodResponseCustomTwo toModel(PeriodProjectionCustomTwoDto periodProjectionCustomTwoDto) {

        PeriodResponseCustomTwo periodResponseCustomTwo = periodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper
                .periodProjectionCustomTwoToPeriodResponseCustomTwoDto(periodProjectionCustomTwoDto);

/*        periodResponseCustomTwo
                .add(linkTo(
                        methodOn(
                                PeriodController.class)
                                .getPeriodByPeriodPublicId(periodProjectionCustomTwoDto.getPeriodPublicId()))
                        .withSelfRel());*/

        if (periodProjectionCustomTwoDto.getFieldPublicId() != null) {
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


        return periodResponseCustomTwo;
    }


    @Override
    public CollectionModel<PeriodResponseCustomTwo> toCollectionModel(Iterable<? extends PeriodProjectionCustomTwoDto> periodFastDtos) {

        CollectionModel<PeriodResponseCustomTwo> periodResponseCollectionModel = super.toCollectionModel(periodFastDtos);

        Pageable pageable = Pageable.unpaged();

        periodResponseCollectionModel
                .add(linkTo(
                        methodOn(PeriodController.class).getPeriods(pageable))
                        .withRel("periodResponseCustomTwo"));

        return periodResponseCollectionModel;
    }
}
