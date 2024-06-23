package com.sparta.pt;

import java.util.ArrayList;

public class palindromeFinder {

    private int minLength;

    public palindromeFinder(int minPalindromeLength){
        minLength = minPalindromeLength;
    }

    public String[] getLongestPalindromes(String sentence){
        if(sentence.isEmpty()) return new String[0];
        sentence = StringProcessor.getLatinAndSpaces(sentence).toLowerCase();
        String[] cleanWordArray = StringProcessor.getStringToWordsArray(sentence);
        String[] palindromeArray = getPalindromes(cleanWordArray);
        return StringProcessor.getLongestString(palindromeArray);
    }

    public String[] getPalindromes(String[] input) {
        if(input.length == 0) return new String[0];
        ArrayList<String> palindromeList = new ArrayList<>();
        input = StringProcessor.getStringsOfSetLength(input, minLength);
        for(String word : input){

            if (isPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        return palindromeList.toArray(new String[0]);
    }

    public boolean isPalindrome(String word) {
        if (word.isEmpty()) return false;
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
