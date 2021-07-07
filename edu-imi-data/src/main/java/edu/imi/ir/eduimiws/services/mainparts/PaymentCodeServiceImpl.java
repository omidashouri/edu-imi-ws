package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.repositories.mainparts.PaymentCodeRepository;
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
public class PaymentCodeServiceImpl implements PaymentCodeService{

    private final PaymentCodeRepository paymentCodeRepository;


    @Override
    public Page<PaymentCodeApiEntity> findAll(Pageable pageable) {
        return paymentCodeRepository.findAll(pageable);
    }

    @Override
    public Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode, Pageable pageable) {
        return paymentCodeRepository.findAllByPaymentCodeContaining(paymentCode, pageable);
    }

    @Override
    public PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId) {
        return paymentCodeRepository.findByPaymentCodePublicId(paymentCodePublicId);
    }

    @Override
    public PaymentCodeApiEntity save(PaymentCodeApiEntity paymentCodeApiEntity) {
        PaymentCodeApiEntity newPaymentCodeApi = new PaymentCodeApiEntity();
        return paymentCodeRepository.save(newPaymentCodeApi);
    }
}
