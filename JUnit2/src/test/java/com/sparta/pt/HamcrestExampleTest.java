package com.sparta.pt;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
//Right click Show context actions - staticly import the below
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExampleTest {
    private Spartan manish;

    @BeforeEach
    void setup() {
        manish = new Spartan(1, "Manish", "Java", LocalDate.of(2000,1,1));
    }

    @Nested
    @DisplayName("Hamcrest Spartan Tests")
    class hamcrestSpartanTests{
        @Test
        @DisplayName("Check that spartan is called Manish")
        void checkThatSpartanIsCalledManish() {
            assertThat(manish.getName(), equalTo("Manish"));
        }

        @Test
        @DisplayName("CheckThatSpartanHasAFieldName")
        void checkThatSpartanHasAFieldName() {
            //makes sure that certain property exists
            assertThat(manish, hasProperty("nam"));
        }
        @Test
        @DisplayName("Check that Spartan has a field called course set to Java")
        void checkThatSpartanHasAFieldCalledCourseSetToJava() {
            //makes sure that certain property exists
            assertThat(manish, hasProperty("course", equalTo("Java")));
        }
    }

    @Nested
    @DisplayName("Hamcrest String Methods")
    class HamcrestStringMethods{
        @Test
        @DisplayName("Check that name is not empty")
        void checkThatNameIsNotEmpty() {
            assertThat(manish.getName(), is(not(emptyOrNullString())));
        }

        @Test
        @DisplayName("check that name ends with ish")
        void checkThatNameEndsWithIsh() {
            assertThat(manish.getName(), endsWith("ish"));
        }
    }
}
