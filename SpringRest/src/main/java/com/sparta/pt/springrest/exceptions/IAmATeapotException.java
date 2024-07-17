package com.sparta.pt.springrest.exceptions;

public class IAmATeapotException extends RuntimeException {
    public IAmATeapotException(String msg) {
        super(msg);
    }
}
