package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
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
    private final PersonMapper personMapper;

   @Override
    public Page<ProjectDepositCodeApiDto> findAll(Pageable pageable) {
        return projectDepositCodeApiRepository
                .findAll(pageable)
                .map(p->projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByPublicId(String publicId) {

        ProjectDepositCodeApiEntity projectDepositCodeApi =
                projectDepositCodeApiRepository.findByPublicId(publicId);

        return projectDepositCodeApiMapper
                .toProjectDepositCodeApiDto(projectDepositCodeApi);
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectPublicId(String projectPublicId) {

     /* return projectDepositCodeApiMapper
              .toProjectDepositCodeApiDto(this.findProjectDepositCodeApiDtoByProjectPublicId(projectPublicId),
                      new CycleAvoidingMappingContext());*/
        return null;
    }

    @Override
    public ProjectDepositCodeApiDto updateDepositCodeApi(ProjectDepositCodeApiDto newProjectDepositCodeApiDto, ProjectDepositCodeApiEntity editTblProjectDepositCodeApi) {

        projectDepositCodeApiMapper
                .updateProjectCodeApiByProjectDepositCodeApiDto(newProjectDepositCodeApiDto, editTblProjectDepositCodeApi);

        ProjectDepositCodeApiEntity updateProjectDepositCodeApi =
                projectDepositCodeApiRepository.save(editTblProjectDepositCodeApi);

        return projectDepositCodeApiMapper.toProjectDepositCodeApiDto(updateProjectDepositCodeApi);
    }

    @Override
    public ProjectDepositCodeApiDto save(ProjectDepositCodeApiDto newProjectDepositCodeApiDto) {

        ProjectDepositCodeApiEntity newProjectDepositCodeApi = new ProjectDepositCodeApiEntity();

        projectDepositCodeApiMapper.setPublicIdCreatorCreateDateTs(newProjectDepositCodeApiDto, personMapper);

        newProjectDepositCodeApi = projectDepositCodeApiMapper
                .toProjectDepositCodeApiEntity(newProjectDepositCodeApiDto);

        ProjectDepositCodeApiEntity savedProjectDepositCodeApi =
                projectDepositCodeApiRepository.save(newProjectDepositCodeApi);

        return projectDepositCodeApiMapper
                .toProjectDepositCodeApiDto(savedProjectDepositCodeApi);
    }

 /*   @Override
    public List<ProjectDepositCodeApiEntity> findAll() {

        Iterable<ProjectDepositCodeApiEntity> projectDepositCodeApiIterable = projectDepositCodeApiRepository.findAll();

        List<ProjectDepositCodeApiEntity> projectDepositCodeApis = StreamSupport
                .stream(projectDepositCodeApiIterable.spliterator(), false)
                .collect(Collectors.toList());

        return projectDepositCodeApis;

    }*/

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiEntityPublicId(String publicId) {

        ProjectDepositCodeApiEntity projectDepositCodeApi =
                projectDepositCodeApiRepository
                        .findProjectDepositCodeApiEntityByPublicId(publicId);

        return projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApi);
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findByDepositCode(String depositCode, Pageable pageable) {

        return projectDepositCodeApiRepository
                .findByDepositCode(depositCode, pageable)
                .map(p->projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
    }

    @Override
    public ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectCodeAndDepositCode(String projectCode, String depositCode) {
        return projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApiRepository
                .findByProject_ProjectCodeAndDepositCode(projectCode, depositCode));
    }

    @Override
    public Page<ProjectDepositCodeApiDto> findByProjectNameContaining(String projectName, Pageable pageable) {
        return projectDepositCodeApiRepository
                .findByProject_ProjectNameContaining(projectName, pageable)
                .map(p->projectDepositCodeApiMapper.toProjectDepositCodeApiDto(p));
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

   /* @Override
    public void deleteProjectDepositCodeApi(String publicId) {
        projectDepositCodeApiRepository.deleteByPublicId(publicId);
    }*/

    protected Predicate<String> isInputNullOrEqualString() {
        Predicate<String> isNull = input -> input == null;
        Predicate<String> isStringEqual = input -> input.equalsIgnoreCase("");
        return isNull.or(isStringEqual);
    }

    protected <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

}
