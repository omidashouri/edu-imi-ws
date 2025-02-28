package edu.imi.ir.eduimiws.repositories.attendance;

import edu.imi.ir.eduimiws.domain.attendance.EmployeeInfoEtsApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeEtsApiRepository extends CrudRepository<EmployeeInfoEtsApiEntity, Long> {

}
