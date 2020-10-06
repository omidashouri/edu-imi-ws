package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.TermPresentedGroupResponseTermPresentedGroupFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedGroupFastDto;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedGroupResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TermPresentedGroupResponseTermPresentedGroupFastDtoAssembler extends RepresentationModelAssemblerSupport<TermPresentedGroupFastDto, TermPresentedGroupResponse> {
    private final TermPresentedGroupResponseTermPresentedGroupFastDtoMapper termPresentedGroupResponseTermPresentedGroupFastDtoMapper;


    public TermPresentedGroupResponseTermPresentedGroupFastDtoAssembler(TermPresentedGroupResponseTermPresentedGroupFastDtoMapper termPresentedGroupResponseTermPresentedGroupFastDtoMapper) {
        super(TermPresentedGroupController.class, TermPresentedGroupResponse.class);
        this.termPresentedGroupResponseTermPresentedGroupFastDtoMapper = termPresentedGroupResponseTermPresentedGroupFastDtoMapper;
    }

    @Override
    public TermPresentedGroupResponse toModel(TermPresentedGroupFastDto termPresentedGroupFastDto) {

        TermPresentedGroupResponse termPresentedGroupResponse = termPresentedGroupResponseTermPresentedGroupFastDtoMapper
                .toTermPresentedGroupResponse(termPresentedGroupFastDto, new CycleAvoidingMappingContext());

        if (termPresentedGroupFastDto.getTermPresentedGroupPublicId() != null) {
            termPresentedGroupResponse
                    .add(linkTo(
                            methodOn(
                                    TermPresentedGroupController.class)
                                    .getTermPresentedGroupByTermPresentedGroupPublicId(termPresentedGroupFastDto.getTermPresentedGroupPublicId()))
                            .withSelfRel());
        }

        if (termPresentedGroupFastDto.getTermPresentedGroupPublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    TermPresentedGroupController.class)
                                    .getTermPresentedGroupByTermPresentedGroupPublicId(termPresentedGroupFastDto.getTermPresentedGroupPublicId()))
                            .withRel("termCourseProfessors"));
        }

        if (termPresentedGroupFastDto.getCoursePublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    CourseController.class)
                                    .getCourseByCoursePublicId(termPresentedGroupFastDto.getCoursePublicId()))
                            .withRel("courses"));
        }

        if (termPresentedGroupFastDto.getPeriodPublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    PeriodController.class)
                                    .getPeriodByPeriodPublicId(termPresentedGroupFastDto.getPeriodPublicId()))
                            .withRel("periods"));
        }

        if (termPresentedGroupFastDto.getFieldCoursePublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    FieldCourseController.class)
                                    .getFieldCourseByFieldCoursePublicId(termPresentedGroupFastDto.getFieldCoursePublicId()))
                            .withRel("fieldCourses"));
        }

        if (termPresentedGroupFastDto.getProfessorPublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    ProfessorController.class)
                                    .getProfessorByProfessorPublicId(termPresentedGroupFastDto.getProfessorPublicId()))
                            .withRel("professors"));
        }

        if (termPresentedGroupFastDto.getTermPublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    TermController.class)
                                    .getTermByTermPublicId(termPresentedGroupFastDto.getTermPublicId()))
                            .withRel("terms"));
        }

        if (termPresentedGroupFastDto.getTermPresentedCoursePublicId() != null) {
            termPresentedGroupResponse.
                    add(linkTo(
                            methodOn(
                                    TermPresentedCourseController.class)
                                    .getTermPresentedCourseByTermPresentedCoursePublicId(termPresentedGroupFastDto.getTermPresentedCoursePublicId()))
                            .withRel("termPresentedCourses"));
        }

        return termPresentedGroupResponse;
    }


    @Override
    public CollectionModel<TermPresentedGroupResponse> toCollectionModel(Iterable<? extends TermPresentedGroupFastDto> termPresentedGroupFastDtos) {

        CollectionModel<TermPresentedGroupResponse> termPresentedGroupResponseCollectionModel = super.toCollectionModel(termPresentedGroupFastDtos);

        Pageable pageable = Pageable.unpaged();

        termPresentedGroupResponseCollectionModel
                .add(linkTo(methodOn(TermPresentedGroupController.class)
                        .getTermPresentedGroups(pageable)).withRel("termCourseProfessors"));

        return termPresentedGroupResponseCollectionModel;
    }

}
