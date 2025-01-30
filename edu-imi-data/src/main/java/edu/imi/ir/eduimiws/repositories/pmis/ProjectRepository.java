package edu.imi.ir.eduimiws.repositories.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.models.projections.pmis.ProjectForPaymentCodeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.QueryHint;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    @EntityGraph(value = "ProjectEntity.findProjectProjectApi", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectEntity> findAll(Pageable pageable);


    @EntityGraph(value = "ProjectEntity.findProjectProjectApi", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectEntity findByProjectApi_ProjectPublicId(String projectPublicId);

    @EntityGraph(value = "ProjectEntity.findProjectProjectApi", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectEntity findByProjectCodeAndLastVersion(String projectCode, String lastVersion);

    @Query(name = "ProjectEntity.queryPageablePaymentCodeApiProjection")
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectForPaymentCodeProjection> queryPageableProjectForPaymentCodeProjection(
            @Param("id") Long id,
            @Param("projectPublicId") String projectPublicId,
            @Param("projectCode") String projectCode,
            @Param("projectName") String projectName,
            @Param("lastVersion") String lastVersion,
            Pageable pageable);
}
