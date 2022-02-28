package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.VoucherDeleteItemsApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherDeleteItemsApiRepository extends CrudRepository<VoucherDeleteItemsApiEntity, Long> {

    Page<VoucherDeleteItemsApiEntity> findAllByDeleteDateTsIsNull(Pageable pageable);

    VoucherDeleteItemsApiEntity findByPublicId(String publicId);

    VoucherDeleteItemsApiEntity findTopByOrderByIdApiDesc();


}
