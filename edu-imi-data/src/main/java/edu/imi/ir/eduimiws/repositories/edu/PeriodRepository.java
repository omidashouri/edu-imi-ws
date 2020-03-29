package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodIdDelStatCanRegOnlineOnly;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PeriodRepository extends CrudRepository<PeriodEntity,Long> {

    List<PeriodIdDelStatCanRegOnlineOnly> findBy();

    List<PeriodEntity> findTop10By();

    List<PeriodEntity> findTop20By();

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
