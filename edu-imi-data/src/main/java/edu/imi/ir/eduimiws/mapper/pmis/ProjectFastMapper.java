package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectFastMapper {

//    accountId, creator,  do not have join in database

    @Named("toProjectDto")
    @Mappings({
            @Mapping(source = "accountId", target = "accountId"),
            @Mapping(source = "affectEfficiency", target = "affectEfficiency"),
            @Mapping(source = "benefit", target = "benefit"),
            @Mapping(source = "benefitAmount", target = "benefitAmount"),
            @Mapping(source = "budgetCofficient", target = "budgetCofficient"),
            @Mapping(source = "coordinateLang", target = "coordinateLang"),
            @Mapping(source = "coordinateX", target = "coordinateX"),
            @Mapping(source = "coordinateY", target = "coordinateY"),
            @Mapping(source = "coordinateLat", target = "coordinateLat"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator", target = "creator"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "endDatePlan", target = "endDatePlan"),
            @Mapping(source = "fileNewName", target = "fileNewName"),
            @Mapping(source = "fileOldName", target = "fileOldName"),
            @Mapping(source = "improvePercent", target = "improvePercent"),
            @Mapping(source = "incomeIndicator", target = "incomeIndicator"),
            @Mapping(source = "lastVersion", target = "lastVersion"),
            @Mapping(source = "lessonLearn", target = "lessonLearn"),
            @Mapping(source = "mainContractId", target = "mainContractId"),
            @Mapping(source = "motherProject.id", target = "motherProjectId"),
            @Mapping(source = "offerId", target = "offerId"),
            @Mapping(source = "operationalPlanId", target = "operationalPlanId"),
            @Mapping(source = "orgCostCodeId", target = "orgCostCodeId"),
            @Mapping(source = "planImprovementPercent", target = "planImprovementPercent"),
            @Mapping(source = "presentBenefitDescription", target = "presentBenefitDescription"),
            @Mapping(source = "previousVersion", target = "previousVersion"),
            @Mapping(source = "projectAdditionalInfoId", target = "projectAdditionalInfoId"),
            @Mapping(source = "projectBudget", target = "projectBudget"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "projectOperationType", target = "projectOperationType"),
            @Mapping(source = "projectStatusId", target = "projectStatusId"),
            @Mapping(source = "reportPatternNumber", target = "reportPatternNumber"),
            @Mapping(source = "reportPatternUnit", target = "reportPatternUnit"),
            @Mapping(source = "salePresent", target = "salePresent"),
            @Mapping(source = "stageId", target = "stageId"),
            @Mapping(source = "salePresentAmount", target = "salePresentAmount"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "startDatePlan", target = "startDatePlan"),
            @Mapping(source = "statusForTimeshit", target = "statusForTimeshit"),
            @Mapping(source = "supervisorId", target = "supervisorId"),
            @Mapping(source = "suspendReasonId", target = "suspendReasonId"),
            @Mapping(source = "taskScheduleConfirmed", target = "taskScheduleConfirmed"),
            @Mapping(source = "versionNumber", target = "versionNumber"),
            @Mapping(source = "weightPercent", target = "weightPercent"),
            @Mapping(source = "projectApi.projectPublicId", target = "projectPublicId"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectApi.projectRequestPublicId", target = "projectRequestPublicId"),
            @Mapping(source = "requestId", target = "requestId"),
            @Mapping(source = "projectApi.executorPublicId", target = "executerPublicId"),
            @Mapping(source = "projectApi.managerPublicId", target = "managerPublicId"),
            @Mapping(source = "projectApi.projectTypePublicId", target = "projectTypePublicId")

    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDto toProjectDto(ProjectEntity projectEntity, @Context CycleAvoidingMappingContext context);

    @Named("toProjectEntity")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProjectEntity toProjectEntity(ProjectDto projectDto, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toProjectEntity")
    List<ProjectEntity> toProjectEntities(List<ProjectDto> ProjectDtos, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toProjectDto")
    List<ProjectDto> toProjectDtos(List<ProjectEntity> projectEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleProjectPublicIds(ProjectEntity projectEntity, @MappingTarget ProjectDto projectDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(projectEntity);
    }
}
