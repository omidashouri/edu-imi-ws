package edu.imi.ir.eduimiws.exceptions;


import edu.imi.ir.eduimiws.exceptions.controllers.*;
import edu.imi.ir.eduimiws.exceptions.services.RoleServiceException;
import edu.imi.ir.eduimiws.exceptions.services.UserServiceException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.*;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.utilities.behdad.BehdadException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


//@ControllerAdvice
@Slf4j
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
        log.error(BehdadException.IDENTIFIER_IS_EXIST.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString(),
                         BehdadException.IDENTIFIER_IS_EXIST.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {IdentifierIsNotEffectiveException.class})
    public ResponseEntity<?> handleIdentifierIsNotEffectiveException(IdentifierIsNotEffectiveException exception, WebRequest request) {
        log.error(BehdadException.IDENTIFIER_IS_N0T_EFFECTIVE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.IDENTIFIER_IS_N0T_EFFECTIVE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {IdentifierNotFoundException.class})
    public ResponseEntity<?> handleIdentifierNotFoundException(IdentifierNotFoundException exception, WebRequest request) {
        log.error(BehdadException.IDENTIFIER_NOT_FOUND.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.IDENTIFIER_NOT_FOUND.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidAccountNumberException.class})
    public ResponseEntity<?> handleInvalidAccountNumberException(InvalidAccountNumberException exception, WebRequest request) {
        log.error(BehdadException.INVALID_ACCOUNT_NUMBER.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_ACCOUNT_NUMBER.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidAmountException.class})
    public ResponseEntity<?> handleInvalidAmountException(InvalidAmountException exception, WebRequest request) {
        log.error(BehdadException.INVALID_AMOUNT.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_AMOUNT.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidCredentialException.class})
    public ResponseEntity<?> handleInvalidCredentialException(InvalidCredentialException exception, WebRequest request) {
        log.error(BehdadException.INVALID_CREDENTIAL.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_CREDENTIAL.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidDateException.class})
    public ResponseEntity<?> handleInvalidDateException(InvalidDateException exception, WebRequest request) {
        log.error(BehdadException.INVALID_DATE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_DATE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierCodeException.class})
    public ResponseEntity<?> handleInvalidIdentifierCodeException(InvalidIdentifierCodeException exception, WebRequest request) {
        log.error(BehdadException.INVALID_IDENTIFIER_CODE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_IDENTIFIER_CODE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierControlTypeException.class})
    public ResponseEntity<?> handleInvalidIdentifierControlTypeException(InvalidIdentifierControlTypeException exception, WebRequest request) {
        log.error(BehdadException.INVALID_IDENTIFIER_CONTROL_TYPE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_IDENTIFIER_CONTROL_TYPE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierException.class})
    public ResponseEntity<?> handleInvalidIdentifierException(InvalidIdentifierException exception, WebRequest request) {
        log.error(BehdadException.INVALID_IDENTIFIER.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_IDENTIFIER.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidIdentifierTypeException.class})
    public ResponseEntity<?> handleInvalidIdentifierTypeException(InvalidIdentifierTypeException exception, WebRequest request) {
        log.error(BehdadException.INVALID_IDENTIFIER_TYPE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_IDENTIFIER_TYPE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidPageNumberException.class})
    public ResponseEntity<?> handleInvalidPageNumberException(InvalidPageNumberException exception, WebRequest request) {
        log.error(BehdadException.INVALID_PAGE_NUMBER.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_PAGE_NUMBER.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidPageSizeException.class})
    public ResponseEntity<?> handleInvalidPageSizeException(InvalidPageSizeException exception, WebRequest request) {
        log.error(BehdadException.INVALID_PAGE_SIZE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_PAGE_SIZE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidTransactionTypeException.class})
    public ResponseEntity<?> handleInvalidTransactionTypeException(InvalidTransactionTypeException exception, WebRequest request) {
        log.error(BehdadException.INVALID_TRANSACTION_TYPE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_TRANSACTION_TYPE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {PageSizeIsTooMuchException.class})
    public ResponseEntity<?> handlePageSizeIsTooMuchException(PageSizeIsTooMuchException exception, WebRequest request) {
        log.error(BehdadException.PAGE_SIZE_IS_TOO_MUCH.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.PAGE_SIZE_IS_TOO_MUCH.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {PasswordIsNotStrongException.class})
    public ResponseEntity<?> handlePasswordIsNotStrongException(PasswordIsNotStrongException exception, WebRequest request) {
        log.error(BehdadException.PASSWORD_IS_NOT_STRONG.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.PASSWORD_IS_NOT_STRONG.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }
    @ExceptionHandler(value = {TooMuchAccountsException.class})
    public ResponseEntity<?> handleTooMuchAccountsException(TooMuchAccountsException exception, WebRequest request) {
        log.error(BehdadException.TOO_MUCH_ACCOUNTS.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.TOO_MUCH_ACCOUNTS.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToAuthenticateException.class})
    public ResponseEntity<?> handleUnableToAuthenticateException(UnableToAuthenticateException exception, WebRequest request) {
        log.error(BehdadException.UNABLE_TO_AUTHENTICATE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.UNABLE_TO_AUTHENTICATE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToChangePasswordException.class})
    public ResponseEntity<?> handleUnableToChangePasswordException(UnableToChangePasswordException exception, WebRequest request) {
        log.error(BehdadException.UNABLE_TO_CHANGE_PASSWORD.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.UNABLE_TO_CHANGE_PASSWORD.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToGenerateIdentifierException.class})
    public ResponseEntity<?> handleUnableToGenerateIdentifierException(UnableToGenerateIdentifierException exception, WebRequest request) {
        log.error(BehdadException.UNABLE_TO_GENERATE_IDENTIFIER.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.UNABLE_TO_GENERATE_IDENTIFIER.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToGetTransactionsException.class})
    public ResponseEntity<?> handleUnableToGetTransactionsException(UnableToGetTransactionsException exception, WebRequest request) {
        log.error(BehdadException.UNABLE_TO_GET_TRANSACTIONS.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.UNABLE_TO_GET_TRANSACTIONS.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UserTemporarilySuspendedException.class})
    public ResponseEntity<?> handleUserTemporarilySuspendedException(UserTemporarilySuspendedException exception, WebRequest request) {
        log.error(BehdadException.USER_TEMPORARILY_SUSPENDED.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.USER_TEMPORARILY_SUSPENDED.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {VerhoeffException.class})
    public ResponseEntity<?> handleVerhoeffException(VerhoeffException exception, WebRequest request) {
        log.error(BehdadException.VERHOEFF.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.VERHOEFF.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {TransactionDoesNotBelongToAccountException.class})
    public ResponseEntity<?> handleTransactionDoesNotBelongToAccountException(TransactionDoesNotBelongToAccountException exception, WebRequest request) {
        log.error(BehdadException.TRANSACTION_DOES_NOT_BELONG_T0_ACCOUNT.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.TRANSACTION_DOES_NOT_BELONG_T0_ACCOUNT.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InappropriateIdentifierException.class})
    public ResponseEntity<?> handleInappropriateIdentifierException(InappropriateIdentifierException exception, WebRequest request) {
        log.error(BehdadException.INAPPROPRIATE_IDENTIFIER.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INAPPROPRIATE_IDENTIFIER.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidAccountCredentialException.class})
    public ResponseEntity<?> handleInvalidAccountCredentialException(InvalidAccountCredentialException exception, WebRequest request) {
        log.error(BehdadException.INVALID_ACCOUNT_CREDENTIAL.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_ACCOUNT_CREDENTIAL.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToGenerateNewIdentifierException.class})
    public ResponseEntity<?> handleUnableToGenerateNewIdentifierException(UnableToGenerateNewIdentifierException exception, WebRequest request) {
        log.error(BehdadException.UNABLE_T0_GENERATE_NEW_IDENTIFIER.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.UNABLE_T0_GENERATE_NEW_IDENTIFIER.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {InvalidCertificateException.class})
    public ResponseEntity<?> handleInvalidCertificateException(InvalidCertificateException exception, WebRequest request) {
        log.error(BehdadException.INVALID_CERTIFICATE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.INVALID_CERTIFICATE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {UnableToGetClientCertificateInfoException.class})
    public ResponseEntity<?> handleUnableToGetClientCertificateInfoException(UnableToGetClientCertificateInfoException exception, WebRequest request) {
        log.error(BehdadException.UNABLE_TO_GET_CLIENT_CERTIFICATE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.UNABLE_TO_GET_CLIENT_CERTIFICATE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {ExpiredOrNotValidCertificateException.class})
    public ResponseEntity<?> handleExpiredOrNotValidCertificateException(ExpiredOrNotValidCertificateException exception, WebRequest request) {
        log.error(BehdadException.EXPIRE_OR_NOT_VALID_CERTIFICATE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.EXPIRE_OR_NOT_VALID_CERTIFICATE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {PasswordShouldBeChangeException.class})
    public ResponseEntity<?> handlePasswordShouldBeChangeException(PasswordShouldBeChangeException exception, WebRequest request) {
        log.error(BehdadException.PASSWORD_SHOULD_BE_CHANGE.getMessage_en());
        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.PASSWORD_SHOULD_BE_CHANGE.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(value = {TransactionDoesNotBelongToAccount.class})
    public ResponseEntity<?> handleTransactionDoesNotBelongToAccount(TransactionDoesNotBelongToAccount exception, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(dateTime, HttpStatus.METHOD_NOT_ALLOWED.toString()
                        , BehdadException.TRANSACTION_DOES_NOT_BELONG_T0_ACCOUNT.getMessage_fa())
                , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    //   <--- Behdad Exception


}
