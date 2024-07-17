package com.sparta.pt.springrest.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception e, HttpServletRequest request) {
        return new ResponseEntity<>(new ErrorResponse("NOT_FOUND", e.getMessage(), request.getRequestURL().toString()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IAmATeapotException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ResponseEntity<ErrorResponse> handleIAmATeapotException(Exception e, HttpServletRequest request) {
        return new ResponseEntity<>(new ErrorResponse("I_am_a_Teapot", e.getMessage(), request.getRequestURL().toString()), HttpStatus.I_AM_A_TEAPOT);
    }

    private record ErrorResponse(String error, String message, String url) {}
}
