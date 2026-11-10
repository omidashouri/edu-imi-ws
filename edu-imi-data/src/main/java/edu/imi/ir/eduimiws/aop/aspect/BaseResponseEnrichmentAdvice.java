package edu.imi.ir.eduimiws.aop.aspect;

import edu.imi.ir.eduimiws.models.response.Response;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDate;

@RestControllerAdvice(basePackages = {"edu.imi.ir.eduimiws.controllers"})
public class BaseResponseEnrichmentAdvice implements ResponseBodyAdvice<Object> {

    private static final String TRACE_ID_MDC_KEY = "traceId";

    @Override
    public boolean supports(@NonNull MethodParameter returnType,
                            @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        Class<?> nestedType = resolveNestedResponseDtoType(returnType);
        return nestedType != null && BaseResponseDto.class.isAssignableFrom(nestedType);
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body,
                                  @NonNull MethodParameter returnType,
                                  @NonNull MediaType selectedContentType,
                                  @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NonNull ServerHttpRequest request,
                                  @NonNull ServerHttpResponse response) {
        if (body == null || !(request instanceof ServletServerHttpRequest servletRequest)) {
            return body;
        }
        HttpServletRequest httpRequest = servletRequest.getServletRequest();
        if (!isPostOrPut(httpRequest)) {
            return body;
        }

        BaseResponseDto responseDto = unwrapBaseResponseDto(body);
        if (responseDto == null) {
            return body;
        }

        Object requestIdAttr = httpRequest.getAttribute(BaseRequestEnrichmentAdvice.REQUEST_ID_ATTRIBUTE);
        if (requestIdAttr instanceof String requestId && StringUtils.hasText(requestId)) {
            responseDto.setRequestId(requestId);
        }

        String traceId = MDC.get(TRACE_ID_MDC_KEY);
        if (StringUtils.hasText(traceId)) {
            responseDto.setTraceNo(traceId);
        }

        responseDto.setEffectiveDate(LocalDate.now());
        return body;
    }

    @Nullable
    private static Class<?> resolveNestedResponseDtoType(MethodParameter returnType) {
        ResolvableType type = ResolvableType.forMethodParameter(returnType);

        if (ResponseEntity.class.isAssignableFrom(type.toClass())) {
            type = type.getGeneric(0);
        }

        if (Response.class.isAssignableFrom(type.toClass())) {
            type = type.getGeneric(0);
            return type.resolve();
        }

        Class<?> resolved = type.resolve();
        if (resolved != null && BaseResponseDto.class.isAssignableFrom(resolved)) {
            return resolved;
        }
        return null;
    }

    @Nullable
    private static BaseResponseDto unwrapBaseResponseDto(Object body) {
        if (body instanceof Response<?> envelope && envelope.responseDto() instanceof BaseResponseDto dto) {
            return dto;
        }
        if (body instanceof BaseResponseDto dto) {
            return dto;
        }
        return null;
    }

    private static boolean isPostOrPut(HttpServletRequest request) {
        String method = request.getMethod();
        return "POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method);
    }
}
