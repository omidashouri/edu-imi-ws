package edu.imi.ir.eduimiws.repositories.attendance;

import edu.imi.ir.eduimiws.domain.attendance.IoRecordDataModelEtsApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IoRecordDataModelEtsApiRepository extends CrudRepository<IoRecordDataModelEtsApiEntity, Long> {

}
