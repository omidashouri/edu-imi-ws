package edu.imi.ir.eduimiws.mapper.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.GetVersionResponseDto;
import edu.imi.ir.eduimiws.models.sabtahval.GetVersionResponse;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.StringByteArrayAdapter;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetVersionResponseMapper {

    GetVersionResponseMapper INSTANCE = Mappers.getMapper(GetVersionResponseMapper.class);

    @Mappings({
            @Mapping(source = "return", target = "returnValue")
    })
    @BeanMapping(ignoreByDefault = true)
    GetVersionResponseDto toGetVersionResponseDto(GetVersionResponse getVersionResponse, @Context CycleAvoidingMappingContext context) throws Exception;

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    GetVersionResponse toGetVersionResponse(GetVersionResponseDto getVersionResponseDto, @Context CycleAvoidingMappingContext context);

    List<GetVersionResponse> toGetVersionResponse(List<GetVersionResponseDto> GetVersionResponseDtos, @Context CycleAvoidingMappingContext context);

    List<GetVersionResponseDto> toGetVersionResponseDtos(List<GetVersionResponse> getVersionResponses, @Context CycleAvoidingMappingContext context) throws Exception;

}
