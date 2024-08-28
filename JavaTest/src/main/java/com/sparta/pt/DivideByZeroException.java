package com.sparta.pt;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("Cannot Divide By Zero");
    }

    public DivideByZeroException(String message) {
        super(message);
    }
}