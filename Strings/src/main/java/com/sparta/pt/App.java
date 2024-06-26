package com.sparta.pt;

public class App {
    public static void main(String[] args) {
        PalindromeFinder palindromeFinder = new PalindromeFinder(3);

        String[] longestPalindromes = palindromeFinder.getLongestPalindromes("Anna and Otto went to the civic center to see a Kayak display.");

        printPalindromes(longestPalindromes);
    }

    private static void printPalindromes(String[] palindromesArray){
        for (String palindromes : palindromesArray){
            System.out.println(palindromes);
        }
    }
}
