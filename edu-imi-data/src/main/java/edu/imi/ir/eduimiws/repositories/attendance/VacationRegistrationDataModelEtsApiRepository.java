package edu.imi.ir.eduimiws.repositories.attendance;

import edu.imi.ir.eduimiws.domain.attendance.VacationRegistrationDataModelEtsApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRegistrationDataModelEtsApiRepository extends CrudRepository<VacationRegistrationDataModelEtsApiEntity, Long> {
}
