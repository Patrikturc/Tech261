package com.sparta.pt.springjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Custom Component
public class CustomCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from custom command line");
    }
}
