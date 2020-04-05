package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodWebServicePeriodResponseDtoMapper {

    PeriodWebServicePeriodResponseDtoMapper INSTANCE = Mappers.getMapper(PeriodWebServicePeriodResponseDtoMapper.class);

    @Mappings({
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "periodId", target = "periodFastDto.periodId"),
            @Mapping(source = "periodEditDate", target = "periodFastDto.editDate"),
            @Mapping(source = "canRegisterOnline", target = "periodFastDto.canRegisterOnline")

    })
    PeriodResponse PeriodWebServiceEntityToPeriodFastDto(PeriodWebServiceEntity periodWebServiceEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceEntity PeriodResponseDtoToPeriodWebServiceEntity(PeriodResponse periodResponse, @Context CycleAvoidingMappingContext context);

    List<PeriodResponse> PeriodWebServiceEntitiesToPeriodResponseDtos(List<PeriodWebServiceEntity> periodWebServiceEntities, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceEntity> PeriodResponseDtosToPeriodWebServiceEntites(List<PeriodResponse> periodResponses, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePeriodResponseDtoPeriodPublicId(PeriodWebServiceEntity periodWebServiceEntity, @MappingTarget PeriodResponse periodResponse) {
        periodResponse.setPeriodPublicId(periodWebServiceEntity.getPeriodPublicId());
        if (periodWebServiceEntity.getDeleteTs() != null) {
            periodResponse.getPeriodFastDto().setDeleteStatus(1L);
        }
    }


}
