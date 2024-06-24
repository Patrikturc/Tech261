package com.sparta.pt.static_example;

public class Spartan {
    private static String name;

    public void setName(String name) {
        Spartan.name = name;
    }

    public String getName() {
        return name;
    }

    public static void printSpartan(Spartan spartan) {
        System.out.println("Name: " + spartan.getName());
    }
}
