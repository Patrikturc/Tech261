package com.sparta.pt;

public class FizzBuzz {
    public static String getFizzBuzzFrom(int number){
        String fizzBuzzString = Integer.toString(number);
        if (number % 3 == 0){
            fizzBuzzString = "Fizz";
        }
        return fizzBuzzString;
    }
}
