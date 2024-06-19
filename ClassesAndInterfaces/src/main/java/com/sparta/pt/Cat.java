package com.sparta.pt;

public class Cat extends Animal {

    @Override
    public void play() {
        System.out.println(super.getName() + " Does not want to play");
    }

    @Override
    public void eat() {
        System.out.println("Cat must eat");
    }

    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }

    public void climb(){
        System.out.println("Cat can climb");
    }

    @Override
    public void drink() {
        Drinkable.doSomething();
    }

    @Override
    public String goToSleep() {
        return "";
    }
}
