package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IdenticalNeighboursTest {

    @Test
    void givenThreeIdenticalNumbersReturnTrue() {

        int[] input = {1,1,1,2,2,2};
        boolean expected = true;

        boolean actual = IdenticalNeighbours.threeIdenticalNeighbours(input);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenArrayIsEmptyReturnFalse() {

        int[] input = {};
        boolean expected = false;

        boolean actual = IdenticalNeighbours.threeIdenticalNeighbours(input);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenThreeIdenticalIntsAreAtTheEndOfArrayReturnTrue() {

        int[] input = {1,2,3,4,5,6,7,8,8,8,9,9,9};
        boolean expected = true;

        boolean actual = IdenticalNeighbours.threeIdenticalNeighbours(input);

        Assertions.assertEquals(expected, actual);


    }

    @ParameterizedTest
    @MethodSource("findThreeIdenticalIntsTestData")
    void givenNegativesTreatThemAsNotPositive(int[] input, boolean expected){
        boolean actual = IdenticalNeighbours.threeIdenticalNeighbours(input);
        Assertions.assertEquals(expected,actual);
    }

    private static Stream<Arguments> findThreeIdenticalIntsTestData() {
        return Stream.of(
                Arguments.of(new int[]{0,1,2,3,-1,1,1,5}, false),
                Arguments.of(new int[]{0,0,-1,-1,-1}, true),
                Arguments.of(new int[]{0,1,0,-5,5,-5}, false),
                Arguments.of(new int[]{-5,1,1,-5,3,3,-5}, false),
                Arguments.of(new int[]{-5,11,11,11,-5}, true)
        );
    }
}
