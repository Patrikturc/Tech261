package com.sparta.pt;

public class Program {
    public static void main(String[] args) { //entry point
        //statically typed language means that I can't assign different type to a certain type
        //refactoring is about improving code, without changing what the code does
        //for tomorrow, when should you and when shouldn't you refactor code
        int timeOfDay = 25; //Value that's held in memory, 3 properties: type, name, value
        //String[] greetingsList = {"Good morning!", "Good afternoon!", "Good evening!"};
        System.out.println(getGreeting(timeOfDay));
    }

    public static String getGreeting(int timeOfDay) {

//        String greeting;
//        if (timeOfDay >= 5 && timeOfDay <= 12) {
//            greeting = "Good morning!";
//        } else if (timeOfDay >= 12 && timeOfDay <= 18) {
//            greeting = "Good afternoon!";
//        } else {
//            greeting = "Good evening!";
//        }
//        return greeting;
        return switch (timeOfDay) {
            case 5, 6, 7, 8, 9, 10, 11 -> "Good morning!";
            case 12, 13, 14, 15, 16, 17 -> "Good afternoon!";
            case 18, 19, 20, 21, 22, 23 -> "Good evening!";
            case 0, 1, 2, 3, 4 -> "You should sleep!!!";
            default -> "Incorrect hour, please insert a number between 0 and 23";
        };
    }
}