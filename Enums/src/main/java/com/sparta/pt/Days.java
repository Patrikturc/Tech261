package com.sparta.pt;

import java.util.Arrays;

public enum Days {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday", 6),
    SUNDAY("Sunday", 7);

    private String name;
    private int noInWeek;

    Days(String name, int noInWeek) {
        this.name = name;
        this.noInWeek = noInWeek;
    }

    public static void main(String[] args) {
        Days daysOff = Days.FRIDAY;

        System.out.println(daysOff.compareTo(MONDAY));
        System.out.println(Arrays.toString(Days.values()));
        System.out.println((Days.valueOf("FRIDAY")));

    }
}
