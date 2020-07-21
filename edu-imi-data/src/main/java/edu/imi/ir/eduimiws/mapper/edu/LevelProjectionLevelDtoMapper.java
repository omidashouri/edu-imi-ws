package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import edu.imi.ir.eduimiws.models.projections.edu.LevelProjection;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LevelProjectionLevelDtoMapper {

    LevelProjectionLevelDtoMapper INSTANCE = Mappers
            .getMapper(LevelProjectionLevelDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "levelPublicId", target = "levelPublicId")
    })
    LevelDto toLevelDto(LevelProjection levelProjection, @Context CycleAvoidingMappingContext context);

    List<LevelDto> toLevelDtos(List<LevelProjection> levelProjections, @Context CycleAvoidingMappingContext context);

}
