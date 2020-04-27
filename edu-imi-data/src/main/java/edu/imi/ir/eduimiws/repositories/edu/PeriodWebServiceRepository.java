package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodWebServiceRepository extends CrudRepository<PeriodApiEntity,Long> {

    @EntityGraph("PeriodApiEntity.periodWebServiceFastGraph")
    List<PeriodApiEntity> findAll();

    PeriodApiEntity findFirstByOrderByIdDesc();

}
