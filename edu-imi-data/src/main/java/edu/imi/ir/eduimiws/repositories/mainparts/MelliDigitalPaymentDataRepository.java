package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface MelliDigitalPaymentDataRepository extends CrudRepository<MelliDigitalPaymentDataEntity, Long> {


    MelliDigitalPaymentDataEntity findByMelliDigitalPaymentPublicId(String melliDigitalPaymentPublicId);
}
