package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * For Generating Period Api Public Id
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface PeriodEntityPeriodApiFromProjectionMapper {

    PeriodEntityPeriodApiFromProjectionMapper INSTANCE = Mappers.
            getMapper(PeriodEntityPeriodApiFromProjectionMapper.class);

    @Mappings({
            @Mapping(source = "fieldId", target = "fieldId"),
            @Mapping(source = "id", target = "periodId"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "editDate", target = "periodEditDate")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodApiEntity toPeriodApi(PeriodEntity period, @Context CycleAvoidingMappingContext context);

    List<PeriodApiEntity> toPeriodApis(List<PeriodEntity> periods, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePublicIds(PeriodEntity period, @MappingTarget PeriodApiEntity periodApi) {

        periodApi.setPeriod(period);

        periodApi.setCreateDateTs(new Timestamp(new Date().getTime()));

        periodApi.setPeriodPublicId(new PublicIdUtil().generateUniquePublicId());

        if (null != period.getActivityStatus()) {
            periodApi.setCanRegisterOnline(period.getCanRegisterOnline());
        }

        if (period.getField() != null) {
            if (!Hibernate.isInitialized(period.getField().getFieldApi())) {
                period.getField().setFieldApi(null);
            }
            if (period.getField().getFieldApi() != null) {
                periodApi.setFieldPublicId(
                        period.getField().getFieldApi().getFieldPublicId());
            }
        }

        if (period.getField() == null && period.getFieldId() != null) {
            FieldEntity field = new FieldEntity();
            field.setId(period.getFieldId());
            periodApi.setField(field);
        }

    }
}
