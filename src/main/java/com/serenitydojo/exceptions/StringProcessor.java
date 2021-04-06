package com.serenitydojo.exceptions;

import java.io.File;

public class StringProcessor {
    public String showLengthOf(String input) {
        return input + " has a length of " + input.length();
    }

    public long showLength(String input) {
        return (input==null)?0:input.length();
    }

    public long getLengthOfFile(File myFile) {
        return myFile.length();
    }
}
