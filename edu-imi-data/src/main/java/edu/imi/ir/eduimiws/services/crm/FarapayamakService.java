package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;


public interface FarapayamakService {

    FarapayamakCredential getFarapayamakCredential();

    FarapayamakReturnedSendSmsDto sendSMS(FarapayamakSendSmsDto farapayamakSendSmsDto);

//    List<FarapayamakReturnedSendSmsDto> sendSmsAsync(FarapayamakSendSmsDto farapayamakSendSmsDto);

}
