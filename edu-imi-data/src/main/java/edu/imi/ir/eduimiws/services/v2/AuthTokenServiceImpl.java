package edu.imi.ir.eduimiws.services.v2;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.models.dto.crm.v2.AuthTokenDto;
import edu.imi.ir.eduimiws.models.request.crm.v2.ClientTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.crm.v2.RefreshTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import edu.imi.ir.eduimiws.models.user.MyErpUser;
import edu.imi.ir.eduimiws.services.crm.v2.ClientApiService;
import edu.imi.ir.eduimiws.utilities.JwtKeyUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

@Service
@Slf4j
public class AuthTokenServiceImpl implements AuthTokenService {

    private static final String CLAIM_USER_PUBLIC_ID = "userPublicId";
    private static final String CLAIM_TOKEN_TYPE = "tokenType";
    private static final String REFRESH_TOKEN_TYPE = "refresh";
    private static final String ACCESS_TOKEN_TYPE = "Bearer";

    private final AuthenticationManager authenticationManager1;
    private final ClientApiService clientApiService;
    private final String tokenSecret;
    private final String expirationTime;
    private final String refreshTokenSecret;
    private final String refreshTokenExpirationTime;

    public AuthTokenServiceImpl(AuthenticationManager authenticationManager1,
                                 ClientApiService clientApiService,
                                 @Value("${token.secret}") String tokenSecret,
                                 @Value("${expiration.time}") String expirationTime,
                                 @Value("${refresh.token.secret}") String refreshTokenSecret,
                                 @Value("${refresh.token.expiration.time}") String refreshTokenExpirationTime) {
        this.authenticationManager1 = authenticationManager1;
        this.clientApiService = clientApiService;
        this.tokenSecret = tokenSecret;
        this.expirationTime = expirationTime;
        this.refreshTokenSecret = refreshTokenSecret;
        this.refreshTokenExpirationTime = refreshTokenExpirationTime;
    }

    @Override
    public AuthTokenDto login(UserLoginRequestModel loginRequest) {
        String role = loginRequest != null && loginRequest.getRole() != null
                ? loginRequest.getRole() : "ROLE_ANONYMOUS";
        log.info("AuthTokenService.login - username: {}, role: {}",
                loginRequest != null ? loginRequest.getUsername() : null, role);

        if (loginRequest == null || loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
            throw new BadRequestException("username and password are required");
        }

        Authentication authentication = authenticationManager1.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(role))));

        String username = ((User) authentication.getPrincipal()).getUsername();
        String userPublicId = ((MyErpUser) authentication.getPrincipal()).getUserPublicId();
        AuthTokenDto result = issueTokens(username, userPublicId);
        log.info("AuthTokenService.login - result: userPublicId={}, tokenType={}, tokensIssued=[REDACTED], accessTokenExpiresIn={}, refreshTokenExpiresIn={}",
                result.getUserPublicId(), result.getTokenType(),
                result.getAccessTokenExpiresIn(), result.getRefreshTokenExpiresIn());
        return result;
    }

    @Override
    public AuthTokenDto clientLogin(ClientTokenRequestModel clientTokenRequest) {
        log.info("AuthTokenService.clientLogin - credentials: [REDACTED]");

        if (clientTokenRequest == null) {
            throw new BadRequestException("request body is required");
        }

        PersonApiEntity personApi = clientApiService
                .authenticateByCredentialsBase64(clientTokenRequest.getCredentials());

        String username = personApi.getUserName();
        String userPublicId = personApi.getPersonPublicId();
        if (username == null || username.isBlank() || userPublicId == null || userPublicId.isBlank()) {
            throw new BadRequestException("linked person api is incomplete");
        }

        AuthTokenDto result = issueTokens(username, userPublicId);
        log.info("AuthTokenService.clientLogin - result: username={}, userPublicId={}, tokenType={}, tokensIssued=[REDACTED], accessTokenExpiresIn={}, refreshTokenExpiresIn={}",
                username, result.getUserPublicId(), result.getTokenType(),
                result.getAccessTokenExpiresIn(), result.getRefreshTokenExpiresIn());
        return result;
    }

    @Override
    public AuthTokenDto refresh(RefreshTokenRequestModel refreshTokenRequest) {
        log.info("AuthTokenService.refresh - refreshToken: [REDACTED]");

        if (refreshTokenRequest == null || refreshTokenRequest.getRefreshToken() == null
                || refreshTokenRequest.getRefreshToken().isBlank()) {
            throw new BadRequestException("refreshToken is required");
        }

        Claims claims;
        try {
            claims = JwtKeyUtil.parser(refreshTokenSecret)
                    .parseSignedClaims(refreshTokenRequest.getRefreshToken().trim())
                    .getPayload();
        } catch (ExpiredJwtException expiredJwtException) {
            throw new BadRequestException("refresh token is expired");
        } catch (JwtException | IllegalArgumentException _) {
            throw new BadRequestException("refresh token is invalid");
        }

        if (!REFRESH_TOKEN_TYPE.equals(claims.get(CLAIM_TOKEN_TYPE, String.class))) {
            throw new BadRequestException("refresh token is invalid");
        }

        String username = claims.getSubject();
        String userPublicId = claims.get(CLAIM_USER_PUBLIC_ID, String.class);
        if (username == null || userPublicId == null) {
            throw new BadRequestException("refresh token is invalid");
        }

        AuthTokenDto result = issueTokens(username, userPublicId);
        log.info("AuthTokenService.refresh - result: username={}, userPublicId={}, tokenType={}, tokensIssued=[REDACTED], accessTokenExpiresIn={}, refreshTokenExpiresIn={}",
                username, result.getUserPublicId(), result.getTokenType(),
                result.getAccessTokenExpiresIn(), result.getRefreshTokenExpiresIn());
        return result;
    }

    private AuthTokenDto issueTokens(String username, String userPublicId) {
        long accessTokenExpiresIn = Long.parseLong(expirationTime);
        long refreshTokenExpiresIn = Long.parseLong(refreshTokenExpirationTime);
        Instant now = Instant.now();

        String accessToken = JwtKeyUtil.sign(Jwts.builder()
                        .subject(username)
                        .claim(CLAIM_USER_PUBLIC_ID, userPublicId)
                        .expiration(Date.from(now.plusMillis(accessTokenExpiresIn))),
                tokenSecret)
                .compact();

        String refreshToken = JwtKeyUtil.sign(Jwts.builder()
                        .subject(username)
                        .claim(CLAIM_USER_PUBLIC_ID, userPublicId)
                        .claim(CLAIM_TOKEN_TYPE, REFRESH_TOKEN_TYPE)
                        .expiration(Date.from(now.plusMillis(refreshTokenExpiresIn))),
                refreshTokenSecret)
                .compact();

        return new AuthTokenDto(
                accessToken,
                refreshToken,
                userPublicId,
                ACCESS_TOKEN_TYPE,
                accessTokenExpiresIn,
                refreshTokenExpiresIn);
    }
}
