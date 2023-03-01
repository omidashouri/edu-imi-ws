package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.List;

public interface ProjectDepositCodeApiRepository extends CrudRepository<ProjectDepositCodeApiEntity, Long> {

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findAll(Pageable pageable);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectDepositCodeApiEntity findProjectDepositCodeApiEntityByPublicId(String publicId);

    @EntityGraph(value = "ProjectDepositCodeApiEntity.findProjectProjectApi",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectDepositCodeApiEntity findByPublicId(String publicId);

    ProjectDepositCodeApiEntity save(ProjectDepositCodeApiDto newProjectDepositCodeApi);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    List<ProjectDepositCodeApiEntity> findAllByPublicIdIn(List<String> projectDepositCodeApiPublicIds);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findByDepositCode(String depositCode, Pageable pageable);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectDepositCodeApiEntity findByProject_ProjectCodeAndDepositCode(String projectCode, String depositCode);

    @EntityGraph(value = "ProjectDepositCodeApiEntity.findProjectProjectApi",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findByProject_ProjectNameContaining(String projectName, Pageable pageable);


}
