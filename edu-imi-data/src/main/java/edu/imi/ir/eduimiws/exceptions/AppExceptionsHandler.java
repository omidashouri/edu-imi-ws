package edu.imi.ir.eduimiws.exceptions;


import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler {

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException exception,
                                                             WebRequest request) {
        ErrorMessage handleUserServiceExceptionMessage = new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString(),
                exception.getMessage());
        return new ResponseEntity<>(handleUserServiceExceptionMessage, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> badRequest(Throwable throwable) {
        ErrorMessage badRequestMessage = new ErrorMessage(new Date(), HttpStatus.BAD_REQUEST.toString(),
                "Bad request");
        return new ResponseEntity<>(badRequestMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpClientErrorException.Conflict.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?> conflict(Throwable throwable) {
        ErrorMessage conflictMessage = new ErrorMessage(new Date(), HttpStatus.CONFLICT.toString(),
                "Data requested already exist");
        return new ResponseEntity<>(conflictMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleOtherException(Exception exception,
                                                       WebRequest request) {
        ErrorMessage handleOtherExceptionMessage = new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage());
        return new ResponseEntity<>(handleOtherExceptionMessage, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
