package edu.imi.ir.eduimiws.repositories.attendance;

import edu.imi.ir.eduimiws.domain.attendance.OrganizationChartDataModelEtsApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationChartDataModelEtsApiRepository extends CrudRepository<OrganizationChartDataModelEtsApiEntity, Long> {

}
