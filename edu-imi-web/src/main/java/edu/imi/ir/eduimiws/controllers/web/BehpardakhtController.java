package edu.imi.ir.eduimiws.controllers.web;

import edu.imi.ir.eduimiws.models.dto.crm.PersonApiDto;
import edu.imi.ir.eduimiws.models.response.mellat.BehpardakhtAfterPaymentResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

//    simulate for creating post request from bank
    //    http://ashouri-pc.imi.ir:8080/edu-imi-ws/web/behpardakhts/bankRefIdResponse
    @GetMapping("/bankRefIdResponse")
    public String bankRefIdResponse(){
        return "behpardakht/bankRefIdResponse";
    }

//    receive call back url simulation from imi api (for getting attribute)
    @GetMapping("/thymee")
    public String thymee(Map<String,Object> model,
                         Model modelS,
                         HttpServletRequest request,
                         @RequestParam(value = "myRequestParam", required = false) String myRequestParam,
                         @RequestParam(value = "opStat", required = false) String opStat,
                         @ModelAttribute(value = "myModelAttribute") String myModelAttribute,
                         @ModelAttribute(value = "operationStatus") String operationStatus){

        model.put("message","Hello Omid Ashouri");

        // Get parameters
        System.out.println("attribute: " + myRequestParam);
        System.out.println("flashAttribute: " + myModelAttribute);

        String operationStatusFromModelMap = (String) modelS.asMap().get("operationStatus");
        System.out.println("operationStatusFromModelMap: " + operationStatusFromModelMap);

        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if (flashMap != null)
        {
            String operationStatus2 = (String) flashMap.get("operationStatus");
            System.out.println("operationStatus: " + operationStatus2);
        }

//        return "welcome";
        return "behpardakht/thyme";
    }

    @GetMapping("/refId")
    public String refId(){
        return "behpardakht/refidsubmit";
    }

    @GetMapping("/refIdResponse")
    public String refIdResponse(){
        return "behpardakht/refidresponse";
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


    //    respond to hidden from to redirect
    @PostMapping(path = "/bankResponseHidden")
    public ModelAndView sendBankResponseHidden(@RequestParam(name = "RefId") String refId,
                                               @RequestParam(name = "ResCode") String resCode,
                                               @RequestParam(name = "SaleOrderId",required = false) Long saleOrderId,
                                               @RequestParam(name = "SaleReferenceId",required = false) Long saleReferenceId,
                                               @RequestParam(name = "CardHolderPAN",required = false) String cardHolderPAN,
                                               @RequestParam(name = "CreditCardSaleResponseDetail",required = false) String creditCardSaleResponseDetail,
                                               @RequestParam(name = "FinalAmount",required = false) Long finalAmount,
                                               ModelMap model) {

        String refId1 = null;
        String resCode1 = null;
        Long saleOrderId1 = null;
        Long saleReferenceId1 = null;
        String cardHolderPAN1 = null;
        String creditCardSaleResponseDetail1 = null;
        Long finalAmount1 = null;

        model.addAttribute("nameiii","omid");

        if (refId != null) {
            refId1 = refId;
            model.addAttribute("RefId",refId);
        }

        if (resCode != null) {
            resCode1 = resCode;
        }

        if (saleOrderId != null) {
            saleOrderId1 = saleOrderId;
        }

        if (saleReferenceId != null) {
            saleReferenceId1 = saleReferenceId;
        }

        if (cardHolderPAN != null) {
            cardHolderPAN1 = cardHolderPAN;
        }

        if (creditCardSaleResponseDetail != null) {
            creditCardSaleResponseDetail1 = creditCardSaleResponseDetail;
        }

        if (finalAmount != null) {
            finalAmount1 = finalAmount;
        }

        System.out.println(" refId:"+String.valueOf(refId1) +
                " resCode:"+String.valueOf(resCode1) +
                " saleOrderId:"+String.valueOf(saleOrderId1) +
                " saleReferenceId:"+String.valueOf(saleReferenceId1) +
                " cardHolderPAN:"+String.valueOf(cardHolderPAN1) +
                " creditCardSaleResponseDetail:"+String.valueOf(creditCardSaleResponseDetail1) +
                " finalAmount:"+String.valueOf(finalAmount1));

        Map<String,String> myMap = new HashMap<>();
        myMap.put("name","omidashouri");

        return new ModelAndView("hiddenBankResponseRedirect.html",model);

    }
}
