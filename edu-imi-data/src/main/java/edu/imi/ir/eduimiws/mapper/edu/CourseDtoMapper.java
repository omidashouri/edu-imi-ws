package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.CourseCategoryDto;
import edu.imi.ir.eduimiws.models.dto.edu.CourseDto;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface CourseDtoMapper {

    CourseDtoMapper INSTANCE = Mappers.getMapper(CourseDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "courseAim", target = "courseAim"),
            @Mapping(source = "courseCategoryId", target = "courseCategoryId"),
            @Mapping(source = "courseRef", target = "courseRef"),
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "fname", target = "fname"),
            @Mapping(source = "levelId", target = "levelId"),
            @Mapping(source = "lname", target = "lname"),
            @Mapping(source = "silabes", target = "silabes"),
            @Mapping(source = "silabesFile", target = "silabesFile"),
            @Mapping(source = "tunit", target = "tunit")
    })
    @BeanMapping(ignoreByDefault = true)
    CourseDto toCourseDto(CourseEntity courseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    CourseEntity toCourseEntity(CourseDto courseDto
            , @Context CycleAvoidingMappingContext context);

    List<CourseEntity> toCourseEntities(List<CourseDto> courseDtos,
                                        @Context CycleAvoidingMappingContext context);

    List<CourseDto> toCourseDtos(List<CourseEntity> courseEntities,
                                 @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoCoursePublicId(CourseEntity courseEntity,
                                         @MappingTarget CourseDto courseDto) {
/**
 * @implNote Course Public Id
 */
        if (!Hibernate.isInitialized(courseEntity.getCourseApi())) {
            courseEntity.setCourseApi(null);
        }
        if (courseEntity.getCourseApi() != null) {
            if (courseEntity.getCourseApi().getCoursePublicId() != null) {
                courseDto.setCoursePublicId(courseEntity.getCourseApi().getCoursePublicId());
            }
        }
/**
 * @implNote Course Category Public Id
 */
        if (!Hibernate.isInitialized(courseEntity.getCourseCategory())) {
            courseEntity.setCourseCategory(null);
        }
        if (courseEntity.getCourseCategory() != null) {
            CourseCategoryDto courseCategoryDto = new CourseCategoryDto();
            courseCategoryDto.setId(courseEntity.getCourseCategory().getId());
            courseDto.setCourseCategoryDto(courseCategoryDto);
            if (!Hibernate.isInitialized(courseEntity.getCourseCategory().getCourseCategoryApi())) {
                courseEntity.getCourseCategory().setCourseCategoryApi(null);
            }
            if (courseEntity.getCourseCategory().getCourseCategoryApi() != null) {
                courseDto
                        .setCourseCategoryPublicId(
                                courseEntity
                                        .getCourseCategory()
                                        .getCourseCategoryApi()
                                        .getCourseCategoryPublicId()
                        );
            }
        }
/**
 * @implNote Level Public Id
 */
        if (!Hibernate.isInitialized(courseEntity.getLevel())) {
            courseEntity.setLevel(null);
        }
        if (courseEntity.getLevelId() != null) {
            LevelDto levelDto = new LevelDto();
            levelDto.setId(courseEntity.getLevel().getId());
            courseDto.setLevelDto(levelDto);
            if (!Hibernate.isInitialized(courseEntity.getLevel().getLevelApi())) {
                courseEntity.getLevel().setLevelApi(null);
            }
            if (courseEntity.getLevel().getLevelApi() != null) {
                courseDto
                        .setLevelPublicId(
                                courseEntity
                                        .getLevel()
                                        .getLevelApi()
                                        .getLevelPublicId()
                        );
            }
        }
    }
}
