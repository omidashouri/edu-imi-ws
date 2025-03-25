package edu.imi.ir.eduimiws.repositories.attendance;

import edu.imi.ir.eduimiws.domain.attendance.MissionRegistrationDataModelEtsApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRegistrationDataModelEtsApiRepository extends CrudRepository<MissionRegistrationDataModelEtsApiEntity, Long> {

}
