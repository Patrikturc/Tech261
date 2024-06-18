package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Annotation;

public class FizzBuzzTests {
    // Print numbers in order
    // If number is divisible by 3 print "Fizz"
    // If number is divisible by 5 print "Buzz"
    // if number is divisible by 3 and 5 print "FizzBuzz"
    @Test
    @DisplayName("Print a number")
    void givenAnInputOfOneFizzBuzzReturnsOne(){
        // Arrange
        int input = 1;
        String expected = "1";

        // Act
        String actual = FizzBuzz.getFizzBuzzFrom(input);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"2, 2",
            "4, 4",
            "7,7"})
    void givenInputNotDivisibleByThreeOrFiveGetFizzBuzzReturnsThatNumber(int input, String expected){
        String actual = FizzBuzz.getFizzBuzzFrom(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void givenAnInputOfThreeFizzBuzzReturnsFizz(int input){
        String expected = "Fizz";

        String actual = FizzBuzz.getFizzBuzzFrom(input);

        Assertions.assertEquals(expected, actual);
    }
}
