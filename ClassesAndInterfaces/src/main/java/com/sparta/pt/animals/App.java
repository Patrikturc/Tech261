package com.sparta.pt.animals;

public class App {
    public static void main(String[] args) {
        Dog max = new Dog("Max", "Terrier", 2);
        Animal maupak = new Cat("Maupak", "Short-hair", 5);

        max.play();
        maupak.play();

        //
        ((Cat) maupak).climb();
    }
}
