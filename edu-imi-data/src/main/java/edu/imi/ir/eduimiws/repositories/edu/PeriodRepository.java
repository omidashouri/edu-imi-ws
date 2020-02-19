package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends CrudRepository<PeriodEntity,Long> {

    List<PeriodEntity> findAll();

    List<PeriodEntity>  findByPeriodWebServiceNotIn(List<PeriodWebServiceEntity> periodWebServiceEntities);
    List<PeriodEntity>  findByPeriodWebServiceIn(List<PeriodWebServiceEntity> periodWebServiceEntities);
}
