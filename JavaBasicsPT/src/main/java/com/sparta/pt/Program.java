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

        String greeting;

//        if(timeOfDay < 0 || timeOfDay > 23){
//            greeting = "Incorrect hour, please insert a number between 0 and 23";
//        } else if (timeOfDay <= 4) {
//            greeting = "You should sleep!!!";
//        } else if (timeOfDay <= 11) {
//            greeting = "Good morning!";
//        } else if (timeOfDay <= 18) {
//            greeting = "Good afternoon!";
//        } else greeting = "Good evening!";


        greeting = (timeOfDay < 0 || timeOfDay > 23) ? "Incorrect hour, please insert a number between 0 and 23" :
            (timeOfDay <= 4) ? "You should sleep!!!" :
            (timeOfDay <= 11) ? "Good morning!" :
            (timeOfDay <= 18) ? "Good afternoon!" :
            "Good evening!";

        return greeting;
    }
}