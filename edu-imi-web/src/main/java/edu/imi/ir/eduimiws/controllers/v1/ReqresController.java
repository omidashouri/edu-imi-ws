package edu.imi.ir.eduimiws.controllers.v1;


import edu.imi.ir.eduimiws.models.api.UserReqres;
import edu.imi.ir.eduimiws.services.api.reqres.ReqresApi;
import edu.imi.ir.eduimiws.services.api.reqres.SoapClientImpl;
import edu.imi.ir.eduimiws.services.api.reqres.SoapClientImpl2;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/reqres")
@RequiredArgsConstructor
@Tag(name = "reqres", description = "The reqres API")
public class ReqresController {

    private final ReqresApi reqresApi;
    private final SoapClientImpl soapClient;
    private final SoapClientImpl2 soapClientImpl2;


//    https://reqres.in/
//    https://reqres.in/api/users/2

    @GetMapping(path = "/{reqresId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getRoleByRolePublicId(@PathVariable String reqresId) {

        try {
            String bb=null;
            if (reqresId.equalsIgnoreCase("1")) {
//                soapClient.callMellat();

                String aa = soapClientImpl2.bpPayRequest(1L, null, null,
                        1L, 1L, null,
                        null, null, null,
                        String.valueOf(1L));

                bb = aa;
            }

//            UserReqres userReqres = reqresApi.getSingleUser(Long.valueOf(reqresId));
//            return ResponseEntity.ok(userReqres);

            return ResponseEntity.ok(bb);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

//    #1
@PostMapping(path = "/{reqresId}",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<?> getRefIdResponse(@RequestParam(name = "reqresId") String reqresId) {

    try {

        if (reqresId.equalsIgnoreCase("1")) {
//                soapClient.callMellat();

            String aa = soapClientImpl2.bpPayRequest(1L, null, null,
                    1L, 1L, null,
                    null, null, null,
                    String.valueOf(1L));

            String bb = aa;
        }

        UserReqres userReqres = reqresApi.getSingleUser(Long.valueOf(reqresId));


        return ResponseEntity.ok(userReqres);

    } catch (Exception ex) {
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }
}

    //    #2 bank callbackURL
//    http://ashouri-pc.imi.ir:8080/edu-imi-ws/api/v1/reqres/bankResponse
    @PostMapping(path = "/bankResponse",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getBankResponse(@RequestParam(name = "RefId") String refId,
                                             @RequestParam(name = "ResCode") String resCode,
                                             @RequestParam(name = "SaleOrderId",required = false) Long saleOrderId,
                                             @RequestParam(name = "SaleReferenceId",required = false) Long saleReferenceId,
                                             @RequestParam(name = "CardHolderPAN",required = false) String cardHolderPAN,
                                             @RequestParam(name = "CreditCardSaleResponseDetail",required = false) String creditCardSaleResponseDetail,
                                             @RequestParam(name = "FinalAmount",required = false) Long finalAmount,
                                             RedirectAttributes redirectAttributes) {

        try {
            String refId1 = null;
            String resCode1 = null;
            Long saleOrderId1 = null;
            Long saleReferenceId1 = null;
            String cardHolderPAN1 = null;
            String creditCardSaleResponseDetail1 = null;
            Long finalAmount1 = null;

            if (refId != null) {
                refId1 = refId;
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
            redirectAttributes.addFlashAttribute("operationStatus","success");
            redirectAttributes.addAllAttributes(myMap);
                    redirectAttributes.addAttribute("myModelAttribute", "modelAttributeValue");
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .header(HttpHeaders.LOCATION,
                            "http://ashouri-pc:8080/edu-imi-ws/web/behpardakhts/thymee?opStat=suc")
                    .build();

/*            return ResponseEntity.ok(String.valueOf(refId1) +
                    String.valueOf(resCode1) +
                    String.valueOf(saleOrderId1) +
                    String.valueOf(saleReferenceId1) +
                    String.valueOf(cardHolderPAN1) +
                    String.valueOf(creditCardSaleResponseDetail1) +
                    String.valueOf(finalAmount1)
            );*/

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


//    respons to hidden from to redirect
    @PostMapping(path = "/bankResponseTemplate",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
//            , produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            )
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?>  sendBankResponseHidden(@RequestParam(name = "RefId") String refId,
                                                    @RequestParam(name = "ResCode") String resCode,
                                                    @RequestParam(name = "SaleOrderId",required = false) Long saleOrderId,
                                                    @RequestParam(name = "SaleReferenceId",required = false) Long saleReferenceId,
                                                    @RequestParam(name = "CardHolderPAN",required = false) String cardHolderPAN,
                                                    @RequestParam(name = "CreditCardSaleResponseDetail",required = false) String creditCardSaleResponseDetail,
                                                    @RequestParam(name = "FinalAmount",required = false) Long finalAmount,
                                                    Model model) {

            String refId1 = null;
            String resCode1 = null;
            Long saleOrderId1 = null;
            Long saleReferenceId1 = null;
            String cardHolderPAN1 = null;
            String creditCardSaleResponseDetail1 = null;
            Long finalAmount1 = null;

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

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            RestTemplate restTemplate = new RestTemplate();


        return restTemplate.exchange("",
                HttpMethod.POST,
                null,
                Void.class,
                model);



//            return null;

    }

}
