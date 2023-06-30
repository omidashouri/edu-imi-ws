package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomThree;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomTwo;
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
        return projectDepositCodeApiRepository
                .findAllByDeleteDateTsIsNull(pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findAllByDeleteDateTsNotNull(Pageable pageable) {
        return projectDepositCodeApiRepository.findAllByDeleteDateTsNotNull(pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
    }


    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByPublicId(String publicId) {

        ProjectDepositCodeApiEntity projectDepositCodeApi =
                projectDepositCodeApiRepository.findByPublicIdAndDeleteDateTsIsNull(publicId);

        return projectDepositCodeApiMapper
                .toProjectDepositCodeApiDto(projectDepositCodeApi);
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectPublicId(String projectPublicId) {

        return null;
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

//         newProjectDepositCodeApi = new ProjectDepositCodeApiEntity();
//      projectDepositCodeApiMapper.setPublicIdCreatorCreateDateTs(newProjectDepositCodeApiDto, personMapper);

        ProjectDepositCodeApiEntity newProjectDepositCodeApi = projectDepositCodeApiMapper
                .toProjectDepositCodeApiEntity(newProjectDepositCodeApiDto);

        ProjectDepositCodeApiEntity savedProjectDepositCodeApi =
                projectDepositCodeApiRepository.save(newProjectDepositCodeApi);

        return projectDepositCodeApiMapper
                .toProjectDepositCodeApiDto(savedProjectDepositCodeApi);
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiEntityPublicId(String publicId) {

        ProjectDepositCodeApiEntity projectDepositCodeApi =
                projectDepositCodeApiRepository
                        .findProjectDepositCodeApiEntityByPublicIdAndDeleteDateTsIsNull(publicId);

        return projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApi);
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findByDepositCode(String depositCode, Pageable pageable) {

        return projectDepositCodeApiRepository
                .findByDeleteDateTsIsNullAndDepositCode(depositCode, pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectCodeAndDepositCode(String projectCode, String depositCode) {
        return projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApiRepository
                .findByDeleteDateTsIsNullAndProject_ProjectCodeAndDepositCode(projectCode, depositCode));
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findByProjectNameContaining(String projectName, Pageable pageable) {
        return projectDepositCodeApiRepository
                .findByDeleteDateTsIsNullAndProject_ProjectNameContaining(projectName, pageable)
                .map(p -> projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
    }


    @Override
    public void validateProjectDepositCodeApiRequestNullInputs(ProjectDepositCodeApiRequest projectDepositCodeApiRequest) {
        if (isInputNullOrEqualString().test(projectDepositCodeApiRequest.getDepositCode()))
            throw new NotAcceptableException("deposit code is null");

        if (isInputNullOrEqualString().test(projectDepositCodeApiRequest.getProjectPublicId()))
            throw new NotAcceptableException("project public id is null");
    }

    @Override
    public void validateProjectDepositCodeApiDtoNulls(ProjectDepositCodeApiDto projectDepositCodeApiDto) {
        if (isNull().test(projectDepositCodeApiDto.getProjectDto()))
            throw new NotFoundException("Project Not Found");
    }

    @Override
    public Page<ProjectDepositCodeApiProjectionCustomTwo> queryAllProjectDepositCodeApiCustomTwo(String publicId, String depositCode,
                                                                                                 String description, Timestamp createDateTs,
                                                                                                 Timestamp editDateTs, Timestamp deleteDateTs,
                                                                                                 String projectName, String projectCode,
                                                                                                 String creatorFullName, String editorFullName,
                                                                                                 Pageable pageable) {


        String encodedProjectName = convertorUtil.characterEncodingInputStringForDb.apply(projectName);
        String encodedCreatorFullName = convertorUtil.characterEncodingInputStringForDb.apply(creatorFullName);
        String encodedEditorFullName = convertorUtil.characterEncodingInputStringForDb.apply(editorFullName);

        Page<ProjectDepositCodeApiProjectionCustomTwo> projectDepositCodeApiProjectionCustomTwoPages =
                projectDepositCodeApiRepository
                        .queryAllProjectDepositCodeApiCustomTwo(publicId, depositCode, description,
                                createDateTs, editDateTs, deleteDateTs,
                                encodedProjectName, projectCode, encodedCreatorFullName,
                                encodedEditorFullName, pageable);

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
