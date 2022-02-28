package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.VoucherListItemsApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoucherListItemsService {

    Page<VoucherListItemsApiEntity> findAllByDeleteStatusIsNull(Pageable pageable);

    VoucherListItemsApiEntity findByPublicId(String publicId);

    VoucherListItemsApiEntity findLastRecordOrderByCreateDate();

    VoucherListItemsApiEntity findLastRecordOrderByEditDate();

    VoucherListItemsApiEntity findLastRecordOrderByDeleteDateTs();

    List<VoucherListItemsApiEntity> findAllByPublicIdIn(List<String> publicIds);


}
