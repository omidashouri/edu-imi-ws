package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Page<ProjectEntity> findAllProjectEntityPages(Pageable pageable);

    ProjectEntity findProjectEntityByProjectApiPublicId(String projectPublicId);
}
