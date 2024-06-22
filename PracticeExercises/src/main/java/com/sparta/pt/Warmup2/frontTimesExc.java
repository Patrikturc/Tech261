package com.sparta.pt.Warmup2;

public class frontTimesExc {

    public static void main(String[] args) {
        System.out.println(frontTimes("Chocolate", 2));// "ChoCho"
        System.out.println(frontTimes("Chocolate", 3));// "ChoChoCho"
        System.out.println(frontTimes("Abc", 3));// "AbcAbcAbc"
    }

    public static String frontTimes(String str, int n) {
        if (str.length() >= 3){
            str = str.substring(0,3);
        }

        StringBuilder strToReturn = new StringBuilder();
        strToReturn.append(str.repeat(n));
        return strToReturn.toString();
    }
}
