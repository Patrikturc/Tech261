package com.sparta.pt;

public class IdenticalNeighbours {

    private static int counter = 0;

    public static boolean threeIdenticalNeighbours(int[] arrayOfInts){
        if (arrayOfInts.length == 0) return false;
        for (int i = 1; i < arrayOfInts.length; i++){
            if (arrayOfInts[i] == arrayOfInts[i-1] && counter < 2){
                counter++;
                if (counter == 2) return true;
            } else counter = 0;
        }
        return false;
    }
}
