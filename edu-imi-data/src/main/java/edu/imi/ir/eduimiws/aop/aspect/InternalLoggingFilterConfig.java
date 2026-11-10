package edu.imi.ir.eduimiws.aop.aspect;

import edu.imi.ir.eduimiws.services.crm.v2.InternalRequestLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import tools.jackson.databind.json.JsonMapper;

/**
 * Registers {@link InternalRequestResponseLoggingFilter} for {@code /api/v1/*} and
 * {@code /api/v2/*} only. The filter itself is not a {@code @Component}, to avoid
 * Spring Boot auto-registration stacking on top of this scoped registration.
 */
@Configuration
@RequiredArgsConstructor
public class InternalLoggingFilterConfig {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final InternalRequestLogService internalRequestLogService;
    private final JsonMapper jsonMapper;
    private final MessageSource messageSource;

    @Bean
    public FilterRegistrationBean<InternalRequestResponseLoggingFilter> internalRequestResponseLoggingFilter() {
        InternalRequestResponseLoggingFilter filter = new InternalRequestResponseLoggingFilter(
                requestMappingHandlerMapping, internalRequestLogService, jsonMapper, messageSource);
        FilterRegistrationBean<InternalRequestResponseLoggingFilter> registration =
                new FilterRegistrationBean<>(filter);
        registration.addUrlPatterns("/api/v1/*", "/api/v2/*");
        registration.setName("internalRequestResponseLoggingFilter");
        return registration;
    }
}
