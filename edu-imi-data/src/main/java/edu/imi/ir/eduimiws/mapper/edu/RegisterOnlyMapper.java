package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.edu.RegisterOnly;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterOnlyMapper {

    RegisterOnlyMapper INSTANCE = Mappers.getMapper(RegisterOnlyMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "studentId", target = "studentId"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "editDate", target = "editDate")
    })
    RegisterEntity toRegisterEntity(RegisterOnly registerOnly, @Context CycleAvoidingMappingContext context);

    List<RegisterEntity> toRegisterEntities(List<RegisterOnly> registerOnlies, @Context CycleAvoidingMappingContext context);
}
