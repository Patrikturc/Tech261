package com.sparta.pt;

import java.util.ArrayList;

public class StringCleaner {


    public static String getCleanString(String stringToClean) {
        stringToClean = stringToClean.toLowerCase();
        return stringToClean.replaceAll("[^a-zA-Z ]+", "");
    }

    public static String[] splitStringToWords(String stringToSplit) {
        return stringToSplit.split(" ");
    }

    public static String[] removeShortWords(String[] wordsToValidate) {
        ArrayList<String> validLengthWords = new ArrayList<>();
        for (String word : wordsToValidate) {
            if(checkStringLength(word)) validLengthWords.add(word);
        }
        return validLengthWords.toArray(new String[0]);
    }

    private static boolean checkStringLength(String wordToCheck) {
        return wordToCheck.length() >= 3;
    }

}
