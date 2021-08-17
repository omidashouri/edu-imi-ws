package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MelliDigitalPaymentRepository extends CrudRepository<MelliDigitalPaymentEntity, Long> {

    @Query(name = "MelliDigitalPaymentEntity.selectOrderIdSequenceNumber",nativeQuery = true)
    Long queryLastOrderId();
}
