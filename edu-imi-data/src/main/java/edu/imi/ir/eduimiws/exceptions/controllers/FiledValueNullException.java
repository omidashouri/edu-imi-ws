package edu.imi.ir.eduimiws.exceptions.controllers;

public class FiledValueNullException extends RuntimeException{

    private static final long serialVersionUID = 5979168518385347019L;

    public FiledValueNullException(){
        super();
    }
    public FiledValueNullException(String message) {
        super(message);
    }
    public FiledValueNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
