package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodResponseDto;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodResponseMapper {

    PeriodResponseMapper INSTANCE = Mappers.getMapper(PeriodResponseMapper.class);

    edu.imi.ir.eduimiws.models.response.edu.PeriodResponse PeriodResponseDtoToPeriodResponse(PeriodResponseDto periodResponseDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodResponseDto PeriodResponseToPeriodResponseDto(edu.imi.ir.eduimiws.models.response.edu.PeriodResponse periodResponse, @Context CycleAvoidingMappingContext context);

    List<PeriodResponseDto> PeriodResponsesToPeriodResponseDtoes(List<edu.imi.ir.eduimiws.models.response.edu.PeriodResponse> periodResponses, @Context CycleAvoidingMappingContext context);

    List<edu.imi.ir.eduimiws.models.response.edu.PeriodResponse> PeriodResponseDtoesToPeriodResponses(List<PeriodResponseDto> periodResponsDtos, @Context CycleAvoidingMappingContext context);

}
