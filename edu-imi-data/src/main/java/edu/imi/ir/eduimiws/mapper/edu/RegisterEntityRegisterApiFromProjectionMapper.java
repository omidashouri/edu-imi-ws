package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.RegisterApiEntity;
import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
/**
 * For Generating Register Api Public Id
 */
public interface RegisterEntityRegisterApiFromProjectionMapper {

    RegisterEntityRegisterApiFromProjectionMapper INSTANCE = Mappers.getMapper(RegisterEntityRegisterApiFromProjectionMapper.class);

//

    @Mappings({
            @Mapping(source = "period", target = "period"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "activityStatus", target = "registerActivityStatus"),
            @Mapping(source = "deleteStatus", target = "registerDeleteStatus"),
            @Mapping(source = "editDate", target = "registerEditDate"),
            @Mapping(source = "id", target = "registerId"),
            @Mapping(source = "", target = "registerPublicId"),
            @Mapping(source = "student", target = "student"),
            @Mapping(source = "studentId", target = "studentId")
    })
    @BeanMapping(ignoreByDefault = true)
    RegisterApiEntity toRegisterApi(RegisterEntity register, @Context CycleAvoidingMappingContext context);

    List<RegisterApiEntity> toRegisterApis(List<RegisterEntity> registers, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePublicIds(RegisterEntity register, @MappingTarget RegisterApiEntity registerApi) {

        registerApi.setRegister(register);

        registerApi.setCreateDateTs(new Timestamp(new Date().getTime()));

        registerApi.setRegisterPublicId(new PublicIdUtil().generateUniquePublicId());

        if (null != register.getDeleteStatus() && register.getDeleteStatus().equals(1L)) {
            registerApi.setDeleteDateTs(new Timestamp(new Date().getTime()));
        }

        if (register.getPeriod() != null) {
            if (!Hibernate.isInitialized(register.getPeriod().getPeriodApi())) {
                register.getPeriod().setPeriodApi(null);
            }
            if (register.getPeriod().getPeriodApi() != null) {
                registerApi
                        .setPeriodPublicId(register.getPeriod().getPeriodApi().getPeriodPublicId());
            }
        }

        if (register.getPeriod() == null && register.getPeriodId() != null) {
            PeriodEntity period = new PeriodEntity();
            period.setId(register.getPeriodId());
            registerApi.setPeriod(period);
        }

        if (register.getStudent() != null) {
            if (!Hibernate.isInitialized(register.getStudent().getStudentApi())) {
                register.getStudent().setStudentApi(null);
            }
            if (register.getStudent().getStudentApi() != null) {
                registerApi
                        .setStudentPublicId(register.getStudent().getStudentApi().getStudentPublicId());
            }
        }

        if (register.getStudent() == null && register.getStudentId() != null) {
            StudentEntity student = new StudentEntity();
            student.setId(register.getStudentId());
            registerApi.setStudent(student);
        }

    }


}
