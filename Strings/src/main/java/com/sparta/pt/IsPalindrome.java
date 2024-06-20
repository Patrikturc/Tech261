package com.sparta.pt;

public class IsPalindrome {

    public static boolean checkIfWordIsPalindrome(String input) {
        if (input.length() < 3) return false;
        String inputToLowerCase = input.toLowerCase();

        String reversed = new StringBuffer(inputToLowerCase).reverse().toString();

        return inputToLowerCase.equals(reversed);
    }

    // manual char manipulation
//    public static ArrayList<String> ExtractWordsFromString1(String input) {
//        if (input == null) return new ArrayList<String>();
//
//        ArrayList<String> finalStrings = new ArrayList<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] charArray = input.toLowerCase().toCharArray();
//
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] >= 'a' && charArray[i] <= 'z') {
//                stringBuilder.append(charArray[i]);
//            }
//            if (!stringBuilder.isEmpty() && (charArray[i] == ' ' || i == charArray.length - 1)) {
//                finalStrings.add(stringBuilder.toString());
//                stringBuilder.delete(0, stringBuilder.length());
//            }
//        }
//
//        return finalStrings;
//    }

    // regex
//    public static ArrayList<String> ExtractWordsFromString2(String input) {
//        if (input == null) return new ArrayList<String>();
//
//        ArrayList<String> finalStrings = new ArrayList<>();
//        input = input.replaceAll("[^a-zA-Z ]+", "");
//
//        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
//        Matcher matcher = pattern.matcher(input.toLowerCase());
//
//        while (matcher.find()) {
//            finalStrings.add(matcher.group());
//        }
//
//        return finalStrings;
//    }

}
