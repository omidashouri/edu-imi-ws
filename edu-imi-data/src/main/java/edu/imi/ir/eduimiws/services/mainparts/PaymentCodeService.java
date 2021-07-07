package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentCodeService {

    Page<PaymentCodeApiEntity> findAll(Pageable pageable);

    Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode, Pageable pageable);

    PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId);

    PaymentCodeApiEntity save(PaymentCodeApiEntity paymentCodeApiEntity);

}
