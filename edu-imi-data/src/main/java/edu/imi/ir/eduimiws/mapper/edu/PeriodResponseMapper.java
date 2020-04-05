package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodResponse;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodResponseMapper {

    PeriodResponseMapper INSTANCE = Mappers.getMapper(PeriodResponseMapper.class);

    edu.imi.ir.eduimiws.models.response.edu.PeriodResponse PeriodResponseDtoToPeriodResponse(PeriodResponse periodResponse, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodResponse PeriodResponseToPeriodResponseDto(edu.imi.ir.eduimiws.models.response.edu.PeriodResponse periodResponse, @Context CycleAvoidingMappingContext context);

    List<PeriodResponse> PeriodResponsesToPeriodResponseDtoes(List<edu.imi.ir.eduimiws.models.response.edu.PeriodResponse> periodResponses, @Context CycleAvoidingMappingContext context);

    List<edu.imi.ir.eduimiws.models.response.edu.PeriodResponse> PeriodResponseDtoesToPeriodResponses(List<PeriodResponse> periodResponses, @Context CycleAvoidingMappingContext context);

}
