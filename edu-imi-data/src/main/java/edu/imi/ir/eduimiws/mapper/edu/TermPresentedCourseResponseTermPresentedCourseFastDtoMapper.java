package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedCourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedCourseResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedCourseResponseTermPresentedCourseFastDtoMapper {

    TermPresentedCourseResponseTermPresentedCourseFastDtoMapper INSTANCE = Mappers.getMapper(TermPresentedCourseResponseTermPresentedCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "termPresentedCoursePublicId", target = "termPresentedCoursePublicId"),
            @Mapping(source = "fieldCoursePublicId", target = "fieldCoursePublicId"),
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "termPublicId", target = "termPublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "courseName", target = "courseName"),
            @Mapping(source = "termName", target = "termName"),
            @Mapping(source = "periodName", target = "periodName"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "time", target = "time")
    })
    @BeanMapping(ignoreByDefault = true)
    TermPresentedCourseFastDto toTermPresentedCourseFastDto(TermPresentedCourseResponse termPresentedCourseResponse
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedCourseResponse toTermPresentedCourseResponse(TermPresentedCourseFastDto termPresentedCourseFastDto
            , @Context CycleAvoidingMappingContext context);

    List<TermPresentedCourseResponse> toTermPresentedCourseResponses(List<TermPresentedCourseFastDto> termPresentedCourseFastDtos,
                                                                     @Context CycleAvoidingMappingContext context);

    List<TermPresentedCourseFastDto> toTermPresentedCourseFastDtos(List<TermPresentedCourseResponse> termPresentedCourseResponses,
                                                                   @Context CycleAvoidingMappingContext context);

}
