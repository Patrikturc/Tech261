package com.sparta.pt.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class WebController {

    @GetMapping
    public String welcome(Model model){
        model.addAttribute("date", LocalDate.now());

        return "welcome";
    }
}