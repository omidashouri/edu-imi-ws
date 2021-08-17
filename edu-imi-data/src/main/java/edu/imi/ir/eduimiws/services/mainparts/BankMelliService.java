package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequest;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponse;

public interface BankMelliService {

    public Long queryLastOrderId();

    public PaymentResponse getToken(PaymentRequest paymentRequest);

}
