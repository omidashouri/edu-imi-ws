package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;

public interface MelliVerifyService {
    MelliVerifyDto verify(MelliVerifyDto melliVerifyDto);

    MelliVerifyDto findByMelliDigitalPaymentPublicId(String melliDigitalPaymentPublicId);
}
