package com.sparta.pt;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionalExample {
    public static void main(String[] args) {
        //Something -> Stream -> "Real"
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "John",
                "Sarah",
                "James",
                "Alice",
                "Tom",
                "Tim",
                "Zoe",
                "Charlie",
                "David",
                "Emily"));
        names.stream()
                .map(String::toUpperCase)
                .peek(name -> System.out.println(name))
                .filter(name -> name.contains("O"))
                .forEach(System.out::println); //Method Reference
    }
}
