package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface PeriodRepository extends CrudRepository<PeriodEntity, Long> {

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApiAndLevelAndEduCategoryAndExecutor",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<PeriodEntity> findAllByDeleteStatusIsNotNullAndDeleteStatusEquals(Long deleteStatus,Pageable pageable);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApi", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<PeriodEntity> findAllByPeriodApi_FieldPublicId(String fieldPublicId,Pageable pageable);

    @Query(value = "select p from PeriodEntity p " +
            " left join fetch p.executer ex left join fetch ex.personApiEntity pw " +
            " where p.deleteStatus = 1L ",
            countQuery = "select count(p) from PeriodEntity p " +
                    " left join p.executer ex left join ex.personApiEntity pw " +
                    " where p.deleteStatus = 1L "
    )
    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApiAndLevelAndEduCategoryAndExecutor",
            type = EntityGraph.EntityGraphType.LOAD)
    PeriodEntity findByPeriodApi_PeriodPublicId(String periodPublicId);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApi",
            type = EntityGraph.EntityGraphType.LOAD)
    List<PeriodEntity> findAllByIdIn(List<Long> periodIds);

    @Query(name = "PeriodEntity.selectAllPeriodOnly", nativeQuery = true)
    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)
    List<PeriodOnly> findAllPeriodOnly();

/*    @Query(name = "PeriodEntity.selectAllPeriodOnlyById", nativeQuery = true)
    @QueryHints(forCounting = true)
    List<PeriodOnly> findAllPeriodOnlyById(@Param("periodIds") List<Long> periodIds);*/

    @Query(name = "PeriodEntity.selectPeriodOnlyByIdGreaterThan", nativeQuery = true)
    List<PeriodOnly> findPeriodOnlyByIdGreaterThan(@Param("periodId") Long id);

    PeriodEntity findFirstByOrderByIdDesc();

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonApi", type = EntityGraph.EntityGraphType.LOAD)
    Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntityIsNull();

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApiAndLevelAndEduCategoryAndExecutor",
            type = EntityGraph.EntityGraphType.LOAD)
    Page<PeriodEntity>
    findByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntity_PersonPublicId
            (Pageable pageable, String executorPublicId);

    @Query(name = "PeriodEntity.selectAllPeriodOnlyByIdBetween", nativeQuery = true)
    List<PeriodOnly> findAllPeriodOnlyByIdBetween(@Param("beginPeriodId") Long beginPeriodId,
                                                  @Param("endPeriodId") Long endPeriodId);

    @Query(name = "PeriodEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long periodId);

    PeriodEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);
}
