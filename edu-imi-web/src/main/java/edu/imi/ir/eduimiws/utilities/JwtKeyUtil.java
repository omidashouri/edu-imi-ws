package edu.imi.ir.eduimiws.utilities;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.security.VerifySecureDigestRequest;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * HMAC key bytes match jjwt 0.9 {@code signWith(HS512, secret)}: the secret is Base64-decoded
 * with JAXB {@link DatatypeConverter}, not {@code Keys.hmacShaKeyFor}.
 * <p>
 * jjwt 0.12 refuses that short key when it has to guess the algorithm, and its built-in HS512
 * also rejects keys shorter than 512 bits. {@link LegacyHs512} keeps the previous HS512 MAC
 * so existing tokens still verify.
 */
public final class JwtKeyUtil {

    private JwtKeyUtil() {
    }

    public static SecretKey hmacSha512Key(String secret) {
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(secret);
        return new SecretKeySpec(keyBytes, "HmacSHA512");
    }

    public static JwtBuilder sign(JwtBuilder builder, String secret) {
        return builder.signWith(hmacSha512Key(secret), LegacyHs512.INSTANCE);
    }

    public static JwtParser parser(String secret) {
        return Jwts.parser()
                .verifyWith(hmacSha512Key(secret))
                .sig().add(LegacyHs512.INSTANCE).and()
                .build();
    }

    /**
     * HS512 MAC that accepts the short secret this application already uses.
     * Registered on the parser under the same {@code HS512} id so verification
     * does not fall through to jjwt's length check.
     */
    private static final class LegacyHs512 implements SecureDigestAlgorithm<SecretKey, SecretKey> {

        private static final LegacyHs512 INSTANCE = new LegacyHs512();

        @Override
        public String getId() {
            return "HS512";
        }

        @Override
        public byte[] digest(SecureRequest<InputStream, SecretKey> request) {
            try {
                Mac mac = Mac.getInstance("HmacSHA512");
                mac.init(request.getKey());
                InputStream payload = request.getPayload();
                byte[] buf = new byte[1024];
                int len;
                while ((len = payload.read(buf)) != -1) {
                    if (len > 0) {
                        mac.update(buf, 0, len);
                    }
                }
                return mac.doFinal();
            } catch (Exception e) {
                throw new SecurityException("Unable to compute HS512 signature.", e);
            }
        }

        @Override
        public boolean verify(VerifySecureDigestRequest<SecretKey> request) {
            return MessageDigest.isEqual(request.getDigest(), digest(request));
        }
    }
}
