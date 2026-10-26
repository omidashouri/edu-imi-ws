package edu.imi.ir.eduimiws.controllers.v1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerLoginController {

    @GetMapping("/swagger-login")
    public String login() {
        return "swagger/login";
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
