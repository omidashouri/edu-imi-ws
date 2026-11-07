package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.VoucherDeleteItemsApiEntity;
import edu.imi.ir.eduimiws.repositories.mainparts.VoucherDeleteItemsApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class VoucherDeleteItemsServiceImpl implements VoucherDeleteItemsService{

    private final VoucherDeleteItemsApiRepository voucherDeleteItemsApiRepository;

    @Override
    public Page<VoucherDeleteItemsApiEntity> findAllByDeleteStatusIsNull(Pageable pageable) {
        log.info("VoucherDeleteItemsService.findAllByDeleteStatusIsNull - pageable: {}", pageable);
        Page<VoucherDeleteItemsApiEntity> result = voucherDeleteItemsApiRepository.findAllByDeleteDateTsIsNull(pageable);
        log.info("VoucherDeleteItemsService.findAllByDeleteStatusIsNull - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public VoucherDeleteItemsApiEntity findByPublicId(String publicId) {
        log.info("VoucherDeleteItemsService.findByPublicId - publicId: {}", publicId);
        VoucherDeleteItemsApiEntity result = voucherDeleteItemsApiRepository.findByPublicId(publicId);
        log.info("VoucherDeleteItemsService.findByPublicId - result: {}", result);
        return result;
    }

    @Override
    public VoucherDeleteItemsApiEntity findLastRecordOrderByApiId() {
        log.info("VoucherDeleteItemsService.findLastRecordOrderByApiId - start");
        VoucherDeleteItemsApiEntity result = voucherDeleteItemsApiRepository.findTopByOrderByIdApiDesc();
        log.info("VoucherDeleteItemsService.findLastRecordOrderByApiId - result: {}", result);
        return result;
    }
}
