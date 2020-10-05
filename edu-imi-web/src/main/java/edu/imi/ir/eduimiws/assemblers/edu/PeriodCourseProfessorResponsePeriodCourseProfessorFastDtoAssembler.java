package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCourseProfessorResponseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseProfessorFastDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseProfessorResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PeriodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler
        extends RepresentationModelAssemblerSupport<PeriodCourseProfessorFastDto, PeriodCourseProfessorResponse> {

    private final PeriodCourseProfessorResponseFastDtoMapper periodCourseProfessorResponseFastDtoMapper;

    public PeriodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler(
            PeriodCourseProfessorResponseFastDtoMapper periodCourseProfessorResponseFastDtoMapper) {
        super(PeriodCourseProfessorController.class, PeriodCourseProfessorResponse.class);
        this.periodCourseProfessorResponseFastDtoMapper = periodCourseProfessorResponseFastDtoMapper;
    }

    @Override
    public PeriodCourseProfessorResponse toModel(PeriodCourseProfessorFastDto periodCourseProfessorFastDto) {

        PeriodCourseProfessorResponse periodCourseProfessorResponse = periodCourseProfessorResponseFastDtoMapper
                .toPeriodCourseProfessorResponse(periodCourseProfessorFastDto, new CycleAvoidingMappingContext());

        periodCourseProfessorResponse
                .add(linkTo(
                        methodOn(
                                PeriodCourseProfessorController.class)
                                .getPeriodCourseProfessorByPeriodCourseProfessorPublicId(periodCourseProfessorFastDto.getPeriodCourseProfessorPublicId()))
                        .withSelfRel());

        if (periodCourseProfessorFastDto.getPeriodPublicId() != null) {
            periodCourseProfessorResponse.
                    add(linkTo(methodOn(
                            PeriodController.class)
                            .getPeriodByPeriodPublicId(periodCourseProfessorFastDto.getPeriodPublicId()))
                            .withRel("periods"));
        }

        if (periodCourseProfessorFastDto.getCoursePublicId() != null) {
            periodCourseProfessorResponse.
                    add(linkTo(
                            methodOn(
                                    CourseController.class)
                                    .getCourseByCoursePublicId(periodCourseProfessorFastDto.getCoursePublicId()))
                            .withRel("courses"));
        }

        if (periodCourseProfessorFastDto.getPeriodCoursePublicId() != null) {
            periodCourseProfessorResponse.
                    add(linkTo(
                            methodOn(
                                    PeriodCourseController.class)
                                    .getPeriodCourseByPeriodCoursePublicId(periodCourseProfessorFastDto.getPeriodCoursePublicId()))
                            .withRel("periodCourses"));
        }

        if (periodCourseProfessorFastDto.getProfessorPublicId() != null) {
            periodCourseProfessorResponse.
                    add(linkTo(methodOn(
                            ProfessorController.class)
                            .getProfessorByProfessorPublicId(periodCourseProfessorFastDto.getProfessorPublicId()))
                            .withRel("professors"));
        }

        return periodCourseProfessorResponse;
    }

    @Override
    public CollectionModel<PeriodCourseProfessorResponse> toCollectionModel(Iterable<? extends PeriodCourseProfessorFastDto> periodCourseProfessorFastDtos) {

        CollectionModel<PeriodCourseProfessorResponse> periodCourseProfessorResponseCollectionModel = super.toCollectionModel(periodCourseProfessorFastDtos);

        Pageable pageable = Pageable.unpaged();

        periodCourseProfessorResponseCollectionModel
                .add(linkTo(
                        methodOn(PeriodCourseProfessorController.class).getAllPeriodCourseProfessors(pageable))
                        .withRel("periodCourseProfessors"));

        return periodCourseProfessorResponseCollectionModel;
    }


}
