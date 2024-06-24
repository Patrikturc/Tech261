package examples;

import java.util.ArrayList;

public class BadPalindromeExample {

    public static void main(String[] args) {
        //Passing the sentence to solve
        String sentence = "Anna and Otto went to the civic center to see a Kayak display.";

        //Initialising all data
        int minPalindromeLength = 3;
        int longestPalindromeLength = 0;
        ArrayList<String> palindromeArrayList = new ArrayList<>();
        ArrayList<String> tempArrayList = new ArrayList<>();
        sentence = sentence.replaceAll("[^a-zA-Z ]+", "");
        String[] wordsArray = sentence.split(" ");

        //Remove short Strings and set them lower case and add words to the tempArrayList
        for (String word : wordsArray) {
            if(word.length() >= minPalindromeLength) {
                tempArrayList.add(word.toLowerCase());
            }
        }

        //Populating the ArrayList of Palindromes
        for(String word : tempArrayList) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                palindromeArrayList.add(word);
            }
        }

        //Finding the longest String/Palindrome from the palindrome list
        for (String palindrome : palindromeArrayList) {
            int length = palindrome.length();
            if (length > longestPalindromeLength) {
                longestPalindromeLength = length;
                tempArrayList.clear();
                tempArrayList.add(palindrome);
            } else if (length == longestPalindromeLength && !tempArrayList.contains(palindrome)) {
                tempArrayList.add(palindrome);
            }
        }

        for (String longestPalindrome : tempArrayList){
            System.out.println(longestPalindrome);
        }

        //Not reusable, not modular and hard to read
    }
}
