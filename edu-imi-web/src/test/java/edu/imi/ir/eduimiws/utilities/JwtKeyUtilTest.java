package edu.imi.ir.eduimiws.utilities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JwtKeyUtilTest {

    @Test
    void signsAndParsesTheShortLegacySecret() {
        String secret = "123456789asdqwe";
        String token = JwtKeyUtil.sign(Jwts.builder()
                        .subject("user")
                        .claim("userPublicId", "abc")
                        .expiration(new Date(System.currentTimeMillis() + 60_000)),
                secret).compact();

        Claims claims = JwtKeyUtil.parser(secret)
                .parseSignedClaims(token)
                .getPayload();

        assertEquals("user", claims.getSubject());
        assertEquals("abc", claims.get("userPublicId"));
    }
}
