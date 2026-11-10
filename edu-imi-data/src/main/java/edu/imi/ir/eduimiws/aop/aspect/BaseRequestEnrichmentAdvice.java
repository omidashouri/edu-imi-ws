package edu.imi.ir.eduimiws.aop.aspect;

import edu.imi.ir.eduimiws.models.request.v2.BaseRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

@RestControllerAdvice(basePackages = {"edu.imi.ir.eduimiws.controllers"})
public class BaseRequestEnrichmentAdvice extends RequestBodyAdviceAdapter {

    public static final String REQUEST_ID_ATTRIBUTE = "edu.imi.ir.eduimiws.v2.requestId";

    @Override
    public boolean supports(@NonNull MethodParameter methodParameter,
                            @NonNull Type targetType,
                            @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return targetType instanceof Class<?> targetClass
                && BaseRequestDto.class.isAssignableFrom(targetClass);
    }

    @Override
    @NonNull
    public Object afterBodyRead(@NonNull Object body,
                                @NonNull HttpInputMessage inputMessage,
                                @NonNull MethodParameter parameter,
                                @NonNull Type targetType,
                                @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest servletRequest = currentRequest();
        if (servletRequest == null || !isPostOrPut(servletRequest)) {
            return body;
        }
        if (body instanceof BaseRequestDto baseRequestDto
                && StringUtils.hasText(baseRequestDto.getRequestId())) {
            servletRequest.setAttribute(REQUEST_ID_ATTRIBUTE, baseRequestDto.getRequestId());
        }
        return body;
    }

    private static boolean isPostOrPut(HttpServletRequest request) {
        String method = request.getMethod();
        return "POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method);
    }

    private static HttpServletRequest currentRequest() {
        if (RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes attrs) {
            return attrs.getRequest();
        }
        return null;
    }
}
