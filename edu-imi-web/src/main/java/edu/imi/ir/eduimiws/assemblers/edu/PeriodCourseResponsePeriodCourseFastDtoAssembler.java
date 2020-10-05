package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.CourseController;
import edu.imi.ir.eduimiws.controllers.v1.PeriodController;
import edu.imi.ir.eduimiws.controllers.v1.PeriodCourseController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCourseResponsePeriodCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PeriodCourseResponsePeriodCourseFastDtoAssembler extends
        RepresentationModelAssemblerSupport<PeriodCourseFastDto, PeriodCourseResponse> {

    private final PeriodCourseResponsePeriodCourseFastDtoMapper periodCourseResponsePeriodCourseFastDtoMapper;

    public PeriodCourseResponsePeriodCourseFastDtoAssembler(
            PeriodCourseResponsePeriodCourseFastDtoMapper periodCourseResponsePeriodCourseFastDtoMapper) {
        super(PeriodCourseController.class, PeriodCourseResponse.class);
        this.periodCourseResponsePeriodCourseFastDtoMapper = periodCourseResponsePeriodCourseFastDtoMapper;
    }

    @Override
    public PeriodCourseResponse toModel(PeriodCourseFastDto periodCourseFastDto) {

        PeriodCourseResponse periodCourseResponse = periodCourseResponsePeriodCourseFastDtoMapper
                .toPeriodCourseResponse(periodCourseFastDto, new CycleAvoidingMappingContext());

        periodCourseResponse
                .add(linkTo(
                        methodOn(
                                PeriodCourseController.class)
                                .getPeriodCourseByPeriodCoursePublicId(periodCourseFastDto.getPeriodCoursePublicId()))
                        .withSelfRel());

        if (periodCourseFastDto.getPeriodPublicId() != null) {
            periodCourseResponse.
                    add(linkTo(
                            methodOn(
                                    PeriodController.class)
                                    .getPeriodByPeriodPublicId(periodCourseFastDto.getPeriodPublicId()))
                            .withRel("periods"));
        }

        if (periodCourseFastDto.getCoursePublicId() != null) {
            periodCourseResponse.
                    add(linkTo(
                            methodOn(
                                    CourseController.class)
                                    .getCourseByCoursePublicId(periodCourseFastDto.getCoursePublicId()))
                            .withRel("courses"));
        }
        return periodCourseResponse;
    }

    @Override
    public CollectionModel<PeriodCourseResponse> toCollectionModel(Iterable<? extends PeriodCourseFastDto> periodCourseFastDtos) {

        CollectionModel<PeriodCourseResponse> periodCourseResponseCollectionModel = super.toCollectionModel(periodCourseFastDtos);

        Pageable pageable = Pageable.unpaged();

        periodCourseResponseCollectionModel
                .add(linkTo(
                        methodOn(PeriodCourseController.class).getAllPeriodCourses(pageable))
                        .withRel("periodCourses"));

        return periodCourseResponseCollectionModel;
    }
}