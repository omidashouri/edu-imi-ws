package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodResponsePeriodFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PeriodResponsePeriodFastDtoAssembler extends RepresentationModelAssemblerSupport<PeriodFastDto, PeriodResponse> {

    private final PeriodResponsePeriodFastDtoMapper periodResponsePeriodFastDtoMapper;


    public PeriodResponsePeriodFastDtoAssembler(PeriodResponsePeriodFastDtoMapper periodResponsePeriodFastDtoMapper) {
        super(PeriodController.class, PeriodResponse.class);
        this.periodResponsePeriodFastDtoMapper = periodResponsePeriodFastDtoMapper;
    }

    @Override
    public PeriodResponse toModel(PeriodFastDto periodFastDto) {

        PeriodResponse periodResponse = periodResponsePeriodFastDtoMapper
                .toPeriodResponse(periodFastDto, new CycleAvoidingMappingContext());

        periodResponse
                .add(linkTo(
                        methodOn(
                                PeriodController.class)
                                .getPeriodByPeriodPublicId(periodFastDto.getPeriodPublicId()))
                        .withSelfRel());

        if (periodFastDto.getFieldPublicId() != null) {
            periodResponse.
                    add(linkTo(
                            methodOn(
                                    FieldController.class)
                                    .getFieldByFieldPublicId(periodFastDto.getFieldPublicId()))
                            .withRel("fields"));
        }

        if (periodFastDto.getExecutorPublicId() != null) {
            periodResponse.
                    add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(periodFastDto.getExecutorPublicId()))
                            .withRel("executors"));
        }

        if (periodFastDto.getEduCategoryPublicId() != null) {
            periodResponse.
                    add(linkTo(methodOn(
                            EduCategoryController.class)
                            .getEduCategoryByEduCategoryPublicId(periodFastDto.getEduCategoryPublicId()))
                            .withRel("eduCategories"));
        }

        if (periodFastDto.getLevelPublicId() != null) {
            periodResponse.
                    add(linkTo(methodOn(
                            LevelController.class)
                            .getLevelByLevelPublicId(periodFastDto.getLevelPublicId()))
                            .withRel("levels"));
        }


        return periodResponse;
    }


    @Override
    public CollectionModel<PeriodResponse> toCollectionModel(Iterable<? extends PeriodFastDto> periodFastDtos) {

        CollectionModel<PeriodResponse> periodResponseCollectionModel = super.toCollectionModel(periodFastDtos);

        Pageable pageable = Pageable.unpaged();

        periodResponseCollectionModel
                .add(linkTo(
                        methodOn(PeriodController.class).getPeriods(pageable))
                        .withRel("periods"));

        return periodResponseCollectionModel;
    }
}
