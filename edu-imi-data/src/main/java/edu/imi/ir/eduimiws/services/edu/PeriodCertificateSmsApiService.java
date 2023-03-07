package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCertificateSmsApiDto;

import java.util.List;
import java.util.Map;

public interface PeriodCertificateSmsApiService {

    List<PeriodCertificateSmsApiDto> queryByPeriodCertificateSmsApi(Long periodCertificateActivityStatus,
                                                                    String registerFinalStatus,
                                                                    String registerType,
                                                                    Long registerFinancialStatus);

    Map<String, List<PeriodCertificateSmsApiDto>> mapPeriodCertificateSmsApiByRegisterType
            (List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos);

 List<FarapayamakSendSmsDto> findPeriodCertificateReadyToSendByPcsaId(List<Long> periodCertificateSmsApiIds);

      List<FarapayamakSendSmsDto> periodCertificateSendSmsApiToPersonalStudent(List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos);
}
