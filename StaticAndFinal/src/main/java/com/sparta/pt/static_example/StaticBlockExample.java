package com.sparta.pt.static_example;

import java.util.ArrayList;

public class StaticBlockExample {

    private static ArrayList<String> names = new ArrayList<>();

    static { //Everything here will get run once when the class is loaded
        names.add("Manish");
        names.add("Alex");
    }

    public static void main(String[] args) {

    }

}
