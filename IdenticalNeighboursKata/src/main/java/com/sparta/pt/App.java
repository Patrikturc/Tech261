package com.sparta.pt;

public class App {
    public static void main(String[] args) {
        int[] arrOfNum = { 2, 3, 2, 3,-1,-1,-1, 5, 7 };
        int[] arrOfNum1 = { 2, };
        System.out.println(IdenticalNeighbours.threeIdenticalNeighbours(arrOfNum));
        System.out.println(IdenticalNeighbours.threeIdenticalNeighbours(arrOfNum1));
        System.out.println(1 == -1);
    }
}
