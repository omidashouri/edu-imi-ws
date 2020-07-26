package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import edu.imi.ir.eduimiws.models.projections.edu.LevelProjection;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface LevelProjectionLevelDtoMapper {

    LevelProjectionLevelDtoMapper INSTANCE =
            Mappers.getMapper(LevelProjectionLevelDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "levelPublicId", target = "levelPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    LevelDto toLevelDto(LevelProjection levelProjection, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    List<LevelDto> toLevelDtos(List<LevelProjection> levelProjections, @Context CycleAvoidingMappingContext context);

}
