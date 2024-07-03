package com.sparta.pt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    void CheckForException() {
        int[] numbers = {1, 2, 3, 4, 5};
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            int number = numbers[5];
        });
    }
}
