package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;

public interface MelliDigitalPaymentService {

    Long queryLastOrderId();

    MelliDigitalPaymentDto getToken(MelliDigitalPaymentDto melliDigitalPaymentDto);

    MelliDigitalPaymentEntity saveMelliDigitalPaymentEntity(MelliDigitalPaymentEntity melliDigitalPayment);

    MelliDigitalPaymentEntity findByPublicId(String publicId);
}
