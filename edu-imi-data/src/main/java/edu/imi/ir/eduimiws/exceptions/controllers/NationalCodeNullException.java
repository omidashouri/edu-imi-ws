package edu.imi.ir.eduimiws.exceptions.controllers;

public class NationalCodeNullException extends RuntimeException {

    private static final long serialVersionUID = 2081314477850776092L;


    public NationalCodeNullException(){
        super();
    }
    public NationalCodeNullException(String message) {
        super(message);
    }
    public NationalCodeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
