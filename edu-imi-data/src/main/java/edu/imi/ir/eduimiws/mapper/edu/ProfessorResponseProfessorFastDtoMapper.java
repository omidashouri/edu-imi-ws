package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.ProfessorFastDto;
import edu.imi.ir.eduimiws.models.response.edu.ProfessorResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProfessorResponseProfessorFastDtoMapper {

    ProfessorResponseProfessorFastDtoMapper INSTANCE = Mappers
            .getMapper(ProfessorResponseProfessorFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "acceptedHour", target = "acceptedHour"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "dutyHour", target = "dutyHour"),
            @Mapping(source = "dutyHourMonth", target = "dutyHourMonth"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "finalScore", target = "finalScore"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "isInner", target = "isInner"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "professorType", target = "professorType"),
            @Mapping(source = "professorPublicId", target = "professorPublicId"),
            @Mapping(source = "personPublicId", target = "personPublicId"),
            @Mapping(source = "personName", target = "personName"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "startYear", target = "startYear")
    })
    @BeanMapping(ignoreByDefault = true)
    ProfessorResponse toProfessorResponse(ProfessorFastDto professorFastDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProfessorFastDto toProfessorFastDto(ProfessorResponse professorResponse,
                                        @Context CycleAvoidingMappingContext context);

    List<ProfessorFastDto> toProfessorFastDtos(List<ProfessorResponse> professorResponses,
                                               @Context CycleAvoidingMappingContext context);

    List<ProfessorResponse> toProfessorResponses(List<ProfessorFastDto> professorFastDtos,
                                                 @Context CycleAvoidingMappingContext context);
}
