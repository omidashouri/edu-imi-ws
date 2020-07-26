package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import edu.imi.ir.eduimiws.models.projections.edu.EduCategoryProjection;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface EduCategoryProjectionEduCategoryDtoMapper {

    EduCategoryProjectionEduCategoryDtoMapper INSTANCE =
            Mappers.getMapper(EduCategoryProjectionEduCategoryDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    EduCategoryDto toEduCategoryDto(EduCategoryProjection eduCategoryProjection, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    List<EduCategoryDto> toEduCategoryDtos(List<EduCategoryProjection> eduCategoryProjections, @Context CycleAvoidingMappingContext context);

}
