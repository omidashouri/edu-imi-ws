package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface PeriodFastDtoMapper {

    PeriodFastDtoMapper INSTANCE = Mappers.getMapper(PeriodFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "periodApi.periodPublicId", target = "periodPublicId"),
            @Mapping(source = "periodApi.fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "fieldId", target = "fieldId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "endDate", target = "endDate"),
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
    @BeanMapping(ignoreByDefault = true)
    PeriodFastDto toPeriodFastDto(PeriodEntity periodEntity, @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodEntity toPeriodEntity(PeriodFastDto periodFastDto, @Context CycleAvoidingMappingContext context);

    List<PeriodEntity> toPeriodEntities(List<PeriodFastDto> periodFastDtos, @Context CycleAvoidingMappingContext context);

    List<PeriodFastDto> toPeriodFastDtos(List<PeriodEntity> periodEntities, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePeriodResponseExecutorFullName(PeriodEntity periodEntity, @MappingTarget PeriodFastDto periodFastDto) {

        if (!Hibernate.isInitialized(periodEntity.getExecuter())) {
            periodEntity.setExecuter(null);
        }
        if (periodEntity.getExecuter() != null) {

            periodFastDto
                    .setExecutorFullName(
                            periodEntity.getExecuter().getFirstName()
                                    + ' ' +
                                    periodEntity.getExecuter().getLastName());

            if (!Hibernate.isInitialized(periodEntity.getExecuter().getPersonApiEntity())) {
                periodEntity.getExecuter().setPersonApiEntity(null);
            }
            if (periodEntity.getExecuter().getPersonApiEntity() != null) {
                periodFastDto.setExecutorPublicId(
                        periodEntity.getExecuter().getPersonApiEntity().getPersonPublicId()
                );
            }
        }

//  for Descriptive (begin) :
        if (!Hibernate.isInitialized(periodEntity.getField())) {
            periodEntity.setField(null);
        }
        if (periodEntity.getField() != null) {

            periodFastDto.setFieldFName(periodEntity.getField().getFname());
            periodFastDto.setFieldLName(periodEntity.getField().getLname());

            if (!Hibernate.isInitialized(periodEntity.getField().getEduCategory())) {
                periodEntity.getField().setEduCategory(null);
            }
            if (periodEntity.getField().getEduCategory() != null) {
                periodFastDto.setEduCategoryId(periodEntity.getField().getEduCategory().getId());
                periodFastDto.setEduCategoryTitle(periodEntity.getField().getEduCategory().getTitle());

                if (!Hibernate.isInitialized(periodEntity.getField().getEduCategory().getEduCategoryApi())) {
                    periodEntity.getField().getEduCategory().setEduCategoryApi(null);
                }
                if (periodEntity.getField().getEduCategory().getEduCategoryApi() != null) {
                    periodFastDto.setEduCategoryPublicId(
                            periodEntity.getField().getEduCategory().getEduCategoryApi().getEduCategoryPublicId());
                }
            }

            if (!Hibernate.isInitialized(periodEntity.getField().getLevel())) {
                periodEntity.getField().setLevel(null);
            }
            if (periodEntity.getField().getLevel() != null) {
                periodFastDto.setLevelId(periodEntity.getField().getLevel().getId());
                periodFastDto.setLevelDescription(periodEntity.getField().getLevel().getDescription());

                if (!Hibernate.isInitialized(periodEntity.getField().getLevel().getLevelApi())) {
                    periodEntity.getField().getLevel().setLevelApi(null);
                }
                if (periodEntity.getField().getLevel().getLevelApi() != null) {
                    periodFastDto.setLevelPublicId(
                            periodEntity.getField().getLevel().getLevelApi().getLevelPublicId());
                }
            }
        }
//  for Descriptive (end) :
    }
}
