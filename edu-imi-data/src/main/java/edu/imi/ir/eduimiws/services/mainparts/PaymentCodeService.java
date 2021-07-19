package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.PaymentCodeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentCodeService {

    Page<PaymentCodeApiEntity> findAll(Pageable pageable);

    Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode, Pageable pageable);

    PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId);

    PaymentCodeApiEntity generatePaymentCodeByNationalCodeProjectEntityAndPaymentCodeEntity(String nationalCode,
                                                                              ProjectEntity project,
                                                                              ExpenseCodeApiEntity expenseCodeApi,
                                                                              String bankTwoDigitPaymentCode);

    PaymentCodeApiEntity generatePaymentCodeAndPublicId(PaymentCodeApiEntity paymentCodeApi);

    PaymentCodeApiEntity save(PaymentCodeApiEntity paymentCodeApiEntity);

    String concatenateAllInputsForPaymentCode(String nationalCode,
                                              String expenseCodePublicId,
                                              String projectPublicId,
                                              String bankTwoDigitPaymentCode);

    void checkAllInputCodesForPaymentCode(String nationalCode,
                                       String expenseCodePublicId,
                                       String projectPublicId,
                                       String bankTwoDigitPaymentCode);

    void validatePaymentCodeRequestNullInputs(PaymentCodeRequest paymentCodeRequest);

    void validatePaymentCodeApiDtoNulls(PaymentCodeApiDto paymentCodeApiDto);

}
