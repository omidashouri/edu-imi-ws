package edu.imi.ir.eduimiws.exceptions.controllers;

import edu.imi.ir.eduimiws.exceptions.v2.ErrorEnum;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -2191734854416219718L;

    private final ErrorEnum errorEnum;
    private final String detail;

    public BadRequestException() {
        this(ErrorEnum.BAD_REQUEST);
    }

    public BadRequestException(ErrorEnum errorEnum) {
        this(null, errorEnum, null);
    }

    public BadRequestException(String message) {
        this(null, ErrorEnum.BAD_REQUEST, message);
    }

    public BadRequestException(String message, Throwable cause) {
        this(cause, ErrorEnum.BAD_REQUEST, message);
    }

    public BadRequestException(Throwable cause, ErrorEnum errorEnum, String detail) {
        super(detail != null ? detail : errorEnum.getKey(), cause);
        this.errorEnum = errorEnum;
        this.detail = detail;
    }
}
