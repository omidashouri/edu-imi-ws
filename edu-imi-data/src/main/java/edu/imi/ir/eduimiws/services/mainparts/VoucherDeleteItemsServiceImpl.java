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
        return voucherDeleteItemsApiRepository.findAllByDeleteDateTsIsNull(pageable);
    }

    @Override
    public VoucherDeleteItemsApiEntity findByPublicId(String publicId) {
        return voucherDeleteItemsApiRepository.findByPublicId(publicId);
    }

    @Override
    public VoucherDeleteItemsApiEntity findLastRecordOrderByApiId() {
        return voucherDeleteItemsApiRepository.findTopByOrderByIdApiDesc();
    }
}
