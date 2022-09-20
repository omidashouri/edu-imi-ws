package edu.imi.ir.eduimiws.controllers.crm.v1;


import edu.imi.ir.eduimiws.mapper.crm.*;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.request.crm.farapayamak.GetDeliveries2RequestForFarapayamak;
import edu.imi.ir.eduimiws.models.request.crm.farapayamak.GetMessagesRequestForFarapayamak;
import edu.imi.ir.eduimiws.models.request.crm.farapayamak.SendSmsRequestForFarapayamak;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.*;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.services.crm.FarapayamakService;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/farapayamaks")
@RequiredArgsConstructor
@Tag(name = "farapayamaks", description = "The Farapayamak API")
public class FarapayamakController {

    private final FarapayamakService farapayamakService;
    private final SendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper sendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper;
    private final SendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper sendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper;
    private final FarapayamakCredential farapayamakCredential;
    private final CommonUtils commonUtils;
    private final GetBasePriceForFarapayamakFarapayamakReturnedSendSmsDtoMapper getBasePriceForFarapayamakFarapayamakReturnedSendSmsDtoMapper;
    private final GetCreditForFarapayamakFarapayamakReturnedSendSmsDtoMapper getCreditForFarapayamakFarapayamakReturnedSendSmsDtoMapper;
    private final GetUserNumbersForFarapayamakFarapayamakReturnedSendSmsDtoMapper getUserNumbersForFarapayamakFarapayamakReturnedSendSmsDtoMapper;
    private final GetMessagesRequestForFarapayamakFarapayamakSendSmsDtoMapper getMessagesRequestForFarapayamakFarapayamakSendSmsDtoMapper;
    private final FarapayamakReturnedSendSmsDtoGetMessagesResponseForFarapayamakMapper farapayamakReturnedSendSmsDtoGetMessagesResponseForFarapayamakMapper;
    private final GetDeliveries2RequestForFarapayamakToFarapayamakSendSmsDtoMapper getDeliveries2RequestForFarapayamakToFarapayamakSendSmsDtoMapper;
    private final FarapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamakMapper farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamakMapper;

    //        todo: implement update message status
//        todo: add messageReceiverPublicId(z) to farapayamakReturnedSendSmsDto → SendSmsResponseForFarapayamak (for future uses)


