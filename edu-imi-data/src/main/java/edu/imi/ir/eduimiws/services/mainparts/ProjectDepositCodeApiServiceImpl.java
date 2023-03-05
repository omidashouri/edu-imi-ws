package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.repositories.mainparts.ProjectDepositCodeApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.function.Predicate;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProjectDepositCodeApiServiceImpl implements ProjectDepositCodeApiService {

    private final ProjectDepositCodeApiRepository projectDepositCodeApiRepository;
    private final ProjectDepositCodeApiMapper projectDepositCodeApiMapper;
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


    protected Predicate<String> isInputNullOrEqualString() {
        Predicate<String> isNull = input -> input == null;
        Predicate<String> isStringEqual = input -> input.equalsIgnoreCase("");
        return isNull.or(isStringEqual);
    }

    protected <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

}
