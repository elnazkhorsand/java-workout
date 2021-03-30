package com.serenitydojo.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class MyUtility {
    public static String reverse(String firstString, String secondString) {
        return secondString+" "+firstString;
    }

    public static String reverse(String firstString, String secondString, String thirdString) {
        return thirdString + " " + secondString + " " + firstString;
    }

    public static String reverse(String... strings) {

        StringBuilder result = new StringBuilder();
        var size = strings.length - 1;

        for(int i=size; i>=0;i--){
            result.append(strings[i]).append(" ");
        }

        return result.toString().trim();
    }

    public static List<String> reverseList(List<String> originalList) {
        int lastIndexOfOriginalList = originalList.size()-1;
        List<String> reversedList = new ArrayList<>();

        for (int i = lastIndexOfOriginalList;i>=0;i--){
            reversedList.add(originalList.get(i));
        }

        return reversedList;
    }

    public static List<String> reverseList(String... strings) {
        List<String> reversedList = Arrays.asList(strings);

        Collections.reverse(reversedList);

         return reversedList;
    }

    public static String capitalizeWords(String... words) {
        StringBuilder outputObject = new StringBuilder();

        for (String word: words){
            outputObject.append(word.toUpperCase()).append(" ");
        }

        return outputObject.toString().trim();
    }
}
