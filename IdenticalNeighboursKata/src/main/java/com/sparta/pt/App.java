package com.sparta.pt;

public class App {
    public static void main(String[] args) {
        int[] arrOfNum = { 2, 3, 3, 3, 5, 7 };
        int[] arrOfNum1 = { 2, 3, 2, 3, 5, 7 };
        System.out.println(IdenticalNeighbours.ThreeIdenticalNeighbours(arrOfNum));
        System.out.println(IdenticalNeighbours.ThreeIdenticalNeighbours(arrOfNum1));
    }
}
