package com.sparta.pt;

public class StringExample {

    public static void main(String[] args) {
        String string1 = "Hello";
        string1.toUpperCase(); //Strings are immutable so must create a new object of String
        string1 = string1.toUpperCase(); //immutable
        String upperString1 = string1.toUpperCase();
        System.out.println(string1);

        System.out.println(string1.toCharArray());

        String string = String.valueOf(100);

        String name = "Manish";
        System.out.println("Hello " + name);

        //new StringBuilder().reverse();
    }

}
