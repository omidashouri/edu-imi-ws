package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseFastDtoMapper {

    PeriodCourseFastDtoMapper INSTANCE = Mappers.getMapper(PeriodCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "inAverage", target = "inAverage"),
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
    PeriodCourseFastDto toPeriodCourseFastDto(PeriodCourseEntity periodCourseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseEntity toPeriodCourseEntity(PeriodCourseFastDto periodCourseFastDto
            , @Context CycleAvoidingMappingContext context);

    List<PeriodCourseEntity> toPeriodCourseEntities(List<PeriodCourseFastDto> periodCourseFastDtos,
                                                    @Context CycleAvoidingMappingContext context);

    List<PeriodCourseFastDto> toPeriodCourseFastDtos(List<PeriodCourseEntity> periodCourseEntities,
                                                     @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoPeriodCoursePublicId(PeriodCourseEntity periodCourseEntity,
                                               @MappingTarget PeriodCourseFastDto periodCourseFastDto) {


//        PeriodCourse Public Id
        if (!Hibernate.isInitialized(periodCourseEntity.getPeriodCourseApi())) {
            periodCourseEntity.setPeriodCourseApi(null);
        }
        if (periodCourseEntity.getPeriodCourseApi() != null) {
            if (periodCourseEntity.getPeriodCourseApi().getPeriodCoursePublicId() != null) {
                periodCourseFastDto.setPeriodCoursePublicId(periodCourseEntity.getPeriodCourseApi().getPeriodCoursePublicId());
            }
            if (periodCourseEntity.getPeriodCourseApi().getPeriodPublicId() != null) {
                periodCourseFastDto.setPeriodPublicId(periodCourseEntity.getPeriodCourseApi().getPeriodPublicId());
            }
            if (periodCourseEntity.getPeriodCourseApi().getCoursePublicId() != null) {
                periodCourseFastDto.setCoursePublicId(periodCourseEntity.getPeriodCourseApi().getCoursePublicId());
            }
        }

//  PeriodCourse Creator Public Id
        if (!Hibernate.isInitialized(periodCourseEntity.getCreator())) {
            periodCourseEntity.setCreator(null);
        }
        if (periodCourseEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(periodCourseEntity.getCreator().getPersonApiEntity())) {
                periodCourseEntity.getCreator().setPersonApiEntity(null);
            }
            if (periodCourseEntity.getCreator().getPersonApiEntity() != null) {
                periodCourseFastDto
                        .setCreatorPublicId(
                                periodCourseEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

        //  PeriodCourse Editor Public Id
        if (!Hibernate.isInitialized(periodCourseEntity.getEditor())) {
            periodCourseEntity.setEditor(null);
        }
        if (periodCourseEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(periodCourseEntity.getEditor().getPersonApiEntity())) {
                periodCourseEntity.getEditor().setPersonApiEntity(null);
            }
            if (periodCourseEntity.getEditor().getPersonApiEntity() != null) {
                periodCourseFastDto
                        .setEditorPublicId(
                                periodCourseEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
