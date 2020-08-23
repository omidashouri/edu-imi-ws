package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.CourseDto;
import edu.imi.ir.eduimiws.models.dto.edu.FieldCourseDto;
import edu.imi.ir.eduimiws.models.dto.edu.FieldDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FieldCourseDtoMapper {

    FieldCourseDtoMapper INSTANCE = Mappers.getMapper(FieldCourseDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "course.id", target = "courseId"),
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "field.id", target = "fieldId"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "tunit", target = "tunit")
    })
    @BeanMapping(ignoreByDefault = true)
    FieldCourseDto toFieldCourseDto(FieldCourseEntity fieldCourseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldCourseEntity toFieldCourseEntity(FieldCourseDto fieldCourseDto
            , @Context CycleAvoidingMappingContext context);

    List<FieldCourseEntity> toFieldCourseEntities(List<FieldCourseDto> fieldCourseDtos,
                                                  @Context CycleAvoidingMappingContext context);

    List<FieldCourseDto> toFieldCourseDtos(List<FieldCourseEntity> fieldCourseEntities,
                                           @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoFieldCoursePublicId(FieldCourseEntity fieldCourseEntity,
                                              @MappingTarget FieldCourseDto fieldCourseDto) {

        /**
         * @implNote FieldCourse Public Id
         */
        if (!Hibernate.isInitialized(fieldCourseEntity.getFieldCourseApi())) {
            fieldCourseEntity.setFieldCourseApi(null);
        }
        if (fieldCourseEntity.getFieldCourseApi() != null) {
            if (fieldCourseEntity.getFieldCourseApi().getFieldCoursePublicId() != null) {
                fieldCourseDto.setFieldCoursePublicId(fieldCourseEntity.getFieldCourseApi().getFieldCoursePublicId());
            }
            if (fieldCourseEntity.getFieldCourseApi().getId() != null) {
                fieldCourseDto.setFieldCourseApiId(fieldCourseEntity.getFieldCourseApi().getId());
            }
        }
/**
 * @implNote FieldCourse Course Public Id
 */
        if (!Hibernate.isInitialized(fieldCourseEntity.getCourse())) {
            fieldCourseEntity.setCourse(null);
        }
        if (fieldCourseEntity.getCourse() != null) {
            CourseDto courseDto = new CourseDtoMapperImpl()
                    .toCourseDto(fieldCourseEntity.getCourse(),
                            new CycleAvoidingMappingContext());
            fieldCourseDto.setCourseDto(courseDto);

            if (!Hibernate.isInitialized(fieldCourseEntity.getCourse().getCourseApi())) {
                fieldCourseEntity.getCourse().setCourseApi(null);
            }
            if (fieldCourseEntity.getCourse().getCourseApi() != null) {
                fieldCourseDto
                        .setCoursePublicId(
                                fieldCourseEntity
                                        .getCourse()
                                        .getCourseApi()
                                        .getCoursePublicId()
                        );
                fieldCourseDto
                        .setFieldCourseApiId(
                                fieldCourseEntity
                                        .getCourse()
                                        .getCourseApi()
                                        .getId()
                        );
            }
        }

/**
 * @implNote FieldCourse Field Public Id
 */

        if (!Hibernate.isInitialized(fieldCourseEntity.getField())) {
            fieldCourseEntity.setField(null);
        }
        if (fieldCourseEntity.getField() != null) {
            FieldDto fieldDto = new FieldDto();
            fieldDto.setId(fieldCourseEntity.getField().getId());
            fieldCourseDto.setFieldDto(fieldDto);
            if (!Hibernate.isInitialized(fieldCourseEntity.getField().getFieldApi())) {
                fieldCourseEntity.getField().setFieldApi(null);
            }
            if (fieldCourseEntity.getField().getFieldApi() != null) {
                fieldCourseDto
                        .setFieldPublicId(
                                fieldCourseEntity
                                        .getField()
                                        .getFieldApi()
                                        .getFieldPublicId()
                        );
                fieldCourseDto.setFieldCourseApiId(
                        fieldCourseEntity
                                .getField()
                                .getFieldApi()
                                .getId()
                );
            }
        }
    }
}
