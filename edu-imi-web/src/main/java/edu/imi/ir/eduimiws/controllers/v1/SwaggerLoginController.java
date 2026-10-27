package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.services.SwaggerCaptchaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SwaggerLoginController {

    private final SwaggerCaptchaService captchaService;

    public SwaggerLoginController(SwaggerCaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @GetMapping("/swagger-login")
    public String login() {
        return "swagger/login";
    }

    @GetMapping("/swagger-captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        byte[] png = captchaService.createCaptchaPng(session);
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-store, no-cache, must-revalidate");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.setContentLength(png.length);
        response.getOutputStream().write(png);
    }

    /**
     * Ends the Swagger browser session when a tab/window was closed and reopened
     * with a leftover session cookie.
     */
    @GetMapping("/swagger-session-end")
    public String endSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return "redirect:/swagger-login";
    }
}
