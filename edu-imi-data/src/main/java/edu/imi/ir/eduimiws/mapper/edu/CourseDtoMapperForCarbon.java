package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.CourseDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface CourseDtoMapperForCarbon {

    CourseDtoMapperForCarbon INSTANCE = Mappers.getMapper(CourseDtoMapperForCarbon.class);

    @Mappings({
            @Mapping(source = "id", target = "id")
//            @Mapping(source = "", target = "")
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

        if (!Hibernate.isInitialized(courseEntity.getCourseApi())) {
            courseEntity.setCourseApi(null);
        }

        if (courseEntity.getCourseApi() != null) {
            if (courseEntity.getCourseApi().getCoursePublicId() != null) {
                courseDto.setCoursePublicId(courseEntity.getCourseApi().getCoursePublicId());
            }
        }
    }
}
