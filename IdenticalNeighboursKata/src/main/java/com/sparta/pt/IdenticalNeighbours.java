package com.sparta.pt;

public class IdenticalNeighbours {

    public static boolean ThreeIdenticalNeighbours(int[] arrayOfInts){
        if (arrayOfInts.length == 0) return false;
        int counter = 0;
        for (int i = 1; i < arrayOfInts.length; i++){
            if (arrayOfInts[i] == arrayOfInts[i-1] && counter < 3){
                counter++;
                if (counter == 2) return true;
            } else counter = 1;
        }
        return false;
    }
}
