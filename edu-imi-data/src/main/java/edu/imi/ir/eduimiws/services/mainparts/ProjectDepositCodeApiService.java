package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectDepositCodeApiService {

    Page<ProjectDepositCodeApiDto> findAll(Pageable pageable);

    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByPublicId(String publicId);

    @MappingUtil.ProjectPublicIdToProjectDto
    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectPublicId(String projectPublicId);

    ProjectDepositCodeApiDto updateDepositCodeApi(ProjectDepositCodeApiDto newProjectDepositCodeApiDto, ProjectDepositCodeApiEntity editTblProjectDepositCodeApi);

    ProjectDepositCodeApiDto save(ProjectDepositCodeApiDto newProjectDepositCodeApiDto);

    //  List<ProjectDepositCodeApiEntity> findAll();

    ProjectDepositCodeApiDto findProjectDepositCodeApiEntityPublicId(String publicId);

    Page<ProjectDepositCodeApiDto> findByDepositCode(String depositCode, Pageable pageable);

    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectCodeAndDepositCode(String projectCode,
                                                                                     String depositCode);

    Page<ProjectDepositCodeApiDto> findByProjectNameContaining(String projectName, Pageable pageable);

    void validateProjectDepositCodeApiRequestNullInputs(ProjectDepositCodeApiRequest projectDepositCodeApiRequest);

    void validateProjectDepositCodeApiDtoNulls(ProjectDepositCodeApiDto projectDepositCodeApiDto);


}
