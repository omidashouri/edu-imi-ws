package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.TermPresentedCourseResponseTermPresentedCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedCourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedCourseResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TermPresentedCourseResponseTermPresentedCourseFastDtoAssembler extends RepresentationModelAssemblerSupport<TermPresentedCourseFastDto, TermPresentedCourseResponse> {
    private final TermPresentedCourseResponseTermPresentedCourseFastDtoMapper termPresentedCourseResponseTermPresentedCourseFastDtoMapper;


    public TermPresentedCourseResponseTermPresentedCourseFastDtoAssembler(TermPresentedCourseResponseTermPresentedCourseFastDtoMapper termPresentedCourseResponseTermPresentedCourseFastDtoMapper) {
        super(TermPresentedCourseController.class, TermPresentedCourseResponse.class);
        this.termPresentedCourseResponseTermPresentedCourseFastDtoMapper = termPresentedCourseResponseTermPresentedCourseFastDtoMapper;
    }

    @Override
    public TermPresentedCourseResponse toModel(TermPresentedCourseFastDto termPresentedCourseFastDto) {

        TermPresentedCourseResponse termPresentedCourseResponse = termPresentedCourseResponseTermPresentedCourseFastDtoMapper
                .toTermPresentedCourseResponse(termPresentedCourseFastDto, new CycleAvoidingMappingContext());

        if (termPresentedCourseFastDto.getTermPresentedCoursePublicId() != null) {
            termPresentedCourseResponse
                    .add(linkTo(
                            methodOn(
                                    TermPresentedCourseController.class)
                                    .getTermPresentedCourseByTermPresentedCoursePublicId(termPresentedCourseFastDto.getTermPresentedCoursePublicId()))
                            .withSelfRel());
        }

        if (termPresentedCourseFastDto.getTermPresentedCoursePublicId() != null) {
            termPresentedCourseResponse.
                    add(linkTo(
                            methodOn(
                                    TermPresentedCourseController.class)
                                    .getTermPresentedCourseByTermPresentedCoursePublicId(termPresentedCourseFastDto.getTermPresentedCoursePublicId()))
                            .withRel("termPresentedCourses"));
        }

        if (termPresentedCourseFastDto.getCoursePublicId() != null) {
            termPresentedCourseResponse.
                    add(linkTo(
                            methodOn(
                                    CourseController.class)
                                    .getCourseByCoursePublicId(termPresentedCourseFastDto.getCoursePublicId()))
                            .withRel("courses"));
        }

        if (termPresentedCourseFastDto.getPeriodPublicId() != null) {
            termPresentedCourseResponse.
                    add(linkTo(
                            methodOn(
                                    PeriodController.class)
                                    .getPeriodByPeriodPublicId(termPresentedCourseFastDto.getPeriodPublicId()))
                            .withRel("periods"));
        }

        if (termPresentedCourseFastDto.getTermPublicId() != null) {
            termPresentedCourseResponse.
                    add(linkTo(
                            methodOn(
                                    TermController.class)
                                    .getTermByTermPublicId(termPresentedCourseFastDto.getTermPublicId()))
                            .withRel("terms"));
        }

        if (termPresentedCourseFastDto.getFieldCoursePublicId() != null) {
            termPresentedCourseResponse.
                    add(linkTo(
                            methodOn(
                                    FieldCourseController.class)
                                    .getFieldCourseByFieldCoursePublicId(termPresentedCourseFastDto.getFieldCoursePublicId()))
                            .withRel("fieldCourses"));
        }

        return termPresentedCourseResponse;
    }


    @Override
    public CollectionModel<TermPresentedCourseResponse> toCollectionModel(Iterable<? extends TermPresentedCourseFastDto> termPresentedCourseFastDtos) {

        CollectionModel<TermPresentedCourseResponse> termPresentedCourseResponseCollectionModel = super.toCollectionModel(termPresentedCourseFastDtos);

        Pageable pageable = Pageable.unpaged();

        termPresentedCourseResponseCollectionModel
                .add(linkTo(methodOn(TermPresentedCourseController.class)
                        .getTermPresentedCourses(pageable)).withRel("termPresentedCourses"));

        return termPresentedCourseResponseCollectionModel;
    }

}
