package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodResponse;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodWebServiceDtoPeriodResponseMapper {

    PeriodWebServiceDtoPeriodResponseMapper INSTANCE = Mappers.getMapper(PeriodWebServiceDtoPeriodResponseMapper.class);

    @Mappings({
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "periodDto.academic.id", target = "periodFastDto.academicId")

    })
    PeriodResponse PeriodWebServiceDtoToPeriodResponse(PeriodWebServiceDto periodWebServiceDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceDto PeriodResponseToPeriodWebServiceDto(PeriodResponse periodResponse, @Context CycleAvoidingMappingContext context);

    List<PeriodResponse> PeriodWebServiceDtosToPeriodResponses(List<PeriodWebServiceDto> periodWebServiceDtos, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceDto> PeriodResponsesToPeriodWebServiceDtos(List<PeriodResponse> periodResponses, @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handlePeriodResponseDtoPeriodPublicId(PeriodWebServiceDto periodWebServiceDto, @MappingTarget PeriodResponse periodResponse) {
        periodResponse.setPeriodPublicId(PeriodWebServiceDto.getPeriodPublicId());
        if (PeriodWebServiceDto.getDeleteTs() != null) {
            periodResponse.getPeriodFastDto().setDeleteStatus(1L);
        }
    }*/
}
