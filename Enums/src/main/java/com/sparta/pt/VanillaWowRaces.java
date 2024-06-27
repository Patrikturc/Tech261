package com.sparta.pt;

public enum VanillaWowRaces {
    HUMAN("Human", "Alliance", "Diplomacy"), //It could store what classes they can play
    DWARF("Dwarf", "Alliance", "Stoneform"),
    NIGHT_ELF("Night Elf", "Alliance", "Shadowmeld"),
    GNOME("Gnome", "Alliance", "Escape Artist"),
    ORC("Orc", "Horde", "Blood Fury"),
    UNDEAD("Undead", "Horde", "Will of the Forsaken"),
    TAUREN("Tauren", "Horde", "War Stomp"),
    TROLL("Troll", "Horde", "Berserking");

    private final String raceName;
    private final String faction;
    private final String racialAbility;

    VanillaWowRaces(String raceName, String faction, String racialAbility1) {
        this.raceName = raceName;
        this.faction = faction;
        this.racialAbility = racialAbility1;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getFaction() {
        return faction;
    }

    public void printRaceDetails() {
        System.out.println("Race: " + raceName + ", Faction: " + faction);
    }

    public void useRacialAbility() {
        System.out.println(raceName + " uses " + racialAbility + "!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}