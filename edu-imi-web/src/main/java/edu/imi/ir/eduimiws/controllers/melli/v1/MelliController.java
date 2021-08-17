package edu.imi.ir.eduimiws.controllers.melli.v1;

import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequest;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponse;
import edu.imi.ir.eduimiws.services.mainparts.BankMelliService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/mellats")
@RequiredArgsConstructor
@Tag(name = "mellat", description = "The Mellat Bank API")
public class MelliController {

    BankMelliService bankMelliService;

    public void getToken(){

        PaymentRequest paymentRequest = new PaymentRequest();
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentRequest.setAmount(1000L);
        paymentRequest.setReturnUrl("http://ashouri-pc.imi.ir:8080/edu-imi-ws/api/v1/reqres/bankResponse");

        String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ").format(new Date());
        String tail = date.substring(date.indexOf("+") + 1);
        tail = tail.substring(0, 2) + ":" + tail.substring(2);
        date = date.substring(0, date.indexOf("+") + 1) + tail;
        paymentRequest.setLocalDateTime(date);

        paymentResponse = bankMelliService.getToken(paymentRequest);

        System.out.println(paymentResponse.getToken());
    }

}
