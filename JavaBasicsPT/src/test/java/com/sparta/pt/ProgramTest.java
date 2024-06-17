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
    @DisplayName("Given time is between 5 & 12, Then the greeting should be Good morning!")
    void checkThatGreetingReturnsGoodMorning(){
        for( int i = 5; i < 13; i++) {
            Assertions.assertEquals("Good morning!", Program.getGreeting(i));
        }
    }

    @Test
    @DisplayName("Given the time is between 12 and 18, the greeting should be Good afternoon!")
    void checkThatGreetingReturnsAfternoon(){
        for (int i = 12; i < 19; i++) {
            Assertions.assertEquals("Good afternoon!", Program.getGreeting(i));
        }
    }

    @Test
    @DisplayName("Given the time is between 19 and 24, the greeting should be Good evening!")
    void checkThatGreetingReturnsEvening(){
        for (int i = 0; i < 25; i++){
            if(i < 5 || i > 18){
                Assertions.assertEquals("Good evening!", Program.getGreeting(i));
            }
        }
    }

    @Test
    @DisplayName("Given the value is greater than 24, Program should output error")
    void checkThatGreetingReturnsError(){
        Assertions.assertEquals("Error!", Program.getGreeting(25));
        Assertions.assertEquals("Error!", Program.getGreeting(-1));
    }
}
