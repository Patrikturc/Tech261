package com.sparta.pt.animals;

public interface Drinkable extends Sleepable {

    int max = 10; //fields/vars inheritly public, static and final! in interfaces
    //while the program is running that variable cannot change

    void drink();

    default void print() {
        printFromInterface();
    }

    private static void printFromInterface() {
        System.out.println("I am printing from interface!");
    }

    public static void doSomething() {
        System.out.println("Static method");
    }

    //public, private, default, protected, ?sealed?
    //abstract, default, private, static - interface implementable methods

}
