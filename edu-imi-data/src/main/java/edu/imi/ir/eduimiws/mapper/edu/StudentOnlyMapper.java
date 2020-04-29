package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.edu.StudentOnly;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentOnlyMapper {

    PeriodOnlyMapper INSTANCE = Mappers.getMapper(PeriodOnlyMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "personId", target = "personId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "editDate", target = "editDate")
    })
    StudentEntity toStudentEntity(StudentOnly studentOnly, @Context CycleAvoidingMappingContext context);

    List<StudentEntity> toStudentEntities(List<StudentOnly> studentOnlies, @Context CycleAvoidingMappingContext context);
}
