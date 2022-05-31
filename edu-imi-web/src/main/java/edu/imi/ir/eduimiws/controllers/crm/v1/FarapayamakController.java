package edu.imi.ir.eduimiws.controllers.crm.v1;


import edu.imi.ir.eduimiws.mapper.crm.SendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.SendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.request.crm.SendSmsRequestForFarapayamak;
import edu.imi.ir.eduimiws.models.request.crm.SendSmsResponseForFarapayamak;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
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
    )
    @PostMapping(path = "/sendSms",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> sendSmsFarapayamak(@RequestBody SendSmsRequestForFarapayamak sendSmsRequestForFarapayamak) {


        Collection<List<String>> collectionList = commonUtils
                .partitionBasedOnSize(sendSmsRequestForFarapayamak.getMobileNumbers(), 99);

        List<List<String>>  listList = commonUtils.convertCollectionListToListList(collectionList);

        List<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDtos = new ArrayList<>();

        listList.forEach(list->{
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
                .forEach(ssrf->{
                    sendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper
                            .addNewFarapayamakReturnedSendSmsDto(sendSmsResponseForFarapayamak,ssrf);
                });

        return ResponseEntity.ok(sendSmsResponseForFarapayamak);
    }





}
