package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import edu.imi.ir.eduimiws.models.response.edu.EduCategoryResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduCategoryResponseEduCategoryDtoMapper {

    EduCategoryResponseEduCategoryDtoMapper INSTANCE = Mappers
            .getMapper(EduCategoryResponseEduCategoryDtoMapper.class);

    @Mappings({
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "title", target = "title")
    })
    @BeanMapping(ignoreByDefault = true)
    EduCategoryResponse toEduCategoryResponse(EduCategoryDto eduCategoryDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    EduCategoryDto toEduCategoryDto(EduCategoryResponse eduCategoryResponse
            , @Context CycleAvoidingMappingContext context);

    List<EduCategoryResponse> toEduCategoryResponses(List<EduCategoryDto> eduCategoryDtos,
                                                  @Context CycleAvoidingMappingContext context);

    List<EduCategoryDto> toEduCategoryDtos(List<EduCategoryResponse> eduCategoryResponses,
                                           @Context CycleAvoidingMappingContext context);
}
