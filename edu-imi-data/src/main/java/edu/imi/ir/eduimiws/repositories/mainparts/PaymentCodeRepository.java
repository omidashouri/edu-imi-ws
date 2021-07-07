package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCodeRepository extends CrudRepository<PaymentCodeApiEntity, Long> {

    Page<PaymentCodeApiEntity> findAll(Pageable pageable);

    Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode,Pageable pageable);

    PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId);

}
