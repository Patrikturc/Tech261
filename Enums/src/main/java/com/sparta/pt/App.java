package com.sparta.pt;

public class App {
    public static void main(String[] args) {
        VanillaWowRaces human = VanillaWowRaces.HUMAN;
        human.printRaceDetails();
        human.useRacialAbility();

        VanillaWowRaces undead = VanillaWowRaces.UNDEAD;
        undead.useRacialAbility();
        System.out.println(undead.getFaction());
    }
}
