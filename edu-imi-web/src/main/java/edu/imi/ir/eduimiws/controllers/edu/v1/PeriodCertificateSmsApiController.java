package edu.imi.ir.eduimiws.controllers.edu.v1;


import edu.imi.ir.eduimiws.mapper.edu.PeriodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCertificateSmsApiMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCertificateSmsApiProjectionMapper;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.services.edu.PeriodCertificateSmsApiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/periodCrtificateSmsApis")
@RequiredArgsConstructor
@Tag(name = "periodCrtificateSmsApis", description = "The Period Certificate Sms API")
public class PeriodCertificateSmsApiController {

    private final PeriodCertificateSmsApiService periodCertificateSmsApiService;
    private final PeriodCertificateSmsApiMapper periodCertificateSmsApiMapper;
    private final PeriodCertificateSmsApiProjectionMapper periodCertificateSmsApiProjectionMapper;
    private final PeriodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper periodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper;
    private final FarapayamakCredential farapayamakCredential;

    //periodCertificateActivityStatus-->4
    //periodCertificateDeliveryDate is null
    //registerFinalStatus-->passed
    //registerFinancialStatus-->2
    //registerType:0-->azad     1-->sherkati    2-->gharardadi

    @GetMapping(path = "/sendSmsDaily",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> sendSmsForCertificateDaily() {

        periodCertificateSmsApiService
                .queryByPeriodCertificateSmsApi(4L,
                        "passed",
                        null,
                        2L);

        System.out.println("1");

//todo: scachule to run daily
       return null;

    }
}
