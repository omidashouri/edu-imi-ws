package edu.imi.ir.eduimiws.mapper.sabtahval;


import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.GetVersionResponseDto;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamVersionResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EstelamVersionResponseMapper {

    @Mappings({
            @Mapping(source = "versionNumber", target = "returnValue")
    })
    @BeanMapping(ignoreByDefault = true)
    GetVersionResponseDto toGetVersionResponseDto(EstelamVersionResponse estelamVersionResponse, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    EstelamVersionResponse toEstelamVersionResponse(GetVersionResponseDto getVersionResponseDto, @Context CycleAvoidingMappingContext context);

    List<EstelamVersionResponse> toEstelamVersionResponse(List<GetVersionResponseDto> getVersionResponseDtos, @Context CycleAvoidingMappingContext context);

    List<GetVersionResponseDto> toGetVersionResponseDtos(List<EstelamVersionResponse> estelamVersionResponses, @Context CycleAvoidingMappingContext context);
}
