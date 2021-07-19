package edu.imi.ir.eduimiws.exceptions;


import edu.imi.ir.eduimiws.exceptions.controllers.*;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
import edu.imi.ir.eduimiws.exceptions.services.UserServiceException;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


//@ControllerAdvice
public class AppExceptionsHandler {

    String dateTime = LocalDateTime.now().toString();

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException exception,
                                                             WebRequest request) {
        ErrorMessage handleUserServiceExceptionMessage = new ErrorMessage(dateTime, HttpStatus.NOT_FOUND.toString(),
                exception.getMessage());
        return new ResponseEntity<>(handleUserServiceExceptionMessage, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> badRequest(Throwable throwable) {
        ErrorMessage badRequestMessage = new ErrorMessage(dateTime, HttpStatus.BAD_REQUEST.toString(),
                "Bad request");
        return new ResponseEntity<>(badRequestMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpClientErrorException.Conflict.class})
//    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?> conflict(Throwable throwable) {
        ErrorMessage conflictMessage = new ErrorMessage(dateTime, HttpStatus.CONFLICT.toString(),
                "Data requested already exist");
        return new ResponseEntity<>(conflictMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {Exception.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleOtherException(Exception exception,
                                                       WebRequest request) {
        ErrorMessage handleOtherExceptionMessage = new ErrorMessage(dateTime,
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage());
        return new ResponseEntity<>(handleOtherExceptionMessage, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointServiceException(NullPointerException exception,
                                                                  WebRequest request) {
        ErrorMessage handleNullPointServiceException = new ErrorMessage(dateTime,
                HttpStatus.NOT_FOUND.toString(), exception.getMessage());
        return new ResponseEntity<>(handleNullPointServiceException, new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RoleServiceException.class})
    public ResponseEntity<Object> handleRoleServiceException(RoleServiceException exception, WebRequest request) {
        ErrorMessage handleRoleServiceExceptionMessage = new ErrorMessage(dateTime,
                HttpStatus.CONFLICT.toString(), exception.getMessage());
        return new ResponseEntity<>(handleRoleServiceExceptionMessage, new HttpHeaders(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {NationalCodeNullException.class, NationalCodeRedundantException.class})
    public ResponseEntity<?> handleNationalCodeException(Exception exception, WebRequest request) {

        if (exception instanceof NationalCodeNullException) {
            NationalCodeNullException nCNE = (NationalCodeNullException) exception;
            return handleNationalCodeNullException(nCNE, dateTime, null, null, request);

        } else if (exception instanceof NationalCodeRedundantException) {
            NationalCodeRedundantException nCRE = (NationalCodeRedundantException) exception;
            return handleNationalCodeRedundantException(nCRE, dateTime, null, null, request);

        } else {
            return handleOtherException(exception, null);
        }
    }

    @ExceptionHandler(value = {FiledValueNullException.class})
    public ResponseEntity<?> handleFiledValueNullException(FiledValueNullException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.BAD_REQUEST.toString()
                        , exception.getMessage())
                , HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {InternalServerErrorException.class})
    public ResponseEntity<?> handleInternalServerErrorException(InternalServerErrorException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , exception.getMessage())
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.NOT_FOUND.toString()
                        , exception.getMessage())
                , HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = {ExpectationFailedException.class})
    public ResponseEntity<?> handleExpectationFailedException(ExpectationFailedException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.EXPECTATION_FAILED.toString()
                        , exception.getMessage())
                , HttpStatus.EXPECTATION_FAILED
        );
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.BAD_REQUEST.toString()
                        , exception.getMessage())
                , HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {NotAcceptableException.class})
    public ResponseEntity<?> handleNotAcceptableException(NotAcceptableException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.NOT_ACCEPTABLE.toString()
                        , exception.getMessage())
                , HttpStatus.NOT_ACCEPTABLE
        );
    }


    protected ResponseEntity<?> handleNationalCodeNullException(NationalCodeNullException exception,
                                                                String dateTime, HttpHeaders headers,
                                                                HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.BAD_REQUEST.toString()
                        , exception.getMessage())
                , HttpStatus.BAD_REQUEST
        );
    }

    protected ResponseEntity<?> handleNationalCodeRedundantException(NationalCodeRedundantException exception,
                                                                     String dateTime, HttpHeaders headers,
                                                                     HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.NOT_ACCEPTABLE.toString()
                        , exception.getMessage())
                , HttpStatus.NOT_ACCEPTABLE
        );
    }

}
