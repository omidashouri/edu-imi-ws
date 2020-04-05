package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodWebServiceFastDtoMapper {

    PeriodWebServiceFastDtoMapper INSTANCE = Mappers.getMapper(PeriodWebServiceFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "periodEditDate", target = "periodEditDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteTs", target = "deleteTs")
    })
    PeriodWebServiceEntity PeriodWebServiceFastDtoToPeriodWebServiceEntity(PeriodWebServiceFastDto periodWebServiceFastDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceFastDto PeriodWebServiceEntityToPeriodWebServiceFastDto(PeriodWebServiceEntity periodWebServiceEntity, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceFastDto> PeriodWebServiceEntitiesToPeriodWebServiceFastDtos(List<PeriodWebServiceEntity> periodWebServiceEntities, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceEntity> PeriodWebServiceFastDtosToPeriodWebServiceEntities(List<PeriodWebServiceFastDto> periodWebServiceFastDtos, @Context CycleAvoidingMappingContext context);


}
