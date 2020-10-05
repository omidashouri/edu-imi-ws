package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.CourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.CourseResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CourseResponseCourseFastDtoMapper {

    CourseResponseCourseFastDtoMapper INSTANCE = Mappers
            .getMapper(CourseResponseCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "courseAim", target = "courseAim"),
            @Mapping(source = "courseRef", target = "courseRef"),
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "fname", target = "fname"),
            @Mapping(source = "lname", target = "lname"),
            @Mapping(source = "silabes", target = "silabes"),
            @Mapping(source = "silabesFile", target = "silabesFile"),
            @Mapping(source = "tunit", target = "tunit"),
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "courseCategoryPublicId", target = "courseCategoryPublicId"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "courseCategoryName", target = "courseCategoryName"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "levelName", target = "levelName")
    })
    @BeanMapping(ignoreByDefault = true)
    CourseResponse toCourseResponse(CourseFastDto courseFastDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    CourseFastDto toCourseFastDto(CourseResponse courseResponse,
                                  @Context CycleAvoidingMappingContext context);

    List<CourseFastDto> toCourseFastDtos(List<CourseResponse> courseResponses,
                                         @Context CycleAvoidingMappingContext context);

    List<CourseResponse> toCourseResponses(List<CourseFastDto> courseFastDtos,
                                           @Context CycleAvoidingMappingContext context);
}
