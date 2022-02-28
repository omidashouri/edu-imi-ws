package edu.imi.ir.eduimiws.services.hamkaran;

import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranAuthenticationTokenDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranDeletedFinancialResponseDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranFinancialResponseDto;


public interface HamkaranService {


    HamkaranAuthenticationTokenDto getToken(HamkaranAuthenticationTokenDto hamkaranAuthenticationTokenDto);

    HamkaranFinancialResponseDto searchHamkaranFinancialResponseBySearchQuery(HamkaranFinancialResponseDto hamkaranFinancialResponseDto);

    HamkaranDeletedFinancialResponseDto searchHamkaranDeletedFinancialResponseBySearchQuery(HamkaranDeletedFinancialResponseDto hamkaranDeletedFinancialResponseDto);
}
