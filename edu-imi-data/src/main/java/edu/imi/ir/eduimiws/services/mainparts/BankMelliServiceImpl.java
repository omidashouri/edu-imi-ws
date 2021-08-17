package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequest;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponse;
import edu.imi.ir.eduimiws.repositories.mainparts.MelliDigitalPaymentRepository;
import edu.imi.ir.eduimiws.security.MelliCredential;
import edu.imi.ir.eduimiws.utilities.MelliTripleDes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BankMelliServiceImpl implements BankMelliService{


    private final MelliDigitalPaymentRepository melliDigitalPaymentRepository;
    private final MelliCredential melliCredential;
    private final RestTemplate restTemplate;
    private final MelliTripleDes melliTripleDes;

    @Override
    public Long queryLastOrderId() {
        return melliDigitalPaymentRepository.queryLastOrderId();
    }

    @Override
    public PaymentResponse getToken(PaymentRequest paymentRequest) {

        PaymentResponse paymentResponse = restTemplate
                .postForObject(this.uriComponentsBuilderToString(melliCredential.getIpgUriGetToken()),
                        this.paymentRequestHttpEntity(this.updateCredentialAndSignedData(paymentRequest)),
                        PaymentResponse.class);
        return paymentResponse;
    }

    protected String uriComponentsBuilderToString(String stringUri){
        return UriComponentsBuilder.fromUriString(stringUri).toUriString();
    }

    protected PaymentRequest updateCredentialAndSignedData(PaymentRequest paymentRequest){
        String orderId = String.valueOf(this.queryLastOrderId());
        paymentRequest.setOrderId(Long.valueOf(orderId));
        paymentRequest.setTerminalId(melliCredential.getTerminalId());
        paymentRequest.setMerchantId(melliCredential.getMerchantId());
        paymentRequest.setSignDate(melliTripleDes
                .encrypt(String.format("%s;%s;%s", melliCredential.getTerminalId(), orderId, paymentRequest.getAmount())));
        return paymentRequest; //h1nHk8huQA+Lh+4T6LLHdQ==
    }

    protected HttpEntity<PaymentRequest> paymentRequestHttpEntity(PaymentRequest paymentRequest){
        return new HttpEntity<>(paymentRequest);
    }
}
