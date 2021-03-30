package com.serenitydojo.strings;

public class MyUtility {
    public static String reverse(String firstString, String secondString) {
        return secondString+" "+firstString;
    }

    public static String reverse(String firstString, String secondString, String thirdString) {
        return thirdString + " " + secondString + " " + firstString;
    }

    public static String reverse(String... strings) {

        var result = "";
        var size = strings.length - 1;

        for(int i=size; i>=0;i--){
            result = result + strings[i] + " ";
        }

        return result.trim();
    }
}
