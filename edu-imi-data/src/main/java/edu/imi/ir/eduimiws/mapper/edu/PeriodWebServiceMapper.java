package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodWebServiceMapper {
    PeriodWebServiceMapper INSTANCE = Mappers.getMapper(PeriodWebServiceMapper.class);

    PeriodWebServiceEntity PeriodWebServiceDtoToPeriodWebServiceEntity(PeriodWebServiceDto periodWebServiceDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceDto PeriodWebServiceEntityToPeriodWebServiceDto(PeriodWebServiceEntity periodWebServiceEntity, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceDto> PeriodWebServiceEntitiesToPeriodWebServiceDtos(List<PeriodWebServiceEntity> periodWebServiceEntities, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceEntity> PeriodWebServiceDtosToPeriodWebServiceEntities(List<PeriodWebServiceDto> periodWebServiceDtos, @Context CycleAvoidingMappingContext context);

}
