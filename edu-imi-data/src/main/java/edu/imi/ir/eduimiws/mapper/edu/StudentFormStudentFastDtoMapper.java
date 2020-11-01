package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.StudentFastDto;
import edu.imi.ir.eduimiws.models.request.edu.v1.StudentForm;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StudentFormStudentFastDtoMapper {

    StudentFormStudentFastDtoMapper INSTANCE = Mappers.getMapper(StudentFormStudentFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "personPublicId", target = "personPublicId"),
            @Mapping(source = "studentPublicId", target = "studentPublicId")

    })
    @BeanMapping(ignoreByDefault = true)
    StudentFastDto toStudentFastDto(StudentForm studentForm, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    StudentForm toStudentForm(StudentFastDto studentFastDto, @Context CycleAvoidingMappingContext context);

    List<StudentForm> toStudentForms(List<StudentFastDto> studentFastDtos, @Context CycleAvoidingMappingContext context);

    List<StudentFastDto> toStudentFastDtos(List<StudentForm> studentForms, @Context CycleAvoidingMappingContext context);
}
