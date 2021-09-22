package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentDataEntity;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.MelliDigitalPaymentDataMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;
import edu.imi.ir.eduimiws.repositories.mainparts.MelliDigitalPaymentDataRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MelliDigitalPaymentDataServiceImpl implements MelliDigitalPaymentDataService {

    private final MelliDigitalPaymentDataRepository melliDigitalPaymentDataRepository;
    private final MelliDigitalPaymentDataMapper melliDigitalPaymentDataMapper;
    private final PublicIdUtil publicIdUtil;
    private final SecurityUtil securityUtil;

    @Override
    public MelliDigitalPaymentDataDto saveMelliDigitalPaymentDataEntity(MelliDigitalPaymentDataDto melliDigitalPaymentDataDto) {

        MelliDigitalPaymentDataEntity melliDigitalPaymentData = melliDigitalPaymentDataMapper
                .toMelliDigitalPaymentDataEntity(melliDigitalPaymentDataDto, publicIdUtil, securityUtil);

        MelliDigitalPaymentDataEntity melliDigitalPaymentDataSaved = melliDigitalPaymentDataRepository
                .save(melliDigitalPaymentData);

        melliDigitalPaymentDataMapper
                .updateMelliDigitalPaymentDataDto_Id(melliDigitalPaymentDataDto,melliDigitalPaymentDataSaved);

        return melliDigitalPaymentDataDto;
    }

    @Override
    public MelliDigitalPaymentDataEntity findByMelliDigitalPaymentPublicId(String publicId) {
        return melliDigitalPaymentDataRepository.findByMelliDigitalPaymentPublicId(publicId);
    }
}
