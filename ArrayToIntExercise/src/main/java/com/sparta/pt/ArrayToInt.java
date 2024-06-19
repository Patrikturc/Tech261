package com.sparta.pt;

import java.util.Arrays;

public class ArrayToInt {

    public static int arrayToIntConverter(int[] intArrToConvert){
        if(intArrToConvert.length == 0) return 0;

        StringBuilder arrayToString = new StringBuilder();

        for (int number : intArrToConvert) {
            arrayToString.append(getPositiveNumber(number));
        }
        return Integer.parseInt(String.valueOf(arrayToString));
    }

    private static int getPositiveNumber(int numToCheck){
        return Math.abs(numToCheck);
    }

}
