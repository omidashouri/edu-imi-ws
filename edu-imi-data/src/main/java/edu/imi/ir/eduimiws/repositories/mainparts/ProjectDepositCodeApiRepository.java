package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomThree;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomTwo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.QueryHint;
import java.sql.Timestamp;
import java.util.List;

public interface ProjectDepositCodeApiRepository extends CrudRepository<ProjectDepositCodeApiEntity, Long> {

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findAllByDeleteDateTsIsNull(Pageable pageable);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findAllByDeleteDateTsNotNull(Pageable pageable);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectDepositCodeApiEntity findProjectDepositCodeApiEntityByPublicIdAndDeleteDateTsIsNull(String publicId);

    @EntityGraph(value = "ProjectDepositCodeApiEntity.findProjectProjectApi",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectDepositCodeApiEntity findByPublicIdAndDeleteDateTsIsNull(String publicId);

    ProjectDepositCodeApiEntity save(ProjectDepositCodeApiDto newProjectDepositCodeApi);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    List<ProjectDepositCodeApiEntity> findAllByPublicIdIn(List<String> projectDepositCodeApiPublicIds);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findByDeleteDateTsIsNullAndDepositCode(String depositCode, Pageable pageable);

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ProjectDepositCodeApiEntity findByDeleteDateTsIsNullAndProject_ProjectCodeAndDepositCode(String projectCode, String depositCode);

    @EntityGraph(value = "ProjectDepositCodeApiEntity.findProjectProjectApi",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    Page<ProjectDepositCodeApiEntity> findByDeleteDateTsIsNullAndProject_ProjectNameContaining(String projectName, Pageable pageable);

    @Query(name = "ProjectDepositCodeApiEntity.queryAllProjectDepositCodeApiCustomTwo")
    Page<ProjectDepositCodeApiProjectionCustomTwo> queryAllProjectDepositCodeApiCustomTwo(@Param("publicId") String publicId,
                                                                                          @Param("depositCode") String depositCode,
                                                                                          @Param("description") String description,
                                                                                          @Param("createDateTs") Timestamp createDateTs,
                                                                                          @Param("editDateTs") Timestamp editDateTs,
                                                                                          @Param("deleteDateTs") Timestamp deleteDateTs,
                                                                                          @Param("projectName") String projectName,
                                                                                          @Param("projectCode") String projectCode,
                                                                                          @Param("creatorFullName") String creatorFullName,
                                                                                          @Param("editorFullName") String editorFullName,
                                                                                          Pageable pageable);


    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    @Query(name = "ProjectDepositCodeApiEntity.queryAllProjectDepositCodeApiCustomThree")
    Page<ProjectDepositCodeApiProjectionCustomThree> queryAllProjectDepositCodeApiCustomThree(@Param("publicId") String publicId,
                                                                                              @Param("depositCode") String depositCode,
                                                                                              @Param("description") String description,
                                                                                              @Param("createDateTs") Timestamp createDateTs,
                                                                                              @Param("editDateTs") Timestamp editDateTs,
                                                                                              @Param("deleteDateTs") Timestamp deleteDateTs,
                                                                                              @Param("projectName") String projectName,
                                                                                              @Param("projectCode") String projectCode,
                                                                                              @Param("projectCreateDate") String projectCreateDate,
                                                                                              @Param("projectStatusId") Long projectStatusId,
                                                                                              @Param("projectTypeName") String projectTypeName,
                                                                                              @Param("startDatePlan") String startDatePlan,
                                                                                              @Param("endDatePlan") String endDatePlan,
                                                                                              @Param("lastVersion") String lastVersion,
                                                                                              @Param("statusForTimeshit") Character statusForTimeshit,
                                                                                              @Param("creatorFullName") String creatorFullName,
                                                                                              @Param("editorFullName") String editorFullName,
                                                                                              @Param("executer") String executor,
                                                                                              @Param("projectPublicId") String projectPublicId,
                                                                                              Pageable pageable);


                  }
