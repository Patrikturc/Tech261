package com.sparta.pt;

public enum VanillaWowRaces {
    HUMAN("Human", "Alliance"),
    DWARF("Dwarf", "Alliance"),
    NIGHT_ELF("Night Elf", "Alliance"),
    GNOME("Gnome", "Alliance"),
    ORC("Orc", "Horde"),
    UNDEAD("Undead", "Horde"),
    TAUREN("Tauren", "Horde"),
    TROLL("Troll", "Horde");

    private final String raceName;
    private final String faction;

    VanillaWowRaces(String raceName, String faction) {
        this.raceName = raceName;
        this.faction = faction;
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
        switch (this) {
            case HUMAN:
                System.out.println("Display Diplomacy racial ability.");
                break;
            case DWARF:
                System.out.println("Cast Stoneform racial ability.");
                break;
            case NIGHT_ELF:
                System.out.println("Cast Shadowmeld racial ability.");
                break;
            case GNOME:
                System.out.println("Cast Escape Artist racial ability.");
                break;
            case ORC:
                System.out.println("Cast Blood Fury racial ability.");
                break;
            case UNDEAD:
                System.out.println("Cast Will of the Forsaken racial ability.");
                break;
            case TAUREN:
                System.out.println("Cast War Stomp racial ability.");
                break;
            case TROLL:
                System.out.println("Cast Berserking racial ability.");
                break;
            default:
                System.out.println("Unknown racial ability.");
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}