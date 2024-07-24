package com.sparta.pt.springweb.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @GetMapping("/error")
    public String handleException(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
