package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectDepositCodeApiService {

    Page<ProjectDepositCodeApiEntity> findAllProjectDepositCodeApiEntityPages(Pageable pageable);

    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByPublicId(String publicId);

    @MappingUtil.ProjectPublicIdToProjectDto
    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectPublicId(String projectPublicId);

    ProjectDepositCodeApiDto updateDepositCodeApi(ProjectDepositCodeApiDto newProjectDepositCodeApiDto, ProjectDepositCodeApiEntity editTblProjectDepositCodeApi);

    ProjectDepositCodeApiDto save(ProjectDepositCodeApiDto newProjectDepositCodeApiDto);

    List<ProjectDepositCodeApiEntity> findAll();

    ProjectDepositCodeApiEntity findProjectDepositCodeApiEntityPublicId(String publicId);

    Page<ProjectDepositCodeApiEntity> findAllByDepositCode(String depositCode, Pageable pageable);

    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectCodeAndDepositCode(String projectCode, String depositCode);

    void validateProjectDepositCodeApiRequestNullInputs(ProjectDepositCodeApiRequest projectDepositCodeApiRequest);

    void validateProjectDepositCodeApiDtoNulls(ProjectDepositCodeApiDto projectDepositCodeApiDto);

}
