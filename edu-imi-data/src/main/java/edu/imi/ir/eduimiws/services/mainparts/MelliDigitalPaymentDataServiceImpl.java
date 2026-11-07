package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentDataEntity;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.MelliDigitalPaymentDataMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;
import edu.imi.ir.eduimiws.repositories.mainparts.MelliDigitalPaymentDataRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class MelliDigitalPaymentDataServiceImpl implements MelliDigitalPaymentDataService {

    private final MelliDigitalPaymentDataRepository melliDigitalPaymentDataRepository;
    private final MelliDigitalPaymentDataMapper melliDigitalPaymentDataMapper;
    private final PublicIdUtil publicIdUtil;
    private final SecurityUtil securityUtil;

    @Override
    public MelliDigitalPaymentDataDto saveMelliDigitalPaymentDataEntity(MelliDigitalPaymentDataDto melliDigitalPaymentDataDto) {
        log.info("MelliDigitalPaymentDataService.saveMelliDigitalPaymentDataEntity - publicId: {}, orderId: {}, resCode: {}, melliDigitalPaymentPublicId: {}, token: [REDACTED]",
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getPublicId() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getOrderId() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getResCode() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getMelliDigitalPaymentPublicId() : null);

        MelliDigitalPaymentDataEntity melliDigitalPaymentData = melliDigitalPaymentDataMapper
                .toMelliDigitalPaymentDataEntity(melliDigitalPaymentDataDto, publicIdUtil, securityUtil);

        MelliDigitalPaymentDataEntity melliDigitalPaymentDataSaved = melliDigitalPaymentDataRepository
                .save(melliDigitalPaymentData);

        melliDigitalPaymentDataMapper
                .updateMelliDigitalPaymentDataDto_Id(melliDigitalPaymentDataDto,melliDigitalPaymentDataSaved);

        log.info("MelliDigitalPaymentDataService.saveMelliDigitalPaymentDataEntity - result: id={}, publicId={}, orderId={}, resCode={}, melliDigitalPaymentPublicId={}, token=[REDACTED]",
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getId() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getPublicId() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getOrderId() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getResCode() : null,
                melliDigitalPaymentDataDto != null ? melliDigitalPaymentDataDto.getMelliDigitalPaymentPublicId() : null);
        return melliDigitalPaymentDataDto;
    }

    @Override
    public MelliDigitalPaymentDataEntity findByMelliDigitalPaymentPublicId(String publicId) {
        log.info("MelliDigitalPaymentDataService.findByMelliDigitalPaymentPublicId - publicId: {}", publicId);
        MelliDigitalPaymentDataEntity result = melliDigitalPaymentDataRepository.findByMelliDigitalPaymentPublicId(publicId);
        log.info("MelliDigitalPaymentDataService.findByMelliDigitalPaymentPublicId - result: id={}, publicId={}, orderId={}, resCode={}, token=[REDACTED]",
                result != null ? result.getId() : null,
                result != null ? result.getPublicId() : null,
                result != null ? result.getOrderId() : null,
                result != null ? result.getResCode() : null);
        return result;
    }
}
