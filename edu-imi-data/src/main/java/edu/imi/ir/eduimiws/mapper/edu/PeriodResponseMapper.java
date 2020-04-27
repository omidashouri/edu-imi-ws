package edu.imi.ir.eduimiws.mapper.edu;



import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodResponseMapper {

    PeriodResponseMapper INSTANCE = Mappers.getMapper(PeriodResponseMapper.class);

    @Mappings({
            @Mapping(source = "periodApi.periodPublicId", target = "periodPublicId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "executer.personApiEntity.personPublicId", target = "executorPublicId"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "holdingLanguage", target = "holdingLanguage"),
            @Mapping(source = "maxCapacity", target = "maxCapacity"),
            @Mapping(source = "holdingType", target = "holdingType"),
            @Mapping(source = "minCapacity", target = "minCapacity"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "type", target = "type")

    })
    PeriodResponse PeriodEntityToPeriodResponse(PeriodEntity periodEntity,
                                                @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodEntity PeriodResponseToPeriodEntity(PeriodResponse periodResponse,
                                              @Context CycleAvoidingMappingContext context);

    List<PeriodResponse> PeriodEntitiesToPeriodResponses(List<PeriodEntity> periodEntities,
                                                         @Context CycleAvoidingMappingContext context);

    List<PeriodEntity> PeriodResponsesToPeriodEntities(List<PeriodResponse> periodResponses,
                                                       @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePeriodResponseExecutorFullName(PeriodEntity periodEntity,
                                                      @MappingTarget PeriodResponse periodResponse) {

        if(!Hibernate.isInitialized(periodEntity.getExecuter())) {
            periodEntity.setExecuter(null);
        }

        if(periodEntity.getExecuter()!=null) {
            periodResponse
                    .setExecutorFullName(
                            periodEntity.getExecuter().getFirstName()
                                    + ' ' +
                                    periodEntity.getExecuter().getLastName());
        }
    }
}
