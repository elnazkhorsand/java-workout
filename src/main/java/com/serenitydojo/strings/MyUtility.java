package com.serenitydojo.strings;

import java.util.ArrayList;
import java.util.List;

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
}
