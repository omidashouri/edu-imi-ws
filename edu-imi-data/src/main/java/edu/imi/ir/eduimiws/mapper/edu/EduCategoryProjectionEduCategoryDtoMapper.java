package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import edu.imi.ir.eduimiws.models.projections.edu.EduCategoryProjection;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduCategoryProjectionEduCategoryDtoMapper {

    EduCategoryProjectionEduCategoryDtoMapper INSTANCE = Mappers.getMapper(EduCategoryProjectionEduCategoryDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId")
    })
    EduCategoryDto toEduCategoryDto(EduCategoryProjection eduCategoryProjection, @Context CycleAvoidingMappingContext context);

    List<EduCategoryDto> toEduCategoryDtos(List<EduCategoryProjection> eduCategoryProjections, @Context CycleAvoidingMappingContext context);

}
