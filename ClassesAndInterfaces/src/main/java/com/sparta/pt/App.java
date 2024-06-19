package com.sparta.pt;

public class App {
    public static void main(String[] args) {
        Dog max = new Dog("Max", "Terrier", 2);
        Cat maupak = new Cat("maupak", "Short-hair", 5);

        max.play();
        maupak.play();
    }
}
