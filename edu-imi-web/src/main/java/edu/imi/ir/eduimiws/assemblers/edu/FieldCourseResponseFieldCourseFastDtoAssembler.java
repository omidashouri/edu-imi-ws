package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.CourseController;
import edu.imi.ir.eduimiws.controllers.edu.v1.FieldController;
import edu.imi.ir.eduimiws.controllers.edu.v1.FieldCourseController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldCourseResponseFieldCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.FieldCourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.FieldCourseResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FieldCourseResponseFieldCourseFastDtoAssembler extends RepresentationModelAssemblerSupport<FieldCourseFastDto, FieldCourseResponse> {
    private final FieldCourseResponseFieldCourseFastDtoMapper fieldCourseResponseFieldCourseFastDtoMapper;


    public FieldCourseResponseFieldCourseFastDtoAssembler(FieldCourseResponseFieldCourseFastDtoMapper fieldCourseResponseFieldCourseFastDtoMapper) {
        super(FieldCourseController.class, FieldCourseResponse.class);
        this.fieldCourseResponseFieldCourseFastDtoMapper = fieldCourseResponseFieldCourseFastDtoMapper;
    }

    @Override
    public FieldCourseResponse toModel(FieldCourseFastDto fieldCourseFastDto) {

        FieldCourseResponse fieldCourseResponse = fieldCourseResponseFieldCourseFastDtoMapper
                .toFieldCourseResponse(fieldCourseFastDto, new CycleAvoidingMappingContext());

        if (fieldCourseFastDto.getFieldCoursePublicId() != null) {
            fieldCourseResponse
                    .add(linkTo(
                            methodOn(
                                    FieldCourseController.class)
                                    .getFieldCourseByFieldCoursePublicId(fieldCourseFastDto.getFieldCoursePublicId()))
                            .withSelfRel());
        }

        if (fieldCourseFastDto.getFieldCoursePublicId() != null) {
            fieldCourseResponse.
                    add(linkTo(
                            methodOn(
                                    FieldCourseController.class)
                                    .getFieldCourseByFieldCoursePublicId(fieldCourseFastDto.getFieldCoursePublicId()))
                            .withRel("fieldCourses"));
        }

        if (fieldCourseFastDto.getCoursePublicId() != null) {
            fieldCourseResponse.
                    add(linkTo(
                            methodOn(
                                    CourseController.class)
                                    .getCourseByCoursePublicId(fieldCourseFastDto.getCoursePublicId()))
                            .withRel("courses"));
        }

        if (fieldCourseFastDto.getFieldPublicId() != null) {
            fieldCourseResponse.
                    add(linkTo(
                            methodOn(
                                    FieldController.class)
                                    .getFieldByFieldPublicId(fieldCourseFastDto.getFieldPublicId()))
                            .withRel("fields"));
        }

        return fieldCourseResponse;
    }


    @Override
    public CollectionModel<FieldCourseResponse> toCollectionModel(Iterable<? extends FieldCourseFastDto> fieldCourseFastDtos) {

        CollectionModel<FieldCourseResponse> fieldCourseResponseCollectionModel = super.toCollectionModel(fieldCourseFastDtos);

        Pageable pageable = Pageable.unpaged();

        fieldCourseResponseCollectionModel
                .add(linkTo(methodOn(FieldCourseController.class)
                        .getFieldCourses(pageable)).withRel("fieldCourses"));

        return fieldCourseResponseCollectionModel;
    }

}
