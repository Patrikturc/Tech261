package com.sparta.pt;

import java.util.ArrayList;

public class PalindromeFinder {

    private int minLength;

    public PalindromeFinder(int minPalindromeLength) {
        minLength = minPalindromeLength;
    }

    public String[] getLongestPalindromes(String sentence) {
        if (sentence == null || sentence.isEmpty()) return new String[0];
        sentence = StringProcessor.getLatinAndSpaces(sentence).toLowerCase();
        String[] palindromeArray = getPalindromes(StringProcessor.getArrayFromString(sentence));
        return StringProcessor.getLongestStrings(palindromeArray);
    }

    public String[] getPalindromes(String[] wordArray) {
        if (wordArray == null || wordArray.length == 0) return new String[0];
        ArrayList<String> palindromeList = new ArrayList<>();
        for (String word : wordArray) {
            if (isPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        return palindromeList.toArray(new String[0]);
    }

    public boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) return false;
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    public int minLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
