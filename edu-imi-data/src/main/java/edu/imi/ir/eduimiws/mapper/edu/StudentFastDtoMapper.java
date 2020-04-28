package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.StudentFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentFastDtoMapper {

    StudentFastDtoMapper INSTANCE = Mappers.getMapper(StudentFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "studentApi.studentPublicId", target = "studentPublicId"),
            @Mapping(source = "person.personApiEntity.personPublicId", target = "personPublicId"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "creatorPublicId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode")

    })
    @BeanMapping(ignoreByDefault = true)
    StudentFastDto toStudentFastDto(StudentEntity studentEntity, @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    StudentEntity toStudentEntity(StudentFastDto studentFastDto, @Context CycleAvoidingMappingContext context);

    List<StudentEntity> toStudentEntities(List<StudentFastDto> studentFastDtos, @Context CycleAvoidingMappingContext context);

    List<StudentFastDto> toStudentFastDtos(List<StudentEntity> studentEntities, @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handleStudentResponsePersonFullName(StudentEntity studentEntity, @MappingTarget StudentFastDto studentFastDto) {

        if(!Hibernate.isInitialized(studentEntity.getPerson())) {
            studentEntity.setPerson(null);
        }

        if(studentEntity.getPerson()!=null) {
            studentFastDto
                    .setPersonFullName(
                            studentEntity.getPerson().getFirstName()
                                    + ' ' +
                                    studentEntity.getPerson().getLastName());
        }
    }*/
}
