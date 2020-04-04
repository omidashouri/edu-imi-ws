package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PersonWebServiceDto;
import edu.imi.ir.eduimiws.models.dto.crm.UserContactFastDto;
import edu.imi.ir.eduimiws.models.dto.crm.UserContactResponseDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodResponseDto;
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
    PeriodResponseDto PeriodWebServiceEntityToPeriodFastDto(PeriodWebServiceEntity periodWebServiceEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceEntity PeriodResponseDtoToPeriodWebServiceEntity(PeriodResponseDto periodResponseDto, @Context CycleAvoidingMappingContext context);

    List<PeriodResponseDto> PeriodWebServiceEntitiesToPeriodResponseDtos(List<PeriodWebServiceEntity> periodWebServiceEntities, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceEntity> PeriodResponseDtosToPeriodWebServiceEntites(List<PeriodResponseDto> periodResponseDtos, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePeriodResponseDtoPeriodPublicId(PeriodWebServiceEntity periodWebServiceEntity, @MappingTarget PeriodResponseDto periodResponseDto) {
        periodResponseDto.setPeriodPublicId(periodWebServiceEntity.getPeriodPublicId());
        if (periodWebServiceEntity.getDeleteTs() != null) {
            periodResponseDto.getPeriodFastDto().setDeleteStatus(1L);
        }
    }


}
