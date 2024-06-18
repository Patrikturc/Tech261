package com.sparta.pt;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) { //entry point
        //statically typed language means that I can't assign different type to a certain type
        //refactoring is about improving code, without changing what the code does
        //for tomorrow, when should you and when shouldn't you refactor code
        //Value that's held in memory, 3 properties: type, name, value

        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the time to phrase your greeting?");
            int timeOfDay = sc.nextInt();
            System.out.println(getGreeting(timeOfDay));
        } catch(Exception error) {
            System.out.println("Please enter a number between 0 and 23");
        }
    }

    public static String getGreeting(int timeOfDay) {

        String greeting;
        final int morning = 4;
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