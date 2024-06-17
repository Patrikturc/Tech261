package com.sparta.pt;

public class Program {
    public static void main(String[] args) { //entry point
        //staticly typed language means that I can't assign different type to a certain type
        //refactoring is about improving code, without changing what the code does
        //for tomorrow, when should you and when shouldn't you refactor code
        int timeOfDay = 22; //Value that's held in memory, 3 properties: type, name, value
        System.out.println(getGreeting(timeOfDay));
    }

    private static String getGreeting(int timeOfDay) {
        String greeting;
        if (timeOfDay >= 5 && timeOfDay <= 12) {
            greeting = "Good morning!";
        } else if (timeOfDay >= 12 && timeOfDay <= 18) {
            greeting = "Good afternoon!";
        } else {
            greeting = "Good evening!";
        }
        return greeting;
    }
}