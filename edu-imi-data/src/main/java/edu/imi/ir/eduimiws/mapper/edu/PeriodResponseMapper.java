package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodResponseDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodResponseMapper {

    PeriodResponseMapper INSTANCE = Mappers.getMapper(PeriodResponseMapper.class);

    PeriodResponse PeriodResponseDtoToPeriodResponse(PeriodResponseDto periodResponseDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodResponseDto PeriodResponseToPeriodResponseDto(PeriodResponse periodResponse, @Context CycleAvoidingMappingContext context);

    List<PeriodResponseDto> PeriodResponsesToPeriodResponseDtoes(List<PeriodResponse> periodResponses, @Context CycleAvoidingMappingContext context);

    List<PeriodResponse> PeriodResponseDtoesToPeriodResponses(List<PeriodResponseDto> periodResponseDtos, @Context CycleAvoidingMappingContext context);

}
