package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.CourseDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseDtoMapper {

    PeriodCourseDtoMapper INSTANCE = Mappers.getMapper(PeriodCourseDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "course.id", target = "courseId"),
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "inAverage", target = "inAverage"),
            @Mapping(source = "period.id", target = "periodId"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "sessionNumber", target = "sessionNumber"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "time", target = "time")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCourseDto toPeriodCourseDto(PeriodCourseEntity periodCourseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseEntity toPeriodCourseEntity(PeriodCourseDto periodCourseDto
            , @Context CycleAvoidingMappingContext context);

    List<PeriodCourseEntity> toPeriodCourseEntities(List<PeriodCourseDto> periodCourseDtos,
                                                    @Context CycleAvoidingMappingContext context);

    List<PeriodCourseDto> toPeriodCourseDtos(List<PeriodCourseEntity> periodCourseEntities,
                                             @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoPeriodCoursePublicId(PeriodCourseEntity periodCourseEntity,
                                               @MappingTarget PeriodCourseDto periodCourseDto) {

        /**
         * @implNote PeriodCourse Public Id
         */
        if (!Hibernate.isInitialized(periodCourseEntity.getPeriodCourseApi())) {
            periodCourseEntity.setPeriodCourseApi(null);
        }
        if (periodCourseEntity.getPeriodCourseApi() != null) {
            if (periodCourseEntity.getPeriodCourseApi().getPeriodCoursePublicId() != null) {
                periodCourseDto
                        .setPeriodCoursePublicId(
                                periodCourseEntity
                                        .getPeriodCourseApi()
                                        .getPeriodCoursePublicId()
                        );
            }
        }
/**
 * @implNote Period Public Id
 */
        if (!Hibernate.isInitialized(periodCourseEntity.getPeriod())) {
            periodCourseEntity.setPeriod(null);
        }
        if (periodCourseEntity.getPeriod() != null) {
            PeriodDto periodDto = new PeriodDto();
            periodDto.setId(periodCourseEntity.getPeriod().getId());
            periodCourseDto.setPeriodDto(periodDto);
            if (!Hibernate.isInitialized(periodCourseEntity.getPeriod().getPeriodApi())) {
                periodCourseEntity.getPeriod().setPeriodApi(null);
            }
            if (periodCourseEntity.getPeriod().getPeriodApi() != null) {
                periodCourseDto
                        .setPeriodPublicId(
                                periodCourseEntity
                                        .getPeriod()
                                        .getPeriodApi()
                                        .getPeriodPublicId()
                        );
            }
        }

        /**
         * @implNote Course Public Id
         */
        if (!Hibernate.isInitialized(periodCourseEntity.getCourse())) {
            periodCourseEntity.setCourse(null);
        }
        if (periodCourseEntity.getCourse() != null) {
            CourseDto periodDto = new CourseDto();
            periodDto.setId(periodCourseEntity.getCourse().getId());
            periodCourseDto.setCourseDto(periodDto);
            if (!Hibernate.isInitialized(periodCourseEntity.getCourse().getCourseApi())) {
                periodCourseEntity.getCourse().setCourseApi(null);
            }
            if (periodCourseEntity.getCourse().getCourseApi() != null) {
                periodCourseDto
                        .setCoursePublicId(
                                periodCourseEntity
                                        .getCourse()
                                        .getCourseApi()
                                        .getCoursePublicId()
                        );
            }
        }
    }
}
