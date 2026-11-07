package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.VoucherListItemsApiEntity;
import edu.imi.ir.eduimiws.repositories.mainparts.VoucherListItemsApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class VoucherListItemsServiceImpl implements VoucherListItemsService{

    private final VoucherListItemsApiRepository voucherListItemsApiRepository;

    @Override
    public Page<VoucherListItemsApiEntity> findAllByDeleteStatusIsNull(Pageable pageable) {
        log.info("VoucherListItemsService.findAllByDeleteStatusIsNull - pageable: {}", pageable);
        Page<VoucherListItemsApiEntity> result = voucherListItemsApiRepository.findAllByDeleteDateTsIsNull(pageable);
        log.info("VoucherListItemsService.findAllByDeleteStatusIsNull - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public VoucherListItemsApiEntity findByPublicId(String publicId) {
        log.info("VoucherListItemsService.findByPublicId - publicId: {}", publicId);
        VoucherListItemsApiEntity result = voucherListItemsApiRepository.findByPublicId(publicId);
        log.info("VoucherListItemsService.findByPublicId - result: {}", result);
        return result;
    }

    @Override
    public VoucherListItemsApiEntity findLastRecordOrderByCreateDate(){
        log.info("VoucherListItemsService.findLastRecordOrderByCreateDate - start");
        VoucherListItemsApiEntity result = voucherListItemsApiRepository.findTopByOrderByLastCreateDateMiladiDescIdApiDesc();
        log.info("VoucherListItemsService.findLastRecordOrderByCreateDate - result: {}", result);
        return result;
    }

    @Override
    public VoucherListItemsApiEntity findLastRecordOrderByEditDate() {
        log.info("VoucherListItemsService.findLastRecordOrderByEditDate - start");
        VoucherListItemsApiEntity result = voucherListItemsApiRepository.findTopByOrderByLastEditDateMiladiDescIdApiDesc();
        log.info("VoucherListItemsService.findLastRecordOrderByEditDate - result: {}", result);
        return result;
    }

    @Override
    public VoucherListItemsApiEntity findLastRecordOrderByDeleteDateTs() {
        log.info("VoucherListItemsService.findLastRecordOrderByDeleteDateTs - start");
        VoucherListItemsApiEntity result = voucherListItemsApiRepository.findTopByDeleteDateTsIsNotNullOrderByDeleteDateTsDescIdApiDesc();
        log.info("VoucherListItemsService.findLastRecordOrderByDeleteDateTs - result: {}", result);
        return result;
    }

    @Override
    public List<VoucherListItemsApiEntity> findAllByPublicIdIn(List<String> publicIds) {
        log.info("VoucherListItemsService.findAllByPublicIdIn - publicIds: {}", publicIds);
        List<VoucherListItemsApiEntity> result = voucherListItemsApiRepository.findAllByPublicIdIn(publicIds);
        log.info("VoucherListItemsService.findAllByPublicIdIn - resultSize: {}", result == null ? null : result.size());
        return result;
    }
}
