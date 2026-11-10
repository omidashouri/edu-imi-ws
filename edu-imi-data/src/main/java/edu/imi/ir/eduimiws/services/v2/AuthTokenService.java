package edu.imi.ir.eduimiws.services.v2;

import edu.imi.ir.eduimiws.models.dto.crm.v2.AuthTokenDto;
import edu.imi.ir.eduimiws.models.request.crm.v2.ClientTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.crm.v2.RefreshTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;

public interface AuthTokenService {

    AuthTokenDto login(UserLoginRequestModel loginRequest);

    AuthTokenDto clientLogin(ClientTokenRequestModel clientTokenRequest);

    AuthTokenDto refresh(RefreshTokenRequestModel refreshTokenRequest);
}
