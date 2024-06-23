package com.sparta.pt.Warmup2;

public class CountXx {
    public static void main(String[] args) {
        System.out.println(countXxs("abcxx")); // 1
        System.out.println(countXxs("xxx")); // 2
        System.out.println(countXxs("xxxx")); // 3
    }

    public static int countXxs(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        int counter = 0;
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i-1] == charArray[i] && charArray[i] == 'x'){
                counter++;
            }
        }
        return counter;

/*        Codingbat Solution
        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.substring(i, i+2).equals("xx")) count++;
        }
        return count;
        */
    }

}
