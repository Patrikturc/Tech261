package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class palindromeFinderTest {

    private final int minPalindromeLength = 3;
    private final palindromeFinder palindromeFinder = new palindromeFinder(minPalindromeLength);

    @Test
    void givenInputAbcdeReturnFalse() {
        String input = "abcde";
        boolean expected = false;

        boolean actual = palindromeFinder.isPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenInputIsPalindromeReturnTrue() {
        String input = "racecar";
        boolean expected = true;

        boolean actual = palindromeFinder.isPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenInputIsNotPalindromeReturnFalse() {
        String input = "knowledge";
        boolean expected = false;

        boolean actual = palindromeFinder.isPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenThatInputIsLessThanThreeLettersReturnFalse() {
        String[] input = {"hi", "aa", "palindrome", "racecar"};
        int minWordLength = 3;
        String[] expected = {"palindrome", "racecar"};

        String[] actual = StringProcessor.getStringAboveSetLength(input, minWordLength);

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void givenStringIsEmptyReturnFalse() {
        String input = "";
        boolean expected = false;

        boolean actual = palindromeFinder.isPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenMessyStringGetCleanStringShouldReturnOnlyCharactersFromLatinAlphabet() {
        String input = "123Hi, this is a Test Method that should only return!!!words and whitespaces!";
        String expected = "Hi this is a Test Method that should only returnwords and whitespaces";

        String actual = StringProcessor.getLatinAndSpaces(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenStringSentenceReturnArrayOfStringsWhereEachWordIsOneElement() {
//        long startTime1 = System.nanoTime();

        String input = "Hi this is a Test Method that should only returnwords and whitespaces";
        String[] expected = {"Hi", "this", "is", "a", "Test", "Method", "that", "should", "only", "returnwords", "and", "whitespaces"};

        String[] actual = StringProcessor.getStringToWordsArray(input);
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));

//        long endTime1 = System.nanoTime();
//        System.out.println("NoPalindromes execution time: " + (endTime1 - startTime1) + " ns");
    }

    @Test
    void givenStringIsShorterThanThreeLettersRemoveShortWordsWillReturnOnlyValidLengthWords() {
        String[] input = {"Hi", "this", "is", "a", "Test", "Method", "that", "should", "only", "returnwords", "and", "whitespaces"};
        String[] expected = {"this", "Test", "Method", "that", "should", "only", "returnwords", "and", "whitespaces"};

        String[] actual = StringProcessor.getStringAboveSetLength(input, 3);

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void givenSentenceGetLongestPalindromesShouldReturnLongestPalindromes() {
        String input = "123Hi, this is a Test Method that should only return!!!words and whitespaces! Racecar madam rotator Rotator";
        String[] expected = {"racecar", "rotator"};

        String[] actual = palindromeFinder.getLongestPalindromes(input);
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void givenEmptyStringGetLatinAndSpacesReturns() {
        String input = "";
        String expected = "";

        String actual = StringProcessor.getLatinAndSpaces(input);

        Assertions.assertEquals(expected, actual);
    }

}
