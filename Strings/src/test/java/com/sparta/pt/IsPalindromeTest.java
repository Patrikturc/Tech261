package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IsPalindromeTest {

//    @Test
//    void givenInputAbcdeReturnFalse() {
//        String input = "abcde";
//        boolean expected = false;
//
//        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);
//
//        Assertions.assertEquals(expected, actual);
//    }

//    @Test
//    void givenInputIsRacecarReturnTrue() {
//        String input = "Racecar";
//        boolean expected = true;
//
//        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);
//
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void givenThatInputIsLessThanThreeLettersReturnFalse() {
//        String input = "aa";
//        boolean expected = false;
//
//        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);
//
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void givenStringIsEmptyReturnFalse() {
//        String input = "";
//        boolean expected = false;
//
//        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);
//
//        Assertions.assertEquals(expected, actual);
//    }

    @Test
    void givenMessyStringGetCleanStringShouldReturnOnlyCharactersFromLatinAlphabet() {
        String input = "123Hi, this is a Test Method that should only return!!!words and whitespaces!";
        String expected = "hi this is a test method that should only returnwords and whitespaces";

        String actual = StringCleaner.getCleanString(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenStringSentenceReturnArrayOfStringsWhereEachWordIsOneElement() {
        String input = "Hi this is a Test Method that should only returnwords and whitespaces";
        String[] expected = {"Hi", "this", "is", "a", "Test", "Method", "that", "should", "only", "returnwords", "and", "whitespaces"};

        String[] actual = StringCleaner.splitStringToWords(input);
        //Will probably need Method Source, or try to figure out how to run it with array
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void givenStringIsShorterThanThreeLettersRemoveShortWordsWillReturnOnlyValidLengthWords() {
        String[] input = {"Hi", "this", "is", "a", "Test", "Method", "that", "should", "only", "returnwords", "and", "whitespaces"};
        String[] expected = {"this", "Test", "Method", "that", "should", "only", "returnwords", "and", "whitespaces"};

        String[] actual = StringCleaner.removeShortWords(input);

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    void givenSentenceGetLongestPalindromesShouldReturnLongestPalindromes() {
        String input = "123Hi, this is a Test Method that should only return!!!words and whitespaces! Racecar madam rotator";
        String[] expected = {"racecar", "rotator"};

        String[] actual = IsPalindrome.getLongestPalindromes(input);
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}
