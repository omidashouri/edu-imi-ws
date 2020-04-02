package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodOnly;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PeriodRepository extends CrudRepository<PeriodEntity,Long> {

    List<PeriodOnly> findBy();

    @Query(name = "PeriodEntity.selectAllPeriodOnly", nativeQuery = true)
    List<PeriodOnly> findAllPeriodOnly();

    @Query(name = "PeriodEntity.selectPeriodOnlyByIdGreaterThan", nativeQuery =true)
    List<PeriodOnly> findPeriodOnlyByIdGreaterThan(@Param("periodId") Long id);

    PeriodEntity findFirstByOrderByIdDesc();

    List<PeriodEntity> findTop10By();

    List<PeriodEntity> findTop20By();

    List<PeriodOnly> findByIdAfter(Long periodId);

    @EntityGraph(value = "PeriodEntity.periodWebServiceEntity", type = EntityGraph.EntityGraphType.LOAD)
    List<PeriodEntity>  findAllByPeriodWebServiceNotIn(Set<PeriodWebServiceEntity> periodWebServiceEntities);

    @EntityGraph(value = "PeriodEntity.periodWebServiceEntity", type = EntityGraph.EntityGraphType.LOAD)
    List<PeriodEntity>  findAllByPeriodWebService_IdIn(List<Long> periodWebServiceId);

    @EntityGraph(value = "PeriodEntity.periodWebServiceEntity", type = EntityGraph.EntityGraphType.LOAD)
    List<PeriodEntity> findAllByPeriodWebService_IdNotIn(List<Long> periodWebServiceId);


//    List<PeriodEntity> findAllByIdIn(List<PeriodEntity> periodIdIn);

//    List<PeriodEntity> findAllByIdIn(List<PeriodEntity> periodIdIn);

    List<PeriodEntity> findAllByIdIn(List<Long> periodIdIn);

    List<PeriodEntity>  findPeriodEntitiesByIdIn(List<Long> periods);
    List<PeriodEntity>  findByIdIn(List<Long> periods);

//    @EntityGraph(value = "PeriodEntity.creator", type = EntityGraph.EntityGraphType.LOAD)
    List<PeriodEntity>  findByCreatorNotIn(List<PersonEntity> personEntities);



}
