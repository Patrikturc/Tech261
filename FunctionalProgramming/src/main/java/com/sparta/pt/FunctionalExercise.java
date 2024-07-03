package com.sparta.pt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FunctionalExercise {
    public static void main(String[] args) {
        ArrayList<String> names1 = new ArrayList<>(Arrays.asList("Alice", "Bob", "EvE", "Carol", "David", "Oscar", "Ursula", "Sophie"));
        ArrayList<String> names2 = new ArrayList<>(Arrays.asList("Anna", "Ella", "Oliver", "Ivy", "Umberto", "Grace", "Irene"));
        ArrayList<String> names3 = new ArrayList<>(Arrays.asList("Emmett", "Owen", "Isaac", "Uriel", "Alexandra", "Evangeline"));

        System.out.println("Names with exactly 2 vowels (Sample 1): " + filterNamesWithTwoVowels(names1));
        System.out.println("Names with exactly 2 vowels (Sample 2): " + filterNamesWithTwoVowels(names2));
        System.out.println("Names with exactly 2 vowels (Sample 3): " + filterNamesWithTwoVowels(names3));
    }

    public static ArrayList<String> filterNamesWithTwoVowels(List<String> names) {
        return names.stream()
                .map(String::toLowerCase)
                .filter(name -> countVowels(name) == 2)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static int countVowels(String name) {
        Pattern pattern = Pattern.compile("[aeiou]");
        Matcher matcher = pattern.matcher(name);
        return (int) matcher.results().count();
    }
}
