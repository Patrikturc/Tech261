package com.sparta.pt;

@FunctionalInterface //Checks if the interface can be used as lambda expression
public interface SwitchOnable {
    //ONE and only one abstract method if we want to use lambda expressions
    void switchOn();
}
