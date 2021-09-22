package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentDataEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;

public interface MelliDigitalPaymentDataService {

    MelliDigitalPaymentDataDto saveMelliDigitalPaymentDataEntity(MelliDigitalPaymentDataDto melliDigitalPaymentDataDto);

    MelliDigitalPaymentDataEntity findByMelliDigitalPaymentPublicId(String publicId);
}
