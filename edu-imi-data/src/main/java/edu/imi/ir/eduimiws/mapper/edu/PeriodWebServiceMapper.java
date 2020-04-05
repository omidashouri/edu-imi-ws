package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodWebServiceMapper {
    PeriodWebServiceMapper INSTANCE = Mappers.getMapper(PeriodWebServiceMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "periodDto", target = "period"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteTs", target = "deleteTs"),
            @Mapping(source = "periodEditDate", target = "periodEditDate"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "description", target = "description")

    })
    PeriodWebServiceEntity PeriodWebServiceDtoToPeriodWebServiceEntity(PeriodWebServiceDto periodWebServiceDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceDto PeriodWebServiceEntityToPeriodWebServiceDto(PeriodWebServiceEntity periodWebServiceEntity, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceDto> PeriodWebServiceEntitiesToPeriodWebServiceDtos(List<PeriodWebServiceEntity> periodWebServiceEntities, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceEntity> PeriodWebServiceDtosToPeriodWebServiceEntities(List<PeriodWebServiceDto> periodWebServiceDtos, @Context CycleAvoidingMappingContext context);

}
