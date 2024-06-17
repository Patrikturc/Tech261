package com.sparta.pt;

public class Program {
    public static void main(String[] args) { //entry point
        //staticly typed language means that I can't assign different type to a certain type
        //refactoring is about improving code, without changing what the code does
        //for tomorrow, when should you and when shouldn't you refactor code
        int timeOfDay = 22; //Value that's held in memory, 3 properties: type, name, value
        getGreeting(timeOfDay);
    }

    private static void getGreeting(int timeOfDay) {
        if (timeOfDay >= 5 && timeOfDay <= 12) {
            System.out.println("Good morning!");
        } else if (timeOfDay >= 12 && timeOfDay <= 18) {
            System.out.println("Good afternoon!");
        } else {
            System.out.println("Good evening!");
        }
    }
}