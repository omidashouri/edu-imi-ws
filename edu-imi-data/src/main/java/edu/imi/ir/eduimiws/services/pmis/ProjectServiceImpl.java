package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.crm.ContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.repositories.crm.ContactRepository;
import edu.imi.ir.eduimiws.repositories.crm.querydsl.ContactQueryDslRepository;
import edu.imi.ir.eduimiws.repositories.pmis.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ProjectFastMapper projectFastMapper;


    @Override
    public Page<ProjectEntity> findAllProjectEntityPages(Pageable pageable) {
        Page<ProjectEntity> projectPages = projectRepository
                .findAll(pageable);
        return projectPages;
    }

    @Override
    public ProjectEntity findProjectEntityByProjectApiPublicId(String projectPublicId) {
        ProjectEntity project = projectRepository
                .findByProjectApi_ProjectPublicId(projectPublicId);
        return project;
    }
}
