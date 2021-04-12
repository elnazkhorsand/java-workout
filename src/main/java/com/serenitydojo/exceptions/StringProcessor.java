package com.serenitydojo.exceptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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

    public int getDefaultPortOf(String stringURL){
        try {
            URL myUrl = new URL(stringURL);
            return myUrl.getDefaultPort();
        }
        catch (MalformedURLException malformedURLException){
            throw new UnknownURLFormatException("The format of the provided URL is unknown!", malformedURLException);
        }
    }
}
