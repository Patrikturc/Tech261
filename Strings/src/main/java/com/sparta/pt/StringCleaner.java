package com.sparta.pt;

public class StringCleaner {


    public static String getCleanString(String stringToClean) {
        return stringToClean.replaceAll("[^a-zA-Z ]+", "");
    }

}
