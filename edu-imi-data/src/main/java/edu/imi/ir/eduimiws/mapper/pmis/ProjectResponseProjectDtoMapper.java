package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponse;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ConvertorUtil.class},       //use for @MappingUtil
        imports = {ConvertorUtil.class},    //use for @Context or Java Expression
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectResponseProjectDtoMapper {

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
//    @InheritInverseConfiguration
    ProjectDto toProjectDto(ProjectResponse projectResponse, @Context CycleAvoidingMappingContext context);

    List<ProjectResponse> toProjectEntities(List<ProjectDto> ProjectDtos, @Context CycleAvoidingMappingContext context);

    List<ProjectDto> toProjectDtos(List<ProjectResponse> projectEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleProjectPublicIds(ProjectDto projectDto, @MappingTarget ProjectResponse projectResponse) {
        new PersistenceUtils().cleanFromProxyByReadMethod(projectDto);
    }

    default ProjectResponse characterEncodingPersianForProjectName(ProjectResponse source, @Context ConvertorUtil convertorUtil) {
        source.setProjectName(convertorUtil.characterEncodingStringRequestToPersian.apply(source.getProjectName()));
        return source;
    }

    @Mappings({
            @Mapping(target = "projectName", qualifiedBy = {MappingUtil.ConvertorUtil.class, MappingUtil.CharacterEncodingStringToPersian.class})
    })
    @BeanMapping(ignoreByDefault = true)
    void characterEncodingPersian_ProjectName(@MappingTarget ProjectResponse target, ProjectDto projectDto);

}
