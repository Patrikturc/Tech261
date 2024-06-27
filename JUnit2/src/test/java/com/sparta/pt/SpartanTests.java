package com.sparta.pt;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.LocalDate;
import java.util.stream.Stream;

public class SpartanTests {



    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME) //how many times do we want this test to repeat
    @DisplayName("Simple test")
    void simpleTest() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    @Disabled
    @DisplayName("Check Name of Spartan")
    void checkNameOfSpartan() {
        Assumptions.assumeTrue(false);
        Assertions.assertEquals(1, 1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    //Can also have CsvFileSource
    @MethodSource("getListOfNames")
    void checkLengthOfString(String name){
        Assertions.assertEquals(5, name.length());
    }

    public static Stream<Arguments> getListOfNames() {
        return Stream.of(
                Arguments.of("Manish"),
                Arguments.of("Alex")
        );
    }
    //Probably the most important thing in JUnit -  Hook?
    //Hooks -
    //BeforeAll, - Once before all tests -static
    //BeforeEach, - before each test
    //AfterAll, - once after all tests -static
    //AfterEach - once after each test

    private static Spartan manish;


    //Instantiation, They remove repetition
    //For example website
    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        manish = new Spartan(1, "Manish", "Java", LocalDate.now());
        System.out.println(testInfo.getDisplayName());
    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}
