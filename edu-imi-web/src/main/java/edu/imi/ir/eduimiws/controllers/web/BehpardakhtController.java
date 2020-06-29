package edu.imi.ir.eduimiws.controllers.web;

import edu.imi.ir.eduimiws.models.dto.crm.PersonApiDto;
import edu.imi.ir.eduimiws.models.response.mellat.BehpardakhtAfterPaymentResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/web/behpardakhts")
public class BehpardakhtController {

//    http://localhost:8080/edu-imi-ws/web/behpardakhts/afterPaymentResponse

    @GetMapping("/thyme")
    public String thyme(Map<String,Object> model){
        model.put("message","Hello Omid Ashouri");
//        return "welcome";
        return "behpardakht/thyme";
    }

    @GetMapping(value = "/afterPaymentResponse"
            , produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    public ResponseEntity<?> afterPaymentResponse(HttpServletRequest request,
                                                  @ModelAttribute String refId,
                                                  @ModelAttribute String resCode,
                                                  @ModelAttribute String saleOrderId,
                                                  @ModelAttribute String saleReferenceId,
                                                  @ModelAttribute String cardHolderPAN,
                                                  @ModelAttribute
                                                          String creditCardSaleResponseDetail,
                                                  @ModelAttribute String finalAmount) {

        BehpardakhtAfterPaymentResponse behpardakhtAfterPaymentResponse = new BehpardakhtAfterPaymentResponse();

/*        if (refId != null && refId!="") {
            behpardakhtAfterPaymentResponse.setRefId(refId);
        }
        if (resCode != null && resCode!="") {
            behpardakhtAfterPaymentResponse.setResCode(resCode);
        }
        if (saleOrderId != null && saleOrderId!="") {
            behpardakhtAfterPaymentResponse.setSaleOrderId(Long.valueOf(saleOrderId));
        }
        if (saleReferenceId != null&& saleReferenceId!="") {
            behpardakhtAfterPaymentResponse.setSaleReferenceId(Long.valueOf(saleReferenceId));
        }*/
/*        if (cardHolderPAN != null) {
            behpardakhtAfterPaymentResponse.setCardHolderPAN(cardHolderPAN);
        }
        if (creditCardSaleResponseDetail != null) {
            behpardakhtAfterPaymentResponse.setCreditCardSaleResponseDetail(creditCardSaleResponseDetail);

        }
        if (finalAmount != null) {
            behpardakhtAfterPaymentResponse.setFinalAmount(Long.valueOf(finalAmount));
        }*/

        PersonApiDto personApiDto = new PersonApiDto();
        personApiDto.setDescription("1111111111111111111");

        return ResponseEntity.ok(personApiDto);

    }
}
