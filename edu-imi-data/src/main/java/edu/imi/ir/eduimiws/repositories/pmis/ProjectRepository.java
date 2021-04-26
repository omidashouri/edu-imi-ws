package edu.imi.ir.eduimiws.repositories.pmis;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    @EntityGraph(value = "ProjectEntity.findProjectProjectApi", type = EntityGraph.EntityGraphType.LOAD)
    Page<ProjectEntity> findAll(Pageable pageable);


    @EntityGraph(value = "ProjectEntity.findProjectProjectApi", type = EntityGraph.EntityGraphType.LOAD)
    ProjectEntity findByProjectApi_ProjectPublicId(String projectPublicId);
}
