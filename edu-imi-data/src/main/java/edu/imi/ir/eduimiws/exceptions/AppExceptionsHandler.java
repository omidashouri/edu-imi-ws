package edu.imi.ir.eduimiws.exceptions;


import edu.imi.ir.eduimiws.exceptions.controllers.*;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
import edu.imi.ir.eduimiws.exceptions.services.UserServiceException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.*;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.utilities.BehdadException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(value = {DateParseException.class})
    public ResponseEntity<?> handleParseException(DateParseException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.NOT_ACCEPTABLE.toString()
                        , exception.getMessage())
                , HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(value = {ExpiredJwtTokenException.class})
    public ResponseEntity<?> handleExpiredJwtTokenException(ExpiredJwtException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.UNAUTHORIZED.toString(),
                        "token is expired!")
                , HttpStatus.UNAUTHORIZED
        );
    }

    //    Behdad Exception --->
    @ExceptionHandler(value = {IdentifierIsExistException.class})
    public ResponseEntity<?> handleIdentifierIsExistException(IdentifierIsExistException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString(),
                         BehdadException._IdentifierIsExist.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {IdentifierIsNotEffectiveException.class})
    public ResponseEntity<?> handleIdentifierIsNotEffectiveException(IdentifierIsNotEffectiveException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._IdentifierIsNotEffective.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {IdentifierNotFoundException.class})
    public ResponseEntity<?> handleIdentifierNotFoundException(IdentifierNotFoundException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._IdentifierNotFound.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidAccountNumberException.class})
    public ResponseEntity<?> handleInvalidAccountNumberException(InvalidAccountNumberException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidAccountNumber.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidAmountException.class})
    public ResponseEntity<?> handleInvalidAmountException(InvalidAmountException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidAmount.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidCredentialException.class})
    public ResponseEntity<?> handleInvalidCredentialException(InvalidCredentialException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidCredential.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidDateException.class})
    public ResponseEntity<?> handleInvalidDateException(InvalidDateException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidDate.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierCodeException.class})
    public ResponseEntity<?> handleInvalidIdentifierCodeException(InvalidIdentifierCodeException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidIdentifierCode.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierControlTypeException.class})
    public ResponseEntity<?> handleInvalidIdentifierControlTypeException(InvalidIdentifierControlTypeException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidIdentifierControlType.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierException.class})
    public ResponseEntity<?> handleInvalidIdentifierException(InvalidIdentifierException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidIdentifier.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierTypeException.class})
    public ResponseEntity<?> handleInvalidIdentifierTypeException(InvalidIdentifierTypeException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidIdentifierType.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidPageNumberException.class})
    public ResponseEntity<?> handleInvalidPageNumberException(InvalidPageNumberException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidPageNumber.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidPageSizeException.class})
    public ResponseEntity<?> handleInvalidPageSizeException(InvalidPageSizeException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidPageSize.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidTransactionTypeException.class})
    public ResponseEntity<?> handleInvalidTransactionTypeException(InvalidTransactionTypeException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._InvalidTransactionType.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {PageSizeIsTooMuchException.class})
    public ResponseEntity<?> handlePageSizeIsTooMuchException(PageSizeIsTooMuchException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._PageSizeIsTooMuch.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {PasswordIsNotStrongException.class})
    public ResponseEntity<?> handlePasswordIsNotStrongException(PasswordIsNotStrongException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._PasswordIsNotStrong.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }
    @ExceptionHandler(value = {TooMuchAccountsException.class})
    public ResponseEntity<?> handleTooMuchAccountsException(TooMuchAccountsException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._TooMuchAccounts.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToAuthenticateException.class})
    public ResponseEntity<?> handleUnableToAuthenticateException(UnableToAuthenticateException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._UnableToAuthenticate.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToChangePasswordException.class})
    public ResponseEntity<?> handleUnableToChangePasswordException(UnableToChangePasswordException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._UnableToChangePassword.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToGenerateIdentifierException.class})
    public ResponseEntity<?> handleUnableToGenerateIdentifierException(UnableToGenerateIdentifierException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._UnableToGenerateIdentifier.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToGetTransactionsException.class})
    public ResponseEntity<?> handleUnableToGetTransactionsException(UnableToGetTransactionsException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._UnableToGetTransactions.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UserTemporarilySuspendedException.class})
    public ResponseEntity<?> handleUserTemporarilySuspendedException(UserTemporarilySuspendedException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._UserTemporarilySuspended.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {VerhoeffException.class})
    public ResponseEntity<?> handleVerhoeffException(VerhoeffException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._Verhoeff.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {TransactionDoesNotBelongToAccountException.class})
    public ResponseEntity<?> handleTransactionDoesNotBelongToAccountException(TransactionDoesNotBelongToAccountException exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException._TransactionDoesNotBelongToAccount.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    //   <--- Behdad Exception

}
