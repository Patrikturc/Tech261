package com.sparta.pt;

import java.util.ArrayList;

public class IsPalindrome {

    private int minLength;

    public IsPalindrome(int minPalindromeLength){
        minLength = minPalindromeLength;
    }

    public String[] getLongestPalindromes(String sentence){
        if(sentence.isEmpty()) return new String[0];
        sentence = StringProcessor.getLatinAndSpaces(sentence).toLowerCase();
        String[] cleanWordArray = StringProcessor.splitStringToWords(sentence);
        String[] palindromeArray = getPalindromes(cleanWordArray);
        return StringProcessor.findLongestString(palindromeArray);
    }

    private String[] getPalindromes(String[] input) {
        if(input.length == 0) return new String[0];
        ArrayList<String> palindromeList = new ArrayList<>();
        input = StringProcessor.removeShortWords(input, minLength);
        for(String word : input){

            if (checkIfPalindrome(word)) {
                palindromeList.add(word);
            }
        }
        return palindromeList.toArray(new String[0]);
    }

    public boolean checkIfPalindrome(String word) {
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
