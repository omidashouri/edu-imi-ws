package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomThree;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomTwo;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiCreateRequest;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.repositories.mainparts.ProjectDepositCodeApiRepository;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.function.Predicate;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProjectDepositCodeApiServiceImpl implements ProjectDepositCodeApiService {

    private final ProjectDepositCodeApiRepository projectDepositCodeApiRepository;
    private final ProjectDepositCodeApiMapper projectDepositCodeApiMapper;
    private final ConvertorUtil convertorUtil;
//    private final PersonMapper personMapper;

    @Override
    public Page<ProjectDepositCodeApiDto> findAllAndDeleteDateTsIsNull(Pageable pageable) {
        log.info("ProjectDepositCodeApiService.findAllAndDeleteDateTsIsNull - pageable: {}", pageable);
        Page<ProjectDepositCodeApiDto> result = projectDepositCodeApiRepository
                .findAllByDeleteDateTsIsNull(pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
        log.info("ProjectDepositCodeApiService.findAllAndDeleteDateTsIsNull - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findAllByDeleteDateTsNotNull(Pageable pageable) {
        log.info("ProjectDepositCodeApiService.findAllByDeleteDateTsNotNull - pageable: {}", pageable);
        Page<ProjectDepositCodeApiDto> result = projectDepositCodeApiRepository.findAllByDeleteDateTsNotNull(pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
        log.info("ProjectDepositCodeApiService.findAllByDeleteDateTsNotNull - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }


    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByPublicId(String publicId) {
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiDtoByPublicId - publicId: {}", publicId);

        ProjectDepositCodeApiEntity projectDepositCodeApi =
                projectDepositCodeApiRepository.findByPublicIdAndDeleteDateTsIsNull(publicId);

        ProjectDepositCodeApiDto result = projectDepositCodeApiMapper
                .toProjectDepositCodeApiDto(projectDepositCodeApi);
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiDtoByPublicId - result: {}", result);
        return result;
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectPublicId(String projectPublicId) {
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiDtoByProjectPublicId - projectPublicId: {}", projectPublicId);
        ProjectDepositCodeApiDto result = null;
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiDtoByProjectPublicId - result: {}", result);
        return result;
    }

/*    @Override
    public ProjectDepositCodeApiDto updateDepositCodeApi(ProjectDepositCodeApiDto newProjectDepositCodeApiDto, ProjectDepositCodeApiEntity editTblProjectDepositCodeApi) {

        projectDepositCodeApiMapper
                .updateProjectCodeApiByProjectDepositCodeApiDto(newProjectDepositCodeApiDto, editTblProjectDepositCodeApi);

        ProjectDepositCodeApiEntity updateProjectDepositCodeApi =
                projectDepositCodeApiRepository.save(editTblProjectDepositCodeApi);

        return projectDepositCodeApiMapper.toProjectDepositCodeApiDto(updateProjectDepositCodeApi);
    }*/

    @Override
    public ProjectDepositCodeApiDto save(ProjectDepositCodeApiDto newProjectDepositCodeApiDto) {
        log.info("ProjectDepositCodeApiService.save - newProjectDepositCodeApiDto: {}", newProjectDepositCodeApiDto);

//         newProjectDepositCodeApi = new ProjectDepositCodeApiEntity();
//      projectDepositCodeApiMapper.setPublicIdCreatorCreateDateTs(newProjectDepositCodeApiDto, personMapper);

        ProjectDepositCodeApiEntity newProjectDepositCodeApi = projectDepositCodeApiMapper
                .toProjectDepositCodeApiEntity(newProjectDepositCodeApiDto);

        ProjectDepositCodeApiEntity savedProjectDepositCodeApi =
                projectDepositCodeApiRepository.save(newProjectDepositCodeApi);

        ProjectDepositCodeApiDto result = projectDepositCodeApiMapper
                .toProjectDepositCodeApiDto(savedProjectDepositCodeApi);
        log.info("ProjectDepositCodeApiService.save - result: {}", result);
        return result;
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiEntityPublicId(String publicId) {
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiEntityPublicId - publicId: {}", publicId);

        ProjectDepositCodeApiEntity projectDepositCodeApi =
                projectDepositCodeApiRepository
                        .findProjectDepositCodeApiEntityByPublicIdAndDeleteDateTsIsNull(publicId);

        ProjectDepositCodeApiDto result = projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApi);
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiEntityPublicId - result: {}", result);
        return result;
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findByDepositCode(String depositCode, Pageable pageable) {
        log.info("ProjectDepositCodeApiService.findByDepositCode - depositCode: {}, pageable: {}", depositCode, pageable);

        Page<ProjectDepositCodeApiDto> result = projectDepositCodeApiRepository
                .findByDeleteDateTsIsNullAndDepositCode(depositCode, pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
        log.info("ProjectDepositCodeApiService.findByDepositCode - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectCodeAndDepositCode(String projectCode, String depositCode) {
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiDtoByProjectCodeAndDepositCode - projectCode: {}, depositCode: {}", projectCode, depositCode);
        ProjectDepositCodeApiDto result = projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApiRepository
                .findByDeleteDateTsIsNullAndProject_ProjectCodeAndDepositCode(projectCode, depositCode));
        log.info("ProjectDepositCodeApiService.findProjectDepositCodeApiDtoByProjectCodeAndDepositCode - result: {}", result);
        return result;
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findByProjectNameContaining(String projectName, Pageable pageable) {
        log.info("ProjectDepositCodeApiService.findByProjectNameContaining - projectName: {}, pageable: {}", projectName, pageable);
        Page<ProjectDepositCodeApiDto> result = projectDepositCodeApiRepository
                .findByDeleteDateTsIsNullAndProject_ProjectNameContaining(projectName, pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
        log.info("ProjectDepositCodeApiService.findByProjectNameContaining - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }


    @Override
    public void validateProjectDepositCodeApiRequestNullInputs(ProjectDepositCodeApiRequest projectDepositCodeApiRequest) {
        log.info("ProjectDepositCodeApiService.validateProjectDepositCodeApiRequestNullInputs - projectDepositCodeApiRequest: {}", projectDepositCodeApiRequest);
        if (isInputNullOrEqualString().test(projectDepositCodeApiRequest.getDepositCode()))
            throw new NotAcceptableException("deposit code is null");

        if (isInputNullOrEqualString().test(projectDepositCodeApiRequest.getProjectPublicId()))
            throw new NotAcceptableException("project public id is null");
        log.info("ProjectDepositCodeApiService.validateProjectDepositCodeApiRequestNullInputs - completed");
    }

    @Override
    public void validateProjectDepositCodeApiRequestNullInputs(ProjectDepositCodeApiCreateRequest projectDepositCodeApiRequest) {
        log.info("ProjectDepositCodeApiService.validateProjectDepositCodeApiRequestNullInputs - createRequest: {}", projectDepositCodeApiRequest);
        if (isInputNullOrEqualString().test(projectDepositCodeApiRequest.getDepositCode()))
            throw new NotAcceptableException("deposit code is null");

        if (isInputNullOrEqualString().test(projectDepositCodeApiRequest.getProjectPublicId()))
            throw new NotAcceptableException("project public id is null");
        log.info("ProjectDepositCodeApiService.validateProjectDepositCodeApiRequestNullInputs - create completed");
    }

    @Override
    public void validateProjectDepositCodeApiDtoNulls(ProjectDepositCodeApiDto projectDepositCodeApiDto) {
        log.info("ProjectDepositCodeApiService.validateProjectDepositCodeApiDtoNulls - projectDepositCodeApiDto: {}", projectDepositCodeApiDto);
        if (isNull().test(projectDepositCodeApiDto.getProjectDto()))
            throw new NotFoundException("Project Not Found");
        log.info("ProjectDepositCodeApiService.validateProjectDepositCodeApiDtoNulls - completed");
    }

    @Override
    public Page<ProjectDepositCodeApiProjectionCustomTwo> queryAllProjectDepositCodeApiCustomTwo(String publicId, String depositCode,
                                                                                                 String description, Timestamp createDateTs,
                                                                                                 Timestamp editDateTs, Timestamp deleteDateTs,
                                                                                                 String projectName, String projectCode,
                                                                                                 String creatorFullName, String editorFullName,
                                                                                                 Pageable pageable) {
        log.info("ProjectDepositCodeApiService.queryAllProjectDepositCodeApiCustomTwo - publicId: {}, depositCode: {}, description: {}, createDateTs: {}, editDateTs: {}, deleteDateTs: {}, projectName: {}, projectCode: {}, creatorFullName: {}, editorFullName: {}, pageable: {}",
                publicId, depositCode, description, createDateTs, editDateTs, deleteDateTs, projectName, projectCode, creatorFullName, editorFullName, pageable);


        String encodedProjectName = convertorUtil.characterEncodingInputStringForDb.apply(projectName);
        String encodedCreatorFullName = convertorUtil.characterEncodingInputStringForDb.apply(creatorFullName);
        String encodedEditorFullName = convertorUtil.characterEncodingInputStringForDb.apply(editorFullName);

        Page<ProjectDepositCodeApiProjectionCustomTwo> projectDepositCodeApiProjectionCustomTwoPages =
                projectDepositCodeApiRepository
                        .queryAllProjectDepositCodeApiCustomTwo(publicId, depositCode, description,
                                createDateTs, editDateTs, deleteDateTs,
                                encodedProjectName, projectCode, encodedCreatorFullName,
                                encodedEditorFullName, pageable);

        log.info("ProjectDepositCodeApiService.queryAllProjectDepositCodeApiCustomTwo - resultSize: {}, totalElements: {}",
                projectDepositCodeApiProjectionCustomTwoPages == null ? null : projectDepositCodeApiProjectionCustomTwoPages.getNumberOfElements(),
                projectDepositCodeApiProjectionCustomTwoPages == null ? null : projectDepositCodeApiProjectionCustomTwoPages.getTotalElements());
        return projectDepositCodeApiProjectionCustomTwoPages;
    }

    @Override
    public Page<ProjectDepositCodeApiProjectionCustomThree> queryAllProjectDepositCodeApiCustomThree(String publicId,
                                                                                                     String depositCode,
                                                                                                     String description,
                                                                                                     Timestamp createDateTs,
                                                                                                     Timestamp editDateTs,
                                                                                                     Timestamp deleteDateTs,
                                                                                                     String projectName,
                                                                                                     String projectCode,
                                                                                                     String projectCreateDate,
                                                                                                     Long projectStatusId,
                                                                                                     String projectTypeName,
                                                                                                     String startDatePlan,
                                                                                                     String endDatePlan,
                                                                                                     String lastVersion,
                                                                                                     Character statusForTimeshit,
                                                                                                     String creatorFullName,
                                                                                                     String editorFullName,
                                                                                                     String executor,
                                                                                                     String projectPublicId,
                                                                                                     Pageable pageable) {
        log.info("ProjectDepositCodeApiService.queryAllProjectDepositCodeApiCustomThree - publicId: {}, depositCode: {}, description: {}, createDateTs: {}, editDateTs: {}, deleteDateTs: {}, projectName: {}, projectCode: {}, projectCreateDate: {}, projectStatusId: {}, projectTypeName: {}, startDatePlan: {}, endDatePlan: {}, lastVersion: {}, statusForTimeshit: {}, creatorFullName: {}, editorFullName: {}, executor: {}, projectPublicId: {}, pageable: {}",
                publicId, depositCode, description, createDateTs, editDateTs, deleteDateTs, projectName, projectCode, projectCreateDate, projectStatusId, projectTypeName, startDatePlan, endDatePlan, lastVersion, statusForTimeshit, creatorFullName, editorFullName, executor, projectPublicId, pageable);

        String encodedProjectName = convertorUtil.characterEncodingInputStringForDb.apply(projectName);
        String encodedCreatorFullName = convertorUtil.characterEncodingInputStringForDb.apply(creatorFullName);
        String encodedEditorFullName = convertorUtil.characterEncodingInputStringForDb.apply(editorFullName);
       // String encodedExecuter = convertorUtil.characterEncodingInputStringForDb.apply(Executor);

       //lastVersion = "y";
     //   projectStatusId = 0L ;
       // deleteDateTs = null ;

        Page<ProjectDepositCodeApiProjectionCustomThree> projectDepositCodeApiProjectionCustomThreePages =
                projectDepositCodeApiRepository
                        .queryAllProjectDepositCodeApiCustomThree(publicId, depositCode, description,
                                                                  createDateTs, editDateTs,null,
                                                                  encodedProjectName, projectCode,
                                                                  projectCreateDate,0L,
                                                                  projectTypeName,startDatePlan,endDatePlan,
                                                                  "y",
                                                                    statusForTimeshit,
                                                                  encodedCreatorFullName,
                                                                  encodedEditorFullName,
                                                                  executor,projectPublicId,pageable);

        log.info("ProjectDepositCodeApiService.queryAllProjectDepositCodeApiCustomThree - resultSize: {}, totalElements: {}",
                projectDepositCodeApiProjectionCustomThreePages == null ? null : projectDepositCodeApiProjectionCustomThreePages.getNumberOfElements(),
                projectDepositCodeApiProjectionCustomThreePages == null ? null : projectDepositCodeApiProjectionCustomThreePages.getTotalElements());
        return projectDepositCodeApiProjectionCustomThreePages;
    }


    protected Predicate<String> isInputNullOrEqualString() {
        Predicate<String> isNull = input -> input == null;
        Predicate<String> isStringEqual = input -> input.equalsIgnoreCase("");
        return isNull.or(isStringEqual);
    }

    protected <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

}
