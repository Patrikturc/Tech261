package com.sparta.pt;

import java.util.ArrayList;

public class IsPalindrome {

    private static String[] checkIfWordIsPalindrome(String[] input) {
        ArrayList<String> palindromeList = new ArrayList<String>();
        for(String word : input){
            if (checkIfPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        return palindromeList.toArray(new String[0]);
    }

    private static boolean checkIfPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    public static String[] getLongestPalindromes(String sentence){
        sentence = StringCleaner.getCleanString(sentence);

        String[] cleanWordsArray = StringCleaner.splitStringToWords(sentence);

        cleanWordsArray = StringCleaner.removeShortWords(cleanWordsArray);

        String[] palindromesArray = checkIfWordIsPalindrome(cleanWordsArray);

        return palindromesArray;
    }

    // manual char manipulation
//    public static ArrayList<String> ExtractWordsFromString1(String input) {
//        if (input == null) return new ArrayList<String>();
//
//        ArrayList<String> finalStrings = new ArrayList<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] charArray = input.toLowerCase().toCharArray();
//
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] >= 'a' && charArray[i] <= 'z') {
//                stringBuilder.append(charArray[i]);
//            }
//            if (!stringBuilder.isEmpty() && (charArray[i] == ' ' || i == charArray.length - 1)) {
//                finalStrings.add(stringBuilder.toString());
//                stringBuilder.delete(0, stringBuilder.length());
//            }
//        }
//
//        return finalStrings;
//    }

    // regex
//    public static ArrayList<String> ExtractWordsFromString2(String input) {
//        if (input == null) return new ArrayList<String>();
//
//        ArrayList<String> finalStrings = new ArrayList<>();
//        input = input.replaceAll("[^a-zA-Z ]+", "");
//
//        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
//        Matcher matcher = pattern.matcher(input.toLowerCase());
//
//        while (matcher.find()) {
//            finalStrings.add(matcher.group());
//        }
//
//        return finalStrings;
//    }

}
