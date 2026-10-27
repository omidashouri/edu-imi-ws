package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.services.SwaggerCaptchaService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Validates the Swagger login CAPTCHA before Spring Security authenticates credentials.
 */
public class SwaggerCaptchaFilter extends OncePerRequestFilter {

    private final SwaggerCaptchaService captchaService;

    public SwaggerCaptchaFilter(SwaggerCaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (!isSwaggerLoginPost(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);
        String submitted = request.getParameter(SwaggerCaptchaService.FORM_FIELD);
        boolean ok = session != null && captchaService.validateAndClear(session, submitted);
        if (!ok) {
            response.sendRedirect(request.getContextPath() + "/swagger-login?captchaError");
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean isSwaggerLoginPost(HttpServletRequest request) {
        if (!HttpMethod.POST.matches(request.getMethod())) {
            return false;
        }
        String path = request.getServletPath();
        if (path == null || path.isEmpty()) {
            path = request.getRequestURI();
            String contextPath = request.getContextPath();
            if (contextPath != null && !contextPath.isEmpty() && path.startsWith(contextPath)) {
                path = path.substring(contextPath.length());
            }
        }
        return "/swagger-login".equals(path);
    }
}
