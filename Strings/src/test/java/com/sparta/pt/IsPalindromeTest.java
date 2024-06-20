package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsPalindromeTest {

    @Test
    void GivenInputAbcdeReturnFalse() {
        String input = "abcde";
        boolean expected = false;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void GivenInputIsRacecarReturnTrue() {
        String input = "Racecar";
        boolean expected = true;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void GivenThatInputIsLessThanThreeLettersReturnFalse() {
        String input = "aa";
        boolean expected = false;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void GivenStringIsEmptyReturnFalse() {
        String input = "";
        boolean expected = false;

        boolean actual = IsPalindrome.checkIfWordIsPalindrome(input);

        Assertions.assertEquals(expected, actual);
    }

}
