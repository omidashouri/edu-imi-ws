package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseProfessorDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseProfessorResponse;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseProfessorResponseDtoMapper {

    PeriodCourseProfessorResponseDtoMapper INSTANCE = Mappers.getMapper(PeriodCourseProfessorResponseDtoMapper.class);

    @Mappings({
            @Mapping(source = "periodCourseProfessorPublicId", target = "periodCourseProfessorPublicId"),
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "periodCoursePublicId", target = "periodCoursePublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "professorPublicId", target = "professorPublicId"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId")

    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCourseProfessorResponse toProfessorDto(PeriodCourseProfessorDto periodCourseProfessorDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseProfessorDto toProfessorEntity(PeriodCourseProfessorResponse periodCourseProfessorResponse
            , @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorDto> toProfessorEntities(List<PeriodCourseProfessorResponse> professorDtos,
                                                       @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorResponse> toProfessorDtos(List<PeriodCourseProfessorDto> professorEntities,
                                                        @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoProfessorPublicId(PeriodCourseProfessorDto periodCourseProfessorDto,
                                            @MappingTarget PeriodCourseProfessorResponse periodCourseProfessorResponse) {

//      PeriodCourse
        if (!Hibernate.isInitialized(periodCourseProfessorDto.getPeriodCourseDto())) {
            periodCourseProfessorDto.setPeriodCourseDto(null);
        }

        if (periodCourseProfessorDto.getPeriodCourseDto() != null) {
            periodCourseProfessorResponse
                    .setCourseTypeId(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getCourseTypeId());

            periodCourseProfessorResponse
                    .setEndDate(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getEndDate()
                    );

            periodCourseProfessorResponse
                    .setInAverage(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getInAverage()
                    );

            periodCourseProfessorResponse
                    .setScoreAcceptBound(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getScoreAcceptBound()
                    );

            periodCourseProfessorResponse
                    .setScoreAcceptedQuality(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getScoreAcceptedQuality()
                    );

            periodCourseProfessorResponse
                    .setScoreHighBound(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getScoreHighBound()
                    );

            periodCourseProfessorResponse
                    .setScoreLowBound(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getScoreLowBound()
                    );

            periodCourseProfessorResponse
                    .setScoringWay(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getScoringWay()
                    );

            periodCourseProfessorResponse
                    .setSessionNumber(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getSessionNumber()
                    );

            periodCourseProfessorResponse
                    .setStartDate(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getStartDate()
                    );

            periodCourseProfessorResponse
                    .setTime(
                            periodCourseProfessorDto.
                                    getPeriodCourseDto().
                                    getTime()
                    );
        }
    }
}
