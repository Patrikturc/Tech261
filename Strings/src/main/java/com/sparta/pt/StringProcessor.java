package com.sparta.pt;

import java.util.ArrayList;

public class StringProcessor{

    public static String getLatinAndSpaces(String stringToClean) {
        if(stringToClean.isEmpty()) return "";
        return stringToClean.replaceAll("[^a-zA-Z ]+", "");
    }

    public static String[] splitStringToWords(String stringToSplit) {
        if(stringToSplit.isEmpty()) return new String[0];
        return stringToSplit.split(" ");
    }

    public static String[] removeShortWords(String[] wordsToValidate, int length) {
        if (wordsToValidate.length == 0) return new String[0];
        ArrayList<String> validLengthWords = new ArrayList<>();
        for (String word : wordsToValidate) {
            if(word.length() >= length) validLengthWords.add(word);
        }
        return validLengthWords.toArray(new String[0]);
    }

    public static String[] findLongestString(String[] words) {
        if (words.length == 0) return new String[0];
        ArrayList<String> longestStrings = new ArrayList<>();
        int maxLength = 0;

        for (String longestString : words) {
            int length = longestString.length();
            if (length > maxLength) {
                maxLength = length;
                longestStrings.clear();
                longestStrings.add(longestString);
            } else if (length == maxLength && !longestStrings.contains(longestString)) {
                longestStrings.add(longestString);
            }
        }
        return longestStrings.toArray(new String[0]);
    }

}
