package edu.imi.ir.eduimiws.services;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Session-backed image CAPTCHA for Swagger browser login only.
 */
public interface SwaggerCaptchaService {

    String FORM_FIELD = "captcha";

    byte[] createCaptchaPng(HttpSession session) throws IOException;

    /**
     * Case-insensitive check. Clears the stored code after validation
     * so the image cannot be reused.
     */
    boolean validateAndClear(HttpSession session, String submitted);
}
