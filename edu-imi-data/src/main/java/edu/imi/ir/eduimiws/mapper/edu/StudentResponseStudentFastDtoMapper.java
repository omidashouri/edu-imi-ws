package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.StudentFastDto;
import edu.imi.ir.eduimiws.models.response.edu.StudentResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentResponseStudentFastDtoMapper {

    StudentResponseStudentFastDtoMapper INSTANCE = Mappers.getMapper(StudentResponseStudentFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "studentPublicId", target = "studentPublicId"),
            @Mapping(source = "personPublicId", target = "userPublicId"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode")
    })
    @BeanMapping(ignoreByDefault = true)
    StudentResponse toStudentResponse(StudentFastDto StudentFastDto , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    StudentFastDto toStudentFastDto(StudentResponse StudentResponse, @Context CycleAvoidingMappingContext context);

    List<StudentResponse> toStudentResponses(List<StudentFastDto> StudentFastDtos, @Context CycleAvoidingMappingContext context);

    List<StudentFastDto> toStudentFastDtos(List<StudentResponse> StudentResponses, @Context CycleAvoidingMappingContext context);

}
