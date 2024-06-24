package com.sparta.pt.Warmup2;

public class DoubleX {

    public static void main(String[] args) {
        System.out.println(doubleX("axxbb")); //true
        System.out.println(doubleX("axaxax")); //false
        System.out.println(doubleX("xxxxx")); //true
        StringBuilder sb = new StringBuilder();


    }

    public static boolean doubleX(String str) {
        for (int i = 0; i < str.length()-1; i++){
            if(str.substring(i, i+1).equals("x")){
                if(str.substring(i, i+2).equals("xx")) return true;
                else return false;
            }
        }
        return false;
    }

}
