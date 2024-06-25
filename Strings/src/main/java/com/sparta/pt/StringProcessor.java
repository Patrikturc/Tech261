package com.sparta.pt;

import java.util.ArrayList;

public class StringProcessor{

    public static String getLatinAndSpaces(String stringToClean) {
        if (stringToClean == null || stringToClean.isEmpty()) return "";
        return stringToClean.replaceAll("[^a-zA-Z ]+", "");
    }

    public static String[] getArrayFromString(String stringToSplit) {
        if (stringToSplit == null || stringToSplit.isEmpty()) return new String[0];
        return stringToSplit.split(" ");
    }

    public static String[] getStringsAboveSetLength(String[] wordArray, int minLength) {
        if (wordArray == null || wordArray.length == 0) return new String[0];
        ArrayList<String> validLengthWords = new ArrayList<>();
        for (String currentWord : wordArray) {
            if (currentWord.length() >= minLength) validLengthWords.add(currentWord);
        }
        return validLengthWords.toArray(new String[0]);
    }

    public static String[] getLongestStrings(String[] wordArray) {
        if (wordArray == null || wordArray.length == 0) return new String[0];
        ArrayList<String> longestStrings = new ArrayList<>();
        int longest = 0;
        for (String currentWord : wordArray) {
            int length = currentWord.length();
            if (length > longest) {
                longest = length;
                longestStrings.clear();
                longestStrings.add(currentWord);
            } else if (length == longest && !longestStrings.contains(currentWord)) {
                longestStrings.add(currentWord);
            }
        }
        return longestStrings.toArray(new String[0]);
    }
}
