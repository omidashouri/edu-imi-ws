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

    List<PeriodOnly> findBy();

    @Query(value = "select p from PeriodEntity p " +
            " left join fetch p.executer ex left join fetch ex.personApiEntity pw " +
            " where p.deleteStatus = 1L ",
            countQuery = "select count(p) from PeriodEntity p " +
                    " left join p.executer ex left join ex.personApiEntity pw " +
                    " where p.deleteStatus = 1L "
    )
    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonWebService", type = EntityGraph.EntityGraphType.LOAD)
    PeriodEntity findByPeriodApi_PeriodPublicId(String periodPublicId);

    @Query(name = "PeriodEntity.selectAllPeriodOnly", nativeQuery = true)
    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)
    List<PeriodOnly> findAllPeriodOnly();

    @Query(name = "PeriodEntity.selectPeriodOnlyByIdGreaterThan", nativeQuery = true)
    List<PeriodOnly> findPeriodOnlyByIdGreaterThan(@Param("periodId") Long id);

    PeriodEntity findFirstByOrderByIdDesc();

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonWebService", type = EntityGraph.EntityGraphType.LOAD)
    Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntityIsNull();

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonWebService", type = EntityGraph.EntityGraphType.LOAD)
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
