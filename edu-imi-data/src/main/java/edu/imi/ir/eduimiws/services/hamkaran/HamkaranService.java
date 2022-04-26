package edu.imi.ir.eduimiws.services.hamkaran;

import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranAuthenticationTokenDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranDeletedFinancialResponseDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranFinancialResponseDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranHumanResourceResponseDto;


public interface HamkaranService {


    HamkaranAuthenticationTokenDto getToken(HamkaranAuthenticationTokenDto hamkaranAuthenticationTokenDto);

    HamkaranFinancialResponseDto searchHamkaranFinancialResponseBySearchQuery(HamkaranFinancialResponseDto hamkaranFinancialResponseDto);

    HamkaranHumanResourceResponseDto searchHamkaranHumanResourceResponseBySearchQuery(HamkaranHumanResourceResponseDto hamkaranHumanResourceResponseDto);

    HamkaranDeletedFinancialResponseDto searchHamkaranDeletedFinancialResponseBySearchQuery(HamkaranDeletedFinancialResponseDto hamkaranDeletedFinancialResponseDto);
}
