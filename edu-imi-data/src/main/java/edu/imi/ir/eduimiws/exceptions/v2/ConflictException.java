package edu.imi.ir.eduimiws.exceptions.v2;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException {

    private final ErrorEnum errorEnum;

    public ConflictException(ErrorEnum errorEnum) {
        super(errorEnum.getKey());
        this.errorEnum = errorEnum;
    }
}
