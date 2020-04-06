package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodOnlyMapperOld {

    PeriodOnlyMapperOld INSTANCE = Mappers.getMapper(PeriodOnlyMapperOld.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "editDate", target = "editDate")
    })
    PeriodEntity PeriodOnlyToPeriodEntity(PeriodOnly periodOnly, @Context CycleAvoidingMappingContext context);

    List<PeriodEntity> PeriodOnliesToPeriodEntities(List<PeriodOnly> periodOnlies, @Context CycleAvoidingMappingContext context);
}
