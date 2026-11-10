package edu.imi.ir.eduimiws.exceptions.v2;

import edu.imi.ir.eduimiws.exceptions.AppExceptionsHandler;
import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.models.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

/**
 * New error envelope ({@link RaiseError} / {@link Response}) for v2 APIs.
 * Scoped to {@code controllers.v2} so the same exception types (e.g.
 * {@link BadRequestException}) are never handled by both this advice and
 * {@link AppExceptionsHandler}.
 */
@RestControllerAdvice(basePackages = "edu.imi.ir.eduimiws.controllers.v2")
@Slf4j
@RequiredArgsConstructor
public class GeneralExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response<Object>> handleBadRequestException(BadRequestException e, Locale locale) {
        log.error("Bad Request Exception: {}", e.getMessage());
        return build(HttpStatus.BAD_REQUEST, e.getErrorEnum(), locale, e.getDetail(), null);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Response<Object>> handleConflictException(ConflictException e, Locale locale) {
        log.error("Conflict Exception: {}", e.getMessage());
        return build(HttpStatus.CONFLICT, e.getErrorEnum(), locale, null, null);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response<Object>> handleBusinessException(BusinessException e, Locale locale) {
        log.error("Business Exception: {}", e.getMessage());
        RaiseError raiseError = RaiseError.builder()
                .code(e.getErrorEnum().getCode())
                .message(messageSource.getMessage(e.getErrorEnum().getKey(), e.getMessageParams(), locale))
                .detail(e.getDetail())
                .build();
        return new ResponseEntity<>(Response.builder().raiseError(raiseError).build(),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response<Object>> handleNotFound(NotFoundException e, Locale locale) {
        return build(HttpStatus.NOT_FOUND, ErrorEnum.NOT_FOUND, locale, e.getMessage(), null);
    }

    private ResponseEntity<Response<Object>> build(HttpStatus status, ErrorEnum errorEnum, Locale locale,
                                                   String detailOverride, Object[] params) {
        String message = detailOverride != null && !detailOverride.isBlank()
                ? detailOverride
                : messageSource.getMessage(errorEnum.getKey(), params, locale);
        RaiseError raiseError = RaiseError.builder()
                .code(errorEnum.getCode())
                .message(message)
                .build();
        return new ResponseEntity<>(Response.builder().raiseError(raiseError).build(), status);
    }
}
