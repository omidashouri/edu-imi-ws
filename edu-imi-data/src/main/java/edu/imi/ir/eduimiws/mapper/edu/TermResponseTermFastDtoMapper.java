package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermFastDto;
import edu.imi.ir.eduimiws.models.response.edu.TermResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermResponseTermFastDtoMapper {

    TermResponseTermFastDtoMapper INSTANCE = Mappers.getMapper(TermResponseTermFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "termPublicId", target = "termPublicId"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "currentTerm", target = "currentTerm"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "termName", target = "termName"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "year", target = "year")
    })
    @BeanMapping(ignoreByDefault = true)
    TermFastDto toTermFastDto(TermResponse termEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermResponse toTermResponse(TermFastDto termFastDto
            , @Context CycleAvoidingMappingContext context);

    List<TermResponse> toTermEntities(List<TermFastDto> termFastDtos,
                                      @Context CycleAvoidingMappingContext context);

    List<TermFastDto> toTermFastDtos(List<TermResponse> termEntities,
                                     @Context CycleAvoidingMappingContext context);
}
