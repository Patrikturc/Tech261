package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsPalindromeTest {

    @Test
    void givenInputAbcdeReturnFalse() {
        String input = "abcde";
        boolean expected = false;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenInputIsRacecarReturnTrue() {
        String input = "Racecar";
        boolean expected = true;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenThatInputIsLessThanThreeLettersReturnFalse() {
        String input = "aa";
        boolean expected = false;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenStringIsEmptyReturnFalse() {
        String input = "";
        boolean expected = false;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenMessyStringGetCleanStringShouldReturnOnlyCharactersFromLatinAlphabet() {
        String input = "123Hi, this is a Test Method that should only return!!!words and whitespaces!";
        String expected = "Hi this is a Test Method that should only returnwords and whitespaces";

        String actual = StringCleaner.getCleanString(input);

        Assertions.assertEquals(expected, actual);
    }
}