    @Operation(
            summary = "Send SMS From farapayamak",
            description = "Send Sms From Frapayamak",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = SendSmsRequestForFarapayamak.class))
            )
    )
    @Tags(value = {
            @Tag(name = "farapayamaks")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = SendSmsResponseForFarapayamak.class)
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
    )
    @PostMapping(path = "/sendSms",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> sendSmsFarapayamak(@RequestBody SendSmsRequestForFarapayamak sendSmsRequestForFarapayamak) {


        Collection<List<String>> collectionList = commonUtils
                .partitionBasedOnSize(sendSmsRequestForFarapayamak.getMobileNumbers(), 99);

        List<List<String>> listList = commonUtils.convertCollectionListToListList(collectionList);

        List<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDtos = new ArrayList<>();

        listList.forEach(list -> {
            sendSmsRequestForFarapayamak.setMobileNumbers(list);

            FarapayamakSendSmsDto farapayamakSendSmsDto = sendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper
                    .toFarapayamakSendSmsDto(sendSmsRequestForFarapayamak, farapayamakCredential);

            FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService.sendSMS(farapayamakSendSmsDto);

            farapayamakReturnedSendSmsDtos.add(farapayamakReturnedSendSmsDto);

        });

        SendSmsResponseForFarapayamak sendSmsResponseForFarapayamak = new SendSmsResponseForFarapayamak();

        farapayamakReturnedSendSmsDtos
                .stream()
                .map(sendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper::toSendSmsResponseForFarapayamak)
                .forEach(ssrf -> {
                    sendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper
                            .addNewFarapayamakReturnedSendSmsDto(sendSmsResponseForFarapayamak, ssrf);
                });

        return ResponseEntity.ok(sendSmsResponseForFarapayamak);
    }


    @Operation(
            summary = "Get Base Price From farapayamak",
            description = "Get Base Price From Farapayamak",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @Tags(value = {
            @Tag(name = "farapayamaks")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = GetBasePriceResponseForFarapayamak.class)
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
    )
    @PostMapping(path = "/getBasePrice",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getBasePriceFarapayamak() {

        FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService.getBasePrice();

        GetBasePriceResponseForFarapayamak getBasePriceResponseForFarapayamak = getBasePriceForFarapayamakFarapayamakReturnedSendSmsDtoMapper
                .toGetBasePriceResponseForFarapayamak(farapayamakReturnedSendSmsDto);

        return ResponseEntity.ok(getBasePriceResponseForFarapayamak);
    }


    @Operation(
            summary = "Get Credit From farapayamak",
            description = "Get Credit From Farapayamak",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @Tags(value = {
            @Tag(name = "farapayamaks")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = GetCreditResponseForFarapayamak.class)
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
    )
    @PostMapping(path = "/getCredit",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getCreditFarapayamak() {

        FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService.getCredit();

        GetCreditResponseForFarapayamak getCreditResponseForFarapayamak = getCreditForFarapayamakFarapayamakReturnedSendSmsDtoMapper
                .toGetCreditResponseForFarapayamak(farapayamakReturnedSendSmsDto);

        return ResponseEntity.ok(getCreditResponseForFarapayamak);
    }

    @Operation(
            summary = "Get User Numbers From farapayamak",
            description = "Get User Numbers From Farapayamak",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @Tags(value = {
            @Tag(name = "farapayamaks")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = GetUserNumbersResponseForFarapayamak.class)
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
    )
    @PostMapping(path = "/getUserNumbers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUserNumbersFarapayamak() {

        FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService.getUserNumbers();

        GetUserNumbersResponseForFarapayamak getUserNumbersResponseForFarapayamak = getUserNumbersForFarapayamakFarapayamakReturnedSendSmsDtoMapper
                .toGetUserNumbersResponseForFarapayamak(farapayamakReturnedSendSmsDto);

        return ResponseEntity.ok(getUserNumbersResponseForFarapayamak);

    }

    @Operation(
            summary = "Get Messages From Farapayamak",
            description = "Get Messages From Farapayamak",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @Tags(value = {
            @Tag(name = "farapayamaks")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = GetMessagesResponseForFarapayamak.class)
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
    )
    @PostMapping(path = "/getMessagesFromFarapayamak",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getMessagesFromFarapayamak(@RequestBody GetMessagesRequestForFarapayamak
                                                                getMessagesRequestForFarapayamak) {

        List<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDtos = new ArrayList<>();


        FarapayamakSendSmsDto farapayamakSendSmsDto = getMessagesRequestForFarapayamakFarapayamakSendSmsDtoMapper
                .toFarapayamakSendSmsDto(getMessagesRequestForFarapayamak);

        sendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper
                .handleFarapayamakCredentials(farapayamakCredential, farapayamakSendSmsDto);

        //calling Service//
        // farapayamakService.getMessagesFromFarapayamak(farapayamakSendSmsDto);//

        FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService
                .getMessagesFromFarapayamak(farapayamakSendSmsDto);

        GetMessagesResponseForFarapayamak getMessagesResponseForFarapayamak =
                farapayamakReturnedSendSmsDtoGetMessagesResponseForFarapayamakMapper
                        .farapayamakReturnedSendSmsDtoToGetMessagesResponseForFarapayamak(farapayamakReturnedSendSmsDto);

        return ResponseEntity.ok(getMessagesResponseForFarapayamak);
    }

    @PostMapping(path = "/getDeliveries2Farapayamak",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getDeliveries2Farapayamak(@RequestBody GetDeliveries2RequestForFarapayamak getDeliveries2RequestForFarapayamak) {

        FarapayamakSendSmsDto farapayamakSendSmsDto = getDeliveries2RequestForFarapayamakToFarapayamakSendSmsDtoMapper
                .toFarapayamakSendSmsDto(getDeliveries2RequestForFarapayamak);

        sendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper
                .handleFarapayamakCredentials(farapayamakCredential, farapayamakSendSmsDto);

        FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService.getDeliveries2(farapayamakSendSmsDto);

        GetDeliveries2ResponseForFarapayamak getDeliveries2ResponseForFarapayamak =
                farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamakMapper
                        .farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamak(farapayamakReturnedSendSmsDto);

        return ResponseEntity.ok(getDeliveries2ResponseForFarapayamak);
    }
}
