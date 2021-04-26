package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponse;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectResponseProjectDtoMapper {

    ProjectResponseProjectDtoMapper INSTANCE = Mappers.getMapper(ProjectResponseProjectDtoMapper.class);


//    accountPublicId, creatorPublicId, mainContractPublicId, offerPublicId
//    operationalPlanPublicId,

    @Mappings({
            @Mapping(source = "affectEfficiency", target = "affectEfficiency"),
            @Mapping(source = "benefit", target = "benefit"),
            @Mapping(source = "benefitAmount", target = "benefitAmount"),
            @Mapping(source = "budgetCofficient", target = "budgetCofficient"),
            @Mapping(source = "coordinateX", target = "coordinateX"),
            @Mapping(source = "coordinateY", target = "coordinateY"),
            @Mapping(source = "coordinateLat", target = "coordinateLat"),
            @Mapping(source = "coordinateLang", target = "coordinateLang"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "executerPublicId", target = "executerPublicId"),
            @Mapping(source = "endDatePlan", target = "endDatePlan"),
            @Mapping(source = "fileOldName", target = "fileOldName"),
            @Mapping(source = "fileNewName", target = "fileNewName"),
            @Mapping(source = "incomeIndicator", target = "incomeIndicator"),
            @Mapping(source = "improvePercent", target = "improvePercent"),
            @Mapping(source = "lastVersion", target = "lastVersion"),
            @Mapping(source = "lessonLearn", target = "lessonLearn"),
            @Mapping(source = "managerPublicId", target = "managerPublicId"),
            @Mapping(source = "motherProjectPublicId", target = "motherProjectPublicId"),
            @Mapping(source = "orgCostCodeId", target = "orgCostCodeId"),
            @Mapping(source = "projectTypePublicId", target = "projectTypePublicId"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectStatusId", target = "projectStatusId"),
            @Mapping(source = "projectRequestPublicId", target = "projectRequestPublicId"),
            @Mapping(source = "projectOperationType", target = "projectOperationType"),
            @Mapping(source = "projectBudget", target = "projectBudget"),
            @Mapping(source = "presentBenefitDescription", target = "presentBenefitDescription"),
            @Mapping(source = "planImprovementPercent", target = "planImprovementPercent"),
            @Mapping(source = "projectAdditionalInfoId", target = "projectAdditionalInfoId"),
            @Mapping(source = "previousVersionPublicId", target = "previousVersionPublicId"),
            @Mapping(source = "reportPatternUnit", target = "reportPatternUnit"),
            @Mapping(source = "reportPatternNumber", target = "reportPatternNumber"),
            @Mapping(source = "stageId", target = "stageId"),
            @Mapping(source = "salePresent", target = "salePresent"),
            @Mapping(source = "salePresentAmount", target = "salePresentAmount"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "startDatePlan", target = "startDatePlan"),
            @Mapping(source = "statusForTimeshit", target = "statusForTimeshit"),
            @Mapping(source = "supervisorId", target = "supervisorId"),
            @Mapping(source = "suspendReasonId", target = "suspendReasonId"),
            @Mapping(source = "taskScheduleConfirmed", target = "taskScheduleConfirmed"),
            @Mapping(source = "versionNumber", target = "versionNumber"),
            @Mapping(source = "weightPercent", target = "weightPercent")

    })
    @BeanMapping(ignoreByDefault = true)
    ProjectResponse toProjectResponse(ProjectDto projectDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProjectDto toProjectDto(ProjectResponse projectResponse, @Context CycleAvoidingMappingContext context);

    List<ProjectResponse> toProjectEntities(List<ProjectDto> ProjectDtos, @Context CycleAvoidingMappingContext context);

    List<ProjectDto> toProjectDtos(List<ProjectResponse> projectEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleProjectPublicIds(ProjectDto projectDto, @MappingTarget ProjectResponse projectResponse) {
        new PersistenceUtils().cleanFromProxyByReadMethod(projectDto);
    }

}
