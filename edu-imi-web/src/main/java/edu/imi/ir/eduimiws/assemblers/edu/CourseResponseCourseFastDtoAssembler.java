package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.CourseController;
import edu.imi.ir.eduimiws.controllers.edu.v1.LevelController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.CourseResponseCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.CourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.CourseResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CourseResponseCourseFastDtoAssembler extends
        RepresentationModelAssemblerSupport<CourseFastDto, CourseResponse> {

    private final CourseResponseCourseFastDtoMapper courseResponseCourseFastDtoMapper;

    public CourseResponseCourseFastDtoAssembler(
            CourseResponseCourseFastDtoMapper courseResponseCourseFastDtoMapper) {
        super(CourseController.class, CourseResponse.class);
        this.courseResponseCourseFastDtoMapper = courseResponseCourseFastDtoMapper;
    }

    @Override
    public CourseResponse toModel(CourseFastDto courseFastDto) {

        CourseResponse courseResponse = courseResponseCourseFastDtoMapper
                .toCourseResponse(courseFastDto, new CycleAvoidingMappingContext());

        courseResponse
                .add(linkTo(
                        methodOn(
                                CourseController.class)
                                .getCourseByCoursePublicId(courseFastDto.getCoursePublicId()))
                        .withSelfRel());

/*        if (courseFastDto.getCourseCategoryPublicId() != null) {
            courseResponse.
                    add(linkTo(
                            methodOn(
                                    CourseCategoryController.class)
                                    .getCourseCategoryByCourseCategoryPublicId(courseFastDto.getCourseCategoryPublicId()))
                            .withRel("courseCategories"));
        }*/

        if (courseFastDto.getLevelPublicId() != null) {
            courseResponse.
                    add(linkTo(
                            methodOn(
                                    LevelController.class)
                                    .getLevelByLevelPublicId(courseFastDto.getLevelPublicId()))
                            .withRel("levels"));
        }

        return courseResponse;
    }

    @Override
    public CollectionModel<CourseResponse> toCollectionModel(Iterable<? extends CourseFastDto> courseFastDtos) {

        CollectionModel<CourseResponse> courseResponseCollectionModel = super.toCollectionModel(courseFastDtos);

        Pageable pageable = Pageable.unpaged();

        courseResponseCollectionModel
                .add(linkTo(
                        methodOn(CourseController.class).getAllCourses(pageable))
                        .withRel("courses"));

        return courseResponseCollectionModel;
    }
}
