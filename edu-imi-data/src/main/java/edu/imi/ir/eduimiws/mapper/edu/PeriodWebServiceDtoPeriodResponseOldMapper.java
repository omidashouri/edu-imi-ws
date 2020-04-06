package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseOld;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface PeriodWebServiceDtoPeriodResponseOldMapper {

    PeriodWebServiceDtoPeriodResponseOldMapper INSTANCE = Mappers.getMapper(PeriodWebServiceDtoPeriodResponseOldMapper.class);

    @Mappings({
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "periodDto", target = "periodFastDto")

    })
    PeriodResponseOld PeriodWebServiceDtoToPeriodResponse(PeriodWebServiceDto periodWebServiceDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodWebServiceDto PeriodResponseToPeriodWebServiceDto(PeriodResponseOld periodResponseOld, @Context CycleAvoidingMappingContext context);

    List<PeriodResponseOld> PeriodWebServiceDtosToPeriodResponses(List<PeriodWebServiceDto> periodWebServiceDtos, @Context CycleAvoidingMappingContext context);

    List<PeriodWebServiceDto> PeriodResponsesToPeriodWebServiceDtos(List<PeriodResponseOld> periodRespons, @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handlePeriodResponseDtoPeriodPublicId(PeriodWebServiceDto periodWebServiceDto, @MappingTarget PeriodResponse periodResponse) {
        periodResponse.setPeriodPublicId(PeriodWebServiceDto.getPeriodPublicId());
        if (PeriodWebServiceDto.getDeleteTs() != null) {
            periodResponse.getPeriodFastDto().setDeleteStatus(1L);
        }
    }*/
}
