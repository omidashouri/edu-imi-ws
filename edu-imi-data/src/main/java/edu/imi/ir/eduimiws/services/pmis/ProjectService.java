package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@MappingUtil.ProjectService
public interface ProjectService {

    Page<ProjectEntity> findAllProjectEntityPages(Pageable pageable);

    ProjectEntity findProjectEntityByProjectApiPublicId(String projectPublicId);

    @MappingUtil.ProjectPublicIdToProjectDto
    ProjectDto findProjectDtoByProjectApiPublicId(String projectPublicId);

    ProjectDto findProjectDtoByProjectCodeAndLastVersion(String projectCode, String lastVersion);
}
