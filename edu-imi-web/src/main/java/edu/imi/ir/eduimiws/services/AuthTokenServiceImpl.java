package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.models.dto.crm.AuthTokenDto;
import edu.imi.ir.eduimiws.models.request.RefreshTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import edu.imi.ir.eduimiws.models.user.MyErpUser;
import edu.imi.ir.eduimiws.utilities.AppProperties;
import edu.imi.ir.eduimiws.utilities.JwtKeyUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthTokenServiceImpl implements AuthTokenService {

    private static final String CLAIM_USER_PUBLIC_ID = "userPublicId";
    private static final String CLAIM_TOKEN_TYPE = "tokenType";
    private static final String REFRESH_TOKEN_TYPE = "refresh";
    private static final String ACCESS_TOKEN_TYPE = "Bearer";

    private final AuthenticationManager authenticationManager1;
    private final AppProperties appProperties;

    @Override
    public AuthTokenDto login(UserLoginRequestModel loginRequest) {
        if (loginRequest == null || loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
            throw new BadRequestException("username and password are required");
        }

        String role = loginRequest.getRole() != null ? loginRequest.getRole() : "ROLE_ANONYMOUS";
        Authentication authentication = authenticationManager1.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(role))));

        String username = ((User) authentication.getPrincipal()).getUsername();
        String userPublicId = ((MyErpUser) authentication.getPrincipal()).getUserPublicId();
        return issueTokens(username, userPublicId);
    }

    @Override
    public AuthTokenDto refresh(RefreshTokenRequestModel refreshTokenRequest) {
        if (refreshTokenRequest == null || refreshTokenRequest.getRefreshToken() == null
                || refreshTokenRequest.getRefreshToken().isBlank()) {
            throw new BadRequestException("refreshToken is required");
        }

        Claims claims;
        try {
            claims = JwtKeyUtil.parser(appProperties.getRefreshTokenSecret())
                    .parseSignedClaims(refreshTokenRequest.getRefreshToken().trim())
                    .getPayload();
        } catch (ExpiredJwtException expiredJwtException) {
            throw new BadRequestException("refresh token is expired");
        } catch (JwtException | IllegalArgumentException exception) {
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

        return issueTokens(username, userPublicId);
    }

    private AuthTokenDto issueTokens(String username, String userPublicId) {
        long accessTokenExpiresIn = Long.parseLong(appProperties.getExpirationTime());
        long refreshTokenExpiresIn = Long.parseLong(appProperties.getRefreshTokenExpirationTime());
        Instant now = Instant.now();

        String accessToken = JwtKeyUtil.sign(Jwts.builder()
                        .subject(username)
                        .claim(CLAIM_USER_PUBLIC_ID, userPublicId)
                        .expiration(Date.from(now.plusMillis(accessTokenExpiresIn))),
                appProperties.getTokenSecret())
                .compact();

        String refreshToken = JwtKeyUtil.sign(Jwts.builder()
                        .subject(username)
                        .claim(CLAIM_USER_PUBLIC_ID, userPublicId)
                        .claim(CLAIM_TOKEN_TYPE, REFRESH_TOKEN_TYPE)
                        .expiration(Date.from(now.plusMillis(refreshTokenExpiresIn))),
                appProperties.getRefreshTokenSecret())
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
