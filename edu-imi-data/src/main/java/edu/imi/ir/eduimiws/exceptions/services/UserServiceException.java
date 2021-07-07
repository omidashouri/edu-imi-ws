package edu.imi.ir.eduimiws.exceptions.services;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = -6380288900500629210L;

    public UserServiceException(String message) {
        super(message);
    }
}
