package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import edu.imi.ir.eduimiws.models.response.edu.LevelResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LevelResponseLevelDtoMapper {

    LevelResponseLevelDtoMapper INSTANCE = Mappers
            .getMapper(LevelResponseLevelDtoMapper.class);

    @Mappings({
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "paymentType", target = "paymentType"),
            @Mapping(source = "termicStatus", target = "termicStatus"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "certTitle", target = "certTitle"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate")
    })
    @BeanMapping(ignoreByDefault = true)
    LevelResponse toLevelResponse(LevelDto levelDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    LevelDto toLevelDto(LevelResponse levelResponse
            , @Context CycleAvoidingMappingContext context);

    List<LevelResponse> toLevelResponses(List<LevelDto> levelDtos,
                                                     @Context CycleAvoidingMappingContext context);

    List<LevelDto> toleveDtos(List<LevelResponse> levelResponses,
                                           @Context CycleAvoidingMappingContext context);
}
