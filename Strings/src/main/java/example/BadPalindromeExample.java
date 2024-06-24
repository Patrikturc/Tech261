package example;

import java.util.ArrayList;

public class BadPalindromeExample {

    public static void main(String[] args) {
        String sentence = "Anna and Otto went to the civic center to see a racecar display. Rotator";

        int minPalindromeLength = 3;
        int longestPalindromeLength = 0;
        
        ArrayList<String> palindromeArrayList = new ArrayList<>();
        ArrayList<String> tempArrayList = new ArrayList<>();
        
        sentence = sentence.replaceAll("[^a-zA-Z ]+", "");
        String[] wordsArray = sentence.split(" ");
        
        for (String word : wordsArray) {
            if(word.length() >= minPalindromeLength) {
                tempArrayList.add(word.toLowerCase());
            }
        }

        for(String word : tempArrayList) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                palindromeArrayList.add(word);
            }
        }

        for (String longestString : palindromeArrayList) {
            int length = longestString.length();
            if (length > longestPalindromeLength) {
                longestPalindromeLength = length;
                tempArrayList.clear();
                tempArrayList.add(longestString);
            } else if (length == longestPalindromeLength && !tempArrayList.contains(longestString)) {
                tempArrayList.add(longestString);
            }
        }
        wordsArray = tempArrayList.toArray(new String[0]);

        for (int i = 0; i < wordsArray.length; i++){
            System.out.println(wordsArray[i]);
        }
    }
}
