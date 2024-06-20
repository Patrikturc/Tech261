package com.sparta.pt;

public class IsPalindrome {

    public static boolean checkIfWordIsPalindrome(String input) {
        if (input.length() < 3) return false;
        String inputToLowerCase = input.toLowerCase();

        String reversed = new StringBuilder(inputToLowerCase).reverse().toString();

        return inputToLowerCase.equals(reversed);
    }

}
