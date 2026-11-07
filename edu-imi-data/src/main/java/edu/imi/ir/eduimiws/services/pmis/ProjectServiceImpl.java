package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectForPaymentCodeProjectionProjectDtoMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.projections.pmis.ProjectForPaymentCodeProjection;
import edu.imi.ir.eduimiws.repositories.pmis.ProjectRepository;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectFastMapper projectFastMapper;
    private final ProjectForPaymentCodeProjectionProjectDtoMapper projectForPaymentCodeProjectionProjectDtoMapper;
    private final ConvertorUtil convertorUtil;


    @Override
    public Page<ProjectEntity> findAllProjectEntityPages(Pageable pageable) {
        log.info("ProjectService.findAllProjectEntityPages - pageable: {}", pageable);
        Page<ProjectEntity> projectPages = projectRepository
                .findAll(pageable);
        log.info("ProjectService.findAllProjectEntityPages - resultSize: {}, totalElements: {}",
                projectPages == null ? null : projectPages.getNumberOfElements(),
                projectPages == null ? null : projectPages.getTotalElements());
        return projectPages;
    }

    @Override
    public ProjectEntity findProjectEntityByProjectApiPublicId(String projectPublicId) {
        log.info("ProjectService.findProjectEntityByProjectApiPublicId - projectPublicId: {}", projectPublicId);
        ProjectEntity project = projectRepository
                .findByProjectApi_ProjectPublicId(projectPublicId);
        log.info("ProjectService.findProjectEntityByProjectApiPublicId - result: {}", project);
        return project;
    }


    @Override
    public ProjectDto findProjectDtoByProjectApiPublicId(String projectPublicId) {
        log.info("ProjectService.findProjectDtoByProjectApiPublicId - projectPublicId: {}", projectPublicId);
        ProjectDto result = projectFastMapper
                .toProjectDto(this.findProjectEntityByProjectApiPublicId(projectPublicId),
                        new CycleAvoidingMappingContext());
        log.info("ProjectService.findProjectDtoByProjectApiPublicId - result: {}", result);
        return result;
    }

    @Override
    public ProjectDto findProjectDtoByProjectCodeAndLastVersion(String projectCode, String lastVersion) {
        log.info("ProjectService.findProjectDtoByProjectCodeAndLastVersion - projectCode: {}, lastVersion: {}", projectCode, lastVersion);
        ProjectDto result = projectFastMapper
                .toProjectDto(projectRepository.findByProjectCodeAndLastVersion(projectCode, lastVersion),
                        new CycleAvoidingMappingContext());
        log.info("ProjectService.findProjectDtoByProjectCodeAndLastVersion - result: {}", result);
        return result;
    }

    @Override
    public Page<ProjectDto> findAllPageableProjectForPaymentCode(Pageable pageable) {
        log.info("ProjectService.findAllPageableProjectForPaymentCode - pageable: {}", pageable);
        Page<ProjectForPaymentCodeProjection> projectForPaymentCodeProjections = projectRepository
                .queryPageableProjectForPaymentCodeProjection(null, null,
                        null, null, "y", pageable);
        Page<ProjectDto> result = projectForPaymentCodeProjections.map(projectForPaymentCodeProjectionProjectDtoMapper::projectForPaymentCodeProjectionToProjectDto);
        log.info("ProjectService.findAllPageableProjectForPaymentCode - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<ProjectDto> findAllPageableProjectForPaymentCodeByQueryParam(Map<String, String> queryParams) {
        log.info("ProjectService.findAllPageableProjectForPaymentCodeByQueryParam - queryParams: {}", queryParams);

        String projectName, projectCode, projectPublicId;

        projectName = convertorUtil.findKey(queryParams, "projectName")
                .filter(Objects::nonNull)
                .map(convertorUtil::changeInstanceCharAndNumSetByTypeDb)
                .orElse(null);

        projectCode = convertorUtil.findKey(queryParams, "projectCode")
                .filter(Objects::nonNull)
                .map(convertorUtil::changeInstanceCharAndNumSetByTypeDb)
                .orElse(null);

        projectPublicId = convertorUtil.findKey(queryParams, "projectPublicId")
                .filter(Objects::nonNull)
                .map(convertorUtil::changeInstanceCharAndNumSetByTypeDb)
                .orElse(null);

        Pageable pageable = convertorUtil.getPageableFromQueryParam(queryParams, "projectName");

        Page<ProjectForPaymentCodeProjection> projectForPaymentCodeProjections = projectRepository
                .queryPageableProjectForPaymentCodeProjection(null, projectPublicId,
                        projectCode, projectName, "y", pageable);
        Page<ProjectDto> result = projectForPaymentCodeProjections
                .map(projectForPaymentCodeProjectionProjectDtoMapper::projectForPaymentCodeProjectionToProjectDto);
        log.info("ProjectService.findAllPageableProjectForPaymentCodeByQueryParam - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }
}
