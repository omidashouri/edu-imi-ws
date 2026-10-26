package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.models.dto.crm.AuthTokenDto;
import edu.imi.ir.eduimiws.models.request.RefreshTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;

public interface AuthTokenService {

    AuthTokenDto login(UserLoginRequestModel loginRequest);

    AuthTokenDto refresh(RefreshTokenRequestModel refreshTokenRequest);
}
