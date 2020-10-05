package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.CourseFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CourseFastDtoMapper {

    CourseFastDtoMapper INSTANCE = Mappers.getMapper(CourseFastDtoMapper.class);

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
            @Mapping(source = "tunit", target = "tunit")
    })
    @BeanMapping(ignoreByDefault = true)
    CourseFastDto toCourseFastDto(CourseEntity courseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    CourseEntity toCourseEntity(CourseFastDto courseFastDto
            , @Context CycleAvoidingMappingContext context);

    List<CourseEntity> toCourseEntities(List<CourseFastDto> courseFastDtos,
                                        @Context CycleAvoidingMappingContext context);

    List<CourseFastDto> toCourseFastDtos(List<CourseEntity> professorEntities,
                                         @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoCoursePublicId(CourseEntity courseEntity,
                                         @MappingTarget CourseFastDto courseFastDto) {


//          Course Public Id
        if (!Hibernate.isInitialized(courseEntity.getCourseApi())) {
            courseEntity.setCourseApi(null);
        }
        if (courseEntity.getCourseApi() != null) {
            if (courseEntity.getCourseApi().getCoursePublicId() != null) {
                courseFastDto.setCoursePublicId(courseEntity.getCourseApi().getCoursePublicId());
            }
            if (courseEntity.getCourseApi().getCourseCategoryPublicId() != null) {
                courseFastDto.setCourseCategoryPublicId(courseEntity.getCourseApi().getCourseCategoryPublicId());
            }
            if (courseEntity.getCourseApi().getLevelPublicId() != null) {
                courseFastDto.setLevelPublicId(courseEntity.getCourseApi().getLevelPublicId());
            }
        }

//        Course > Creator Public Id
        if (!Hibernate.isInitialized(courseEntity.getCreator())) {
            courseEntity.setCreator(null);
        }
        if (courseEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(courseEntity.getCreator().getPersonApiEntity())) {
                courseEntity.getCreator().setPersonApiEntity(null);
            }
            if (courseEntity.getCreator().getPersonApiEntity() != null) {
                courseFastDto
                        .setCreatorPublicId(
                                courseEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

//        Course > Editor Public Id
        if (!Hibernate.isInitialized(courseEntity.getEditor())) {
            courseEntity.setEditor(null);
        }
        if (courseEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(courseEntity.getEditor().getPersonApiEntity())) {
                courseEntity.getEditor().setPersonApiEntity(null);
            }
            if (courseEntity.getEditor().getPersonApiEntity() != null) {
                courseFastDto
                        .setEditorPublicId(
                                courseEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
