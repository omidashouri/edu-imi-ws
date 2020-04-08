package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
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
import java.util.Set;

@Repository
public interface PeriodRepository extends CrudRepository<PeriodEntity, Long> {

    List<PeriodOnly> findBy();

    @Query(value = "select p from PeriodEntity p " +
            " left join fetch p.executer ex left join fetch ex.personWebServiceEntity pw " +
            " where p.deleteStatus = 1L ",
            countQuery = "select count(p) from PeriodEntity p " +
                    " left join p.executer ex left join ex.personWebServiceEntity pw " +
                    " where p.deleteStatus = 1L "
    )
    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    PeriodEntity findByPeriodWebService_PeriodPublicId(String periodPublicId);

    @Query(name = "PeriodEntity.selectAllPeriodOnly", nativeQuery = true)
    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)
    List<PeriodOnly> findAllPeriodOnly();

    @Query(name = "PeriodEntity.selectPeriodOnlyByIdGreaterThan", nativeQuery = true)
    List<PeriodOnly> findPeriodOnlyByIdGreaterThan(@Param("periodId") Long id);

    PeriodEntity findFirstByOrderByIdDesc();

    List<PeriodEntity> findAllByIdIn(List<Long> periodIds);

    @EntityGraph(value = "PeriodEntity.periodWebServiceEntity", type = EntityGraph.EntityGraphType.FETCH)
    List<PeriodEntity> findAllByPeriodWebServiceNotIn(Set<PeriodWebServiceEntity> periodWebServiceEntities);

    @EntityGraph(value = "PeriodEntity.periodWebServiceEntity", type = EntityGraph.EntityGraphType.FETCH)
    List<PeriodEntity> findAllByPeriodWebService_IdIn(List<Long> periodWebServiceId);

    @EntityGraph(value = "PeriodEntity.periodWebServiceEntity", type = EntityGraph.EntityGraphType.FETCH)
    List<PeriodEntity> findAllByPeriodWebService_IdNotIn(List<Long> periodWebServiceId);


}
