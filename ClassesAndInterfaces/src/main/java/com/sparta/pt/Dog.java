package com.sparta.pt;

public class Dog extends Animal {

    public Dog(String name, String breed, int age){
        super(name, breed, age);
    }

    //name has to be the same
    //1. Overload based on Return type
    //2. Type of parameters
    //3. Order of parameters


    public void play(String name){
        System.out.println(name + " wants to play with" + super.getName());
    }
}
