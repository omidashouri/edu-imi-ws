package edu.imi.ir.eduimiws.exceptions.controllers;

public class NationalCodeRedundantException extends RuntimeException {

    private static final long serialVersionUID = -2644139174257754193L;


    public NationalCodeRedundantException(){
        super();
    }
    public NationalCodeRedundantException(String message) {
        super(message);
    }
    public NationalCodeRedundantException(String message, Throwable cause) {
        super(message, cause);
    }
}
