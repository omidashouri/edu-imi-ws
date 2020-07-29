package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodOnlyMapper {

    PeriodOnlyMapper INSTANCE = Mappers.getMapper(PeriodOnlyMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fieldId", target = "fieldId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "editDate", target = "editDate")
    })
    PeriodEntity PeriodOnlyToPeriodEntity(PeriodOnly periodOnly,
                                          @Context CycleAvoidingMappingContext context);

    List<PeriodEntity> PeriodOnliesToPeriodEntities(List<PeriodOnly> periodOnlies,
                                                    @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleFieldEntity(PeriodOnly periodOnly,
                                   @MappingTarget PeriodEntity periodEntity) {

        if (periodOnly.getFieldId() != null) {
            FieldEntity field = new FieldEntity();
            field.setId(periodOnly.getFieldId());
            periodEntity.setField(field);
        }
    }
}
