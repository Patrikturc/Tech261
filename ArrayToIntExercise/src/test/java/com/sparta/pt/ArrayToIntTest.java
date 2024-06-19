package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayToIntTest {

    @Test
    @DisplayName("Given input of 4 numbers, the Method should " +
            "return an int value that's made up of all the digits")
    void givenAnInputOfArrayOfIntsReturnSingleInteger(){
        int[] input = {1,2,3,4};
        int expected = 1234;

        int actual = ArrayToInt.arrayToIntConverter(input);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Given input of negative number, the Method should " +
            "return an int value that's made up of all the digits")
    void givenAnInputOfNegativeNumberOutputIgnoreItAndOutputTheRest(){
        int[] input = {-1,2,3,4};
        int expected = 1234;

        int actual = ArrayToInt.arrayToIntConverter(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getIntToIntArrayTestData")
    @DisplayName("Given the array starts with zero, method should " +
            "ignore zeros before the first appropriate number")
    void givenArrayIsStartingWithZeroReturnJustNumberAfterIt(int[] input, int expected){
        int actual = ArrayToInt.arrayToIntConverter(input);
        Assertions.assertEquals(expected,actual);
    }

    private static Stream<Arguments> getIntToIntArrayTestData() {
        return Stream.of(
                Arguments.of(new int[]{0,1,2,3}, 123),
                Arguments.of(new int[]{0,0,0,3}, 3),
                Arguments.of(new int[]{0,1,0,3}, 103),
                Arguments.of(new int[]{0,1,0,3,0}, 1030),
                Arguments.of(new int[]{0,11,44}, 1144)
        );
    }

    @Test
    void givenArrayIsEmptyReturnZero(){
        int[] input = {};
        int expected = 0;

        int actual = ArrayToInt.arrayToIntConverter(input);

        Assertions.assertEquals(expected, actual);
    }


}


