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
        return voucherListItemsApiRepository.findAllByDeleteDateTsIsNull(pageable);
    }

    @Override
    public VoucherListItemsApiEntity findByPublicId(String publicId) {
        return voucherListItemsApiRepository.findByPublicId(publicId);
    }

    @Override
    public VoucherListItemsApiEntity findLastRecordOrderByCreateDate(){
        return voucherListItemsApiRepository.findTopByOrderByLastCreateDateMiladiDescIdApiDesc();
    }

    @Override
    public VoucherListItemsApiEntity findLastRecordOrderByEditDate() {
        return voucherListItemsApiRepository.findTopByOrderByLastEditDateMiladiDescIdApiDesc();
    }

    @Override
    public VoucherListItemsApiEntity findLastRecordOrderByDeleteDateTs() {
        return voucherListItemsApiRepository.findTopByDeleteDateTsIsNotNullOrderByDeleteDateTsDescIdApiDesc();
    }

    @Override
    public List<VoucherListItemsApiEntity> findAllByPublicIdIn(List<String> publicIds) {
        return voucherListItemsApiRepository.findAllByPublicIdIn(publicIds);
    }
}
