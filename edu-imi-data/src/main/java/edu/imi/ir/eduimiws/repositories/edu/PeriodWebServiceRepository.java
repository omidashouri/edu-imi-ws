package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import org.hibernate.graph.EntityGraphs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodWebServiceRepository extends CrudRepository<PeriodWebServiceEntity,Long> {

    @EntityGraph("periodWebServiceFastGraph")
    List<PeriodWebServiceEntity> findAll();

    PeriodWebServiceEntity findFirstByOrderByIdDesc();

    @EntityGraph("PeriodWebServiceEntity.periodWebServicePeriodFastGraph")
    Page<PeriodWebServiceEntity> findAll(Pageable pageable);

    List<PeriodWebServiceEntity> findAllByIdIn(List<Long> periodIds);

/*    @EntityGraph(value = "PeriodWebServiceEntity.periodWebServicePeriodFastGraph",type = EntityGraph.EntityGraphType.FETCH)
    @Query(value = "select pw from PeriodWebServiceEntity pw left join pw.period p ",
            countQuery = "select count(pw) from PeriodWebServiceEntity pw left join pw.period p")
    Page<PeriodWebServiceEntity> findBy(Pageable pageable);*/

}
