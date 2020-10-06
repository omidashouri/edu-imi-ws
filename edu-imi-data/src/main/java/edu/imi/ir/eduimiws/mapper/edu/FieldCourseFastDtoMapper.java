package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldCourseFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FieldCourseFastDtoMapper {

    FieldCourseFastDtoMapper INSTANCE = Mappers.getMapper(FieldCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "tunit", target = "tunit")
    })
    @BeanMapping(ignoreByDefault = true)
    FieldCourseFastDto toFieldCourseFastDto(FieldCourseEntity fieldCourseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldCourseEntity toFieldCourseEntity(FieldCourseFastDto fieldCourseFastDto
            , @Context CycleAvoidingMappingContext context);

    List<FieldCourseEntity> toFieldCourseEntities(List<FieldCourseFastDto> fieldCourseFastDtos,
                                                  @Context CycleAvoidingMappingContext context);

    List<FieldCourseFastDto> toFieldCourseFastDtos(List<FieldCourseEntity> fieldCourseEntities,
                                                   @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoFieldCoursePublicId(FieldCourseEntity fieldCourseEntity,
                                              @MappingTarget FieldCourseFastDto fieldCourseFastDto) {


//        FieldCourse Public Id
        if (!Hibernate.isInitialized(fieldCourseEntity.getFieldCourseApi())) {
            fieldCourseEntity.setFieldCourseApi(null);
        }
        if (fieldCourseEntity.getFieldCourseApi() != null) {
            if (fieldCourseEntity.getFieldCourseApi().getFieldCoursePublicId() != null) {
                fieldCourseFastDto.setFieldCoursePublicId(fieldCourseEntity.getFieldCourseApi().getFieldCoursePublicId());
            }
            if (fieldCourseEntity.getFieldCourseApi().getFieldPublicId() != null) {
                fieldCourseFastDto.setFieldPublicId(fieldCourseEntity.getFieldCourseApi().getFieldPublicId());
            }
            if (fieldCourseEntity.getFieldCourseApi().getCoursePublicId() != null) {
                fieldCourseFastDto.setCoursePublicId(fieldCourseEntity.getFieldCourseApi().getCoursePublicId());
            }
        }

//        Field Name
        if (!Hibernate.isInitialized(fieldCourseEntity.getField())) {
            fieldCourseEntity.setField(null);
        }
        if (fieldCourseEntity.getField() != null) {
            if (fieldCourseEntity.getField().getFname() != null) {
                fieldCourseFastDto.setFieldName(fieldCourseEntity.getField().getFname());
            }
        }

//        Course Name
        if (!Hibernate.isInitialized(fieldCourseEntity.getCourse())) {
            fieldCourseEntity.setCourse(null);
        }
        if (fieldCourseEntity.getCourse() != null) {
            if (fieldCourseEntity.getCourse().getFname() != null) {
                fieldCourseFastDto.setCourseName(fieldCourseEntity.getCourse().getFname());
            }
        }

//  FieldCourse Creator Public Id
        if (!Hibernate.isInitialized(fieldCourseEntity.getCreator())) {
            fieldCourseEntity.setCreator(null);
        }
        if (fieldCourseEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(fieldCourseEntity.getCreator().getPersonApiEntity())) {
                fieldCourseEntity.getCreator().setPersonApiEntity(null);
            }
            if (fieldCourseEntity.getCreator().getPersonApiEntity() != null) {
                fieldCourseFastDto
                        .setCreatorPublicId(
                                fieldCourseEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

        //  FieldCourse Editor Public Id
        if (!Hibernate.isInitialized(fieldCourseEntity.getEditor())) {
            fieldCourseEntity.setEditor(null);
        }
        if (fieldCourseEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(fieldCourseEntity.getEditor().getPersonApiEntity())) {
                fieldCourseEntity.getEditor().setPersonApiEntity(null);
            }
            if (fieldCourseEntity.getEditor().getPersonApiEntity() != null) {
                fieldCourseFastDto
                        .setEditorPublicId(
                                fieldCourseEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
