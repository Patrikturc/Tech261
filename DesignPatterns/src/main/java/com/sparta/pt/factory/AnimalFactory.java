package com.sparta.pt.factory;

public class AnimalFactory {

    //Gives access to objects but hides how they are created Speakable could be an abstract class
    public static Speakable getAnimal(String animal) {
        return switch (animal) {
            case "Dog" -> new Dog();
            case "Hound Dog" -> New Dog();
            case "Cat" -> new Cat();
            case "Goldfish" -> new Goldfish();
            default -> null;
        };
    }

}
