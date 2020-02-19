package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodWebServiceRepository extends CrudRepository<PeriodWebServiceEntity,Long> {

    List<PeriodWebServiceEntity> findAll();
}
