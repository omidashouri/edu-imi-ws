package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.PaymentRequestBankMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.PaymentResponseBankMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequestBank;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponseBank;
import edu.imi.ir.eduimiws.repositories.mainparts.MelliDigitalPaymentRepository;
import edu.imi.ir.eduimiws.security.MelliCredential;
import edu.imi.ir.eduimiws.utilities.MelliTripleDesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MelliDigitalPaymentServiceImpl implements MelliDigitalPaymentService {


    private final MelliDigitalPaymentRepository melliDigitalPaymentRepository;
    private final PaymentRequestBankMapper paymentRequestBankMapper;
    private final PaymentResponseBankMapper paymentResponseBankMapper;
    private final MelliCredential melliCredential;
    private final RestTemplate restTemplate;
    private final MelliTripleDesImpl melliTripleDesImpl;

    @Override
    public Long queryLastOrderId() {
        log.info("MelliDigitalPaymentService.queryLastOrderId - start");
        Long result = melliDigitalPaymentRepository.queryLastOrderId();
        log.info("MelliDigitalPaymentService.queryLastOrderId - result: {}", result);
        return result;
    }

    @Override
    public MelliDigitalPaymentDto getToken(MelliDigitalPaymentDto melliDigitalPaymentDto) {
        log.info("MelliDigitalPaymentService.getToken - publicId: {}, amount: {}, orderId: {}, token: [REDACTED]",
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getPublicId() : null,
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getAmount() : null,
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getOrderId() : null);

        PaymentRequestBank paymentRequestBank = paymentRequestBankMapper
                .melliDigitalPaymentDtoToPaymentRequestBank(melliDigitalPaymentDto, melliCredential);

        this.setApiReturnUrl(melliDigitalPaymentDto.getPublicId(), paymentRequestBank, melliCredential);

        PaymentResponseBank paymentResponseBank = restTemplate
                .postForObject(this.uriComponentsBuilderToString(melliCredential.getIpgUriGetToken()),
                        this.paymentRequestHttpEntity(paymentRequestBank,melliCredential),
                        PaymentResponseBank.class);

        paymentResponseBankMapper.
                updateMelliDigitalPaymentDtoByPaymentResponseBank(melliDigitalPaymentDto, paymentResponseBank);

        log.info("MelliDigitalPaymentService.getToken - result: publicId={}, amount={}, orderId={}, resCode={}, token=[REDACTED]",
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getPublicId() : null,
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getAmount() : null,
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getOrderId() : null,
                melliDigitalPaymentDto != null ? melliDigitalPaymentDto.getResCode() : null);
        return melliDigitalPaymentDto;
    }

    @Override
    public MelliDigitalPaymentEntity saveMelliDigitalPaymentEntity(MelliDigitalPaymentEntity melliDigitalPayment){
        log.info("MelliDigitalPaymentService.saveMelliDigitalPaymentEntity - id: {}, publicId: {}, amount: {}, orderId: {}, token: [REDACTED]",
                melliDigitalPayment != null ? melliDigitalPayment.getId() : null,
                melliDigitalPayment != null ? melliDigitalPayment.getPublicId() : null,
                melliDigitalPayment != null ? melliDigitalPayment.getAmount() : null,
                melliDigitalPayment != null ? melliDigitalPayment.getOrderId() : null);
        MelliDigitalPaymentEntity result = melliDigitalPaymentRepository.save(melliDigitalPayment);
        log.info("MelliDigitalPaymentService.saveMelliDigitalPaymentEntity - result: id={}, publicId={}, amount={}, orderId={}, token=[REDACTED]",
                result != null ? result.getId() : null,
                result != null ? result.getPublicId() : null,
                result != null ? result.getAmount() : null,
                result != null ? result.getOrderId() : null);
        return result;
    }

    @Override
    public MelliDigitalPaymentEntity findByPublicId(String publicId) {
        log.info("MelliDigitalPaymentService.findByPublicId - publicId: {}", publicId);
        MelliDigitalPaymentEntity result = melliDigitalPaymentRepository.findByPublicId(publicId);
        log.info("MelliDigitalPaymentService.findByPublicId - result: id={}, publicId={}, amount={}, orderId={}, token=[REDACTED]",
                result != null ? result.getId() : null,
                result != null ? result.getPublicId() : null,
                result != null ? result.getAmount() : null,
                result != null ? result.getOrderId() : null);
        return result;
    }

    protected String uriComponentsBuilderToString(String stringUri){
        return UriComponentsBuilder.fromUriString(stringUri).toUriString();
    }


    protected PaymentRequestBank updateSignedData(PaymentRequestBank paymentRequestBank){
        String orderId = String.valueOf(this.queryLastOrderId());
        paymentRequestBank.setOrderId(Long.valueOf(orderId));
        paymentRequestBank.setSignData(melliTripleDesImpl
                .encrypt(String.format("%s;%s;%s", paymentRequestBank.getTerminalId(), orderId, paymentRequestBank.getAmount())));
        return paymentRequestBank; //h1nHk8huQA+Lh+4T6LLHdQ==
    }

    protected String tokenSignedData(String token){
        return melliTripleDesImpl
                .encrypt(token);
    }


    protected void setApiReturnUrl(String publicId, PaymentRequestBank paymentRequestBank, MelliCredential melliCredential){
        paymentRequestBank.setReturnUrl(melliCredential.getApiFixedCallBackUrl()+publicId);
    }


    protected HttpEntity<PaymentRequestBank> paymentRequestHttpEntity(PaymentRequestBank paymentRequestBank, MelliCredential melliCredential){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Referer",melliCredential.getApiRefererUrl());

        HttpEntity<PaymentRequestBank> paymentRequestHttpEntity = new HttpEntity<>(paymentRequestBank, headers);
        return paymentRequestHttpEntity;
    }

}
