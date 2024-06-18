package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProgramTest {
//    @Test //@annotations carries metadata. Passes this to JVM(Java virtual machine)
//    @DisplayName("This is my first test")
//    public void basicTest(){
//        Assertions.assertTrue(5 == 5);
//    }

    @Test
    @DisplayName("Given a time of 21, then the greeting should be Good Evening")
    void checkThat21GivesGoodEvening(){
        int time = 21;
        String expectedGreeting = "Good evening!";
        String actualGreeting = Program.getGreeting(time);
        //Assertions.assertEquals(expectedGreeting, actualGreeting);
        Assertions.assertEquals("Good evening!", Program.getGreeting(21));
    }

    @Test
    @DisplayName("Given time is between 0 & 4, then the greeting should be You should sleep!!!")
    void checkThatGreetingReturnsYouShouldSleep(){
        for( int i = 0; i <= 4; i++) {
            Assertions.assertEquals("You should sleep!!!", Program.getGreeting(i));
        }
    }

    @Test
    @DisplayName("Given time is between 5 & 12, then the greeting should be Good morning!")
    void checkThatGreetingReturnsGoodMorning(){
        for( int i = 5; i <= 11; i++) {
            Assertions.assertEquals("Good morning!", Program.getGreeting(i));
        }
    }

    @Test
    @DisplayName("Given the time is between 12 and 18, then the greeting should be Good afternoon!")
    void checkThatGreetingReturnsAfternoon(){
        for (int i = 13; i <= 18; i++) {
            Assertions.assertEquals("Good afternoon!", Program.getGreeting(i));
        }
    }

    @Test
    @DisplayName("Given the time is between 19 and 23, then the greeting should be Good evening!")
    void checkThatGreetingReturnsEvening(){
        for (int i = 19; i <= 23; i++){
            Assertions.assertEquals("Good evening!", Program.getGreeting(i));
        }
    }

    @Test
    @DisplayName("Given the value is greater than 24, then Program should output an input error")
    void checkOverBoundaryInput(){
        Assertions.assertEquals("Incorrect hour, please insert a number between 0 and 23", Program.getGreeting(24));
    }

    @Test
    @DisplayName("Given the value is less than 0, then Program should output an input error")
    void checkUnderBoundaryInput(){
        Assertions.assertEquals("Incorrect hour, please insert a number between 0 and 23", Program.getGreeting(-1));
    }
}
