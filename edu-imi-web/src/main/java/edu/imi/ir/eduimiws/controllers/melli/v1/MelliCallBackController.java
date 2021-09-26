package edu.imi.ir.eduimiws.controllers.melli.v1;


import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;
import edu.imi.ir.eduimiws.services.mainparts.MelliDigitalPaymentDataService;
import edu.imi.ir.eduimiws.services.mainparts.MelliDigitalPaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/callback/sadad")
@RequiredArgsConstructor
@Tag(name = "MelliPayments", description = "The Melli Bank API")
public class MelliCallBackController {

    private final MelliDigitalPaymentDataService melliDigitalPaymentDataService;
    private final MelliDigitalPaymentService melliDigitalPaymentService;



   /* @Operation(
            summary = "redirect bank response",
            description = "redirect bank response",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @Tags(value = {
            @Tag(name = "melliPayments")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ModelAndView.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "paymentCode not found",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )*/
    @PostMapping(path = "/publicId/{publicId}",
              consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
                      , MediaType.APPLICATION_FORM_URLENCODED_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ModelAndView sendBankResponseRedirect(HttpServletRequest request, @PathVariable(value = "publicId") String publicId,
                                               @RequestParam MultiValueMap multiValueMap,
                                               @RequestParam(name = "OrderId", required = false) String orderId,
                                               @RequestParam(name = "HashedCardNumber", required = false) String hashedCardNumber,
                                               @RequestParam(name = "PrimaryAccNo", required = false) String primaryAccNo,
                                               @RequestParam(name = "SwitchResCode", required = false) String switchResCode,
                                               @RequestParam(name = "ResCode", required = false) String resCode,
                                               @RequestParam(name = "Token", required = false) String token,
                                               @RequestParam(name = "__RequestVerificationToken", required = false) String requestVerificationToken,
                                               @RequestParam(name = "IsWalletPayment", required = false) String isWalletPayment) {

        Map<String,String[]> requestParameters = request.getParameterMap();
        MelliDigitalPaymentDataDto melliDigitalPaymentDataDto = new MelliDigitalPaymentDataDto();
        MelliDigitalPaymentEntity melliDigitalPayment = new MelliDigitalPaymentEntity();
        ModelAndView modelAndView = new ModelAndView();


        if (publicId != null) {
            modelAndView.addObject("PublicId",publicId);
            melliDigitalPayment = melliDigitalPaymentService.findByPublicId(publicId);
            if (melliDigitalPayment == null) {
                throw new FiledValueNullException("There is no Data with that Public Id");
            }
            melliDigitalPaymentDataDto.setMelliDigitalPaymentId(melliDigitalPayment.getId());
            melliDigitalPaymentDataDto.setMelliDigitalPaymentPublicId(melliDigitalPayment.getPublicId());
        }

       if (orderId != null) {
           modelAndView.addObject("ApiOrderId",orderId);
           melliDigitalPaymentDataDto.setOrderId(orderId);
           modelAndView.addObject("OrderId",melliDigitalPayment.getMerchantOrderId());
        }

         if (hashedCardNumber != null) {
             modelAndView.addObject("HashedCardNumber",hashedCardNumber);
             melliDigitalPaymentDataDto.setHashedCardNumber(hashedCardNumber);
        }

        if (primaryAccNo != null) {
            modelAndView.addObject("PrimaryAccNo",primaryAccNo);
            melliDigitalPaymentDataDto.setPrimaryAccNo(primaryAccNo);
        }
        if (switchResCode != null) {
            modelAndView.addObject("SwitchResCode",switchResCode);
            melliDigitalPaymentDataDto.setSwitchResCode(switchResCode);
        }

        if (resCode != null) {
            modelAndView.addObject("ResCode",resCode);
            melliDigitalPaymentDataDto.setResCode(resCode);
        }

        if (token != null) {
            modelAndView.addObject("Token",token);
            melliDigitalPaymentDataDto.setToken(token);
        }

        if (requestVerificationToken != null) {
            modelAndView.addObject("RequestVerificationToken",requestVerificationToken);
            melliDigitalPaymentDataDto.setRequestVerificationToken(requestVerificationToken);
        }

        if (isWalletPayment != null) {
            modelAndView.addObject("IsWalletPayment",isWalletPayment);
            melliDigitalPaymentDataDto.setIsWalletPayment(isWalletPayment);
        }

        System.out.println(melliDigitalPaymentDataDto);

        melliDigitalPaymentDataDto = melliDigitalPaymentDataService
                .saveMelliDigitalPaymentDataEntity(melliDigitalPaymentDataDto);

        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        modelAndView.setViewName("redirect:"+melliDigitalPayment.getReturnUrl());

        return modelAndView;
    }

}

//https://www.baeldung.com/spring-redirect-and-forward
//    @PostMapping("/redirectPostToPost")
//    public ModelAndView redirectPostToPost(HttpServletRequest request) {
//        request.setAttribute(
//                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
//        return new ModelAndView("redirect:/redirectedPostToPost");
//    }