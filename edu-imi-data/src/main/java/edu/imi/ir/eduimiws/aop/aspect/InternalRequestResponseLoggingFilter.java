package edu.imi.ir.eduimiws.aop.aspect;

import edu.imi.ir.eduimiws.aop.annotation.LoggedOperation;
import edu.imi.ir.eduimiws.exceptions.v2.ConflictException;
import edu.imi.ir.eduimiws.exceptions.v2.ErrorEnum;
import edu.imi.ir.eduimiws.exceptions.v2.RaiseError;
import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.models.dto.record.v2.InternalRequestResponseLogData;
import edu.imi.ir.eduimiws.models.response.Response;
import edu.imi.ir.eduimiws.services.crm.v2.InternalRequestLogService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.ContentCachingResponseWrapper;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
public class InternalRequestResponseLoggingFilter extends OncePerRequestFilter {

    static final String CLAIM_ID_ATTRIBUTE = "edu.imi.ir.eduimiws.internalRequestLogClaimId";
    private static final int OPERATOR_ID_MAX_LENGTH = 8;

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final InternalRequestLogService internalRequestLogService;
    private final JsonMapper jsonMapper;
    private final MessageSource messageSource;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        if (!"POST".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }

        LoggedOperation loggedOperation = resolveLoggedOperation(request);
        if (loggedOperation == null) {
            filterChain.doFilter(request, response);
            return;
        }

        CachedBodyHttpServletRequest cachedRequest = new CachedBodyHttpServletRequest(request);
        String rawRequestBody = new String(cachedRequest.getCachedBody(), StandardCharsets.UTF_8);
        String requestId;
        try {
            requestId = extractRequestId(rawRequestBody);
        } catch (BadRequestException e) {
            writeErrorResponse(response, cachedRequest, HttpStatus.BAD_REQUEST, e);
            return;
        }

        if (requestId == null || requestId.isBlank()) {
            writeErrorResponse(response, cachedRequest, HttpStatus.BAD_REQUEST,
                    new BadRequestException(ErrorEnum.REQUEST_ID_INVALID));
            return;
        }

        Long claimId;
        try {
            claimId = internalRequestLogService.claimRequest(new InternalRequestResponseLogData(
                    loggedOperation.value().name(),
                    cachedRequest.getRequestURI(),
                    cachedRequest.getMethod(),
                    cachedRequest.getQueryString(),
                    requestId,
                    resolveOperatorId(cachedRequest),
                    cachedRequest.getRemoteAddr(),
                    rawRequestBody.isBlank() ? null : rawRequestBody));
            cachedRequest.setAttribute(CLAIM_ID_ATTRIBUTE, claimId);
        } catch (ConflictException e) {
            writeErrorResponse(response, cachedRequest, HttpStatus.CONFLICT, e);
            return;
        }

        ContentCachingResponseWrapper cachedResponse = new ContentCachingResponseWrapper(response);
        try {
            filterChain.doFilter(cachedRequest, cachedResponse);
        } finally {
            persistResponse(cachedRequest, cachedResponse, claimId);
            cachedResponse.copyBodyToResponse();
        }
    }

    /**
     * Resolve operator id from JWT / {@link SecurityContextHolder}. Truncates to
     * {@value #OPERATOR_ID_MAX_LENGTH} to match {@code TBL_INTERNAL_REQUEST_LOG.OPERATOR_ID}.
     */
    protected String resolveOperatorId(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        String name = authentication.getName();
        if (name == null || name.isBlank() || "anonymousUser".equalsIgnoreCase(name)) {
            return null;
        }
        return name.length() <= OPERATOR_ID_MAX_LENGTH
                ? name
                : name.substring(0, OPERATOR_ID_MAX_LENGTH);
    }

    private void persistResponse(CachedBodyHttpServletRequest cachedRequest,
                                 ContentCachingResponseWrapper cachedResponse, Long claimId) {
        try {
            byte[] responseBytes = cachedResponse.getContentAsByteArray();
            String responseJson = responseBytes.length == 0 ? null : new String(responseBytes, StandardCharsets.UTF_8);
            internalRequestLogService.logResponse(claimId, cachedResponse.getStatus(), responseJson);
        } catch (Exception e) {
            log.error("Failed to persist internal response log for claim id={} uri={}",
                    claimId, cachedRequest.getRequestURI(), e);
        }
    }

    private LoggedOperation resolveLoggedOperation(HttpServletRequest request) {
        try {
            HandlerExecutionChain chain = requestMappingHandlerMapping.getHandler(request);
            if (chain != null && chain.getHandler() instanceof HandlerMethod handlerMethod) {
                return AnnotatedElementUtils.findMergedAnnotation(handlerMethod.getMethod(), LoggedOperation.class);
            }
        } catch (Exception e) {
            log.debug("Could not resolve handler method while checking for @LoggedOperation: {}", e.getMessage());
        }
        return null;
    }

    private String extractRequestId(String rawRequestBody) {
        if (rawRequestBody == null || rawRequestBody.isBlank()) {
            return null;
        }
        try {
            JsonNode root = jsonMapper.readTree(rawRequestBody);
            JsonNode requestIdNode = root.get("requestId");
            return (requestIdNode == null || requestIdNode.isNull()) ? null : requestIdNode.asText();
        } catch (JacksonException e) {
            throw new BadRequestException(ErrorEnum.REQUEST_ID_INVALID);
        }
    }

    private void writeErrorResponse(HttpServletResponse response, HttpServletRequest request,
                                    HttpStatus status, RuntimeException exception) throws IOException {
        ErrorEnum errorEnum = exception instanceof ConflictException conflict
                ? conflict.getErrorEnum()
                : ((BadRequestException) exception).getErrorEnum();
        Locale locale = RequestContextUtils.getLocale(request);
        RaiseError raiseError = RaiseError.builder()
                .code(errorEnum.getCode())
                .message(messageSource.getMessage(errorEnum.getKey(), null, locale))
                .build();
        Response<Object> body = Response.builder().raiseError(raiseError).build();
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(jsonMapper.writeValueAsString(body));
    }
}
