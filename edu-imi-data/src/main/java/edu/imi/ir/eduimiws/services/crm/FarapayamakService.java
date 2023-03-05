package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;


public interface FarapayamakService {

    FarapayamakCredential getFarapayamakCredential();

    FarapayamakReturnedSendSmsDto sendSMS(FarapayamakSendSmsDto farapayamakSendSmsDto);

    FarapayamakReturnedSendSmsDto getBasePrice();

    FarapayamakReturnedSendSmsDto getCredit();

   FarapayamakReturnedSendSmsDto getUserNumbers();

    FarapayamakReturnedSendSmsDto getMessagesFromFarapayamak(FarapayamakSendSmsDto farapayamakSendSmsDto);

    FarapayamakReturnedSendSmsDto getDeliveries2(FarapayamakSendSmsDto farapayamakSendSmsDto);



//    List<FarapayamakReturnedSendSmsDto> sendSmsAsync(FarapayamakSendSmsDto farapayamakSendSmsDto);

}
