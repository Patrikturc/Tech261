package com.sparta.pt;

public class Cat extends Animal {

    @Override
    public void play() {
        System.out.println(super.getName() + " Does not want to play");
    }

    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }
}
