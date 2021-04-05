package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.AccountApiMapper;
import edu.imi.ir.eduimiws.models.projections.edu.RegisterOnly;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RegisterOnlyMapper {

    RegisterOnlyMapper INSTANCE = Mappers.getMapper(RegisterOnlyMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "studentId", target = "studentId"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "registerDate", target = "registerDate")
    })
    RegisterEntity toRegisterEntity(RegisterOnly registerOnly, @Context CycleAvoidingMappingContext context);

    List<RegisterEntity> toRegisterEntities(List<RegisterOnly> registerOnlies, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePeriodStudentEntity(RegisterOnly registerOnly, @MappingTarget RegisterEntity registerEntity) {

        if (registerOnly.getPeriodId() != null) {
            PeriodEntity period = new PeriodEntity();
            period.setId(registerOnly.getPeriodId());
            registerEntity.setPeriod(period);
        }

        if (registerOnly.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(registerOnly.getStudentId());
            registerEntity.setStudent(student);
        }
    }
}
