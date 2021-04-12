package com.serenitydojo.exceptions;

import org.junit.Test;
import org.w3c.dom.css.CSSUnknownRule;

import java.io.File;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenWorkingWithException {

    @Test
    public void shouldShowLengthOfString() {
        String input = "Some string";
        long lengthOfInput = input.length();
        String expectedOutput = input + " has a length of " + lengthOfInput;
        StringProcessor stringProcessor = new StringProcessor();

        assertThat(stringProcessor.showLengthOf(input)).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldShowLengthOfStringAsAnInt(){
        String input = "Some string";
        long lengthOfInput = input.length();

        StringProcessor stringProcessor = new StringProcessor();

        assertThat(stringProcessor.showLength(input)).isEqualTo(lengthOfInput);
    }

    @Test
    public void shouldShowLengthOfNullStringAsZero(){
        String input=null;

        StringProcessor stringProcessor = new StringProcessor();

        assertThat(stringProcessor.showLength(input)).isEqualTo(0);
    }

    @Test
    public void shouldGetLengthOfFile(){
        StringProcessor stringProcessor = new StringProcessor();
        File myFile = new File("C:\\Users\\Elnaz\\Documents\\Java\\testingEmptyFile.txt");

        assertThat(stringProcessor.getLengthOfFile(myFile)).isEqualTo(0);
    }

    @Test
    public void shouldGetLengthOfFileWithOneCharacter(){
        StringProcessor stringProcessor = new StringProcessor();
        File myFile = new File("C:\\Users\\Elnaz\\Documents\\Java\\testingFileWithOneCharacter.txt");

        assertThat(stringProcessor.getLengthOfFile(myFile)).isEqualTo(1);
    }

    @Test
    public void shouldGetLengthOfNotExistingFileAsZero(){
        StringProcessor stringProcessor = new StringProcessor();
        File myFile = new File("C:\\Users\\Elnaz\\Documents\\Java\\notExistingFile.txt");

        assertThat(stringProcessor.getLengthOfFile(myFile)).isEqualTo(0);
    }

    @Test
    public void shouldFindTheDefaultPort(){
        String myUrl = "https://www.google.com";
        StringProcessor stringProcessor = new StringProcessor();

        assertThat(stringProcessor.getDefaultPortOf(myUrl)).isEqualTo(443);
    }

    @Test(expected = UnknownURLFormatException.class)
    public void shouldThrowExceptionUnknownURLForGetPortOf(){
        String myUrl = "a:...";
        StringProcessor stringProcessor = new StringProcessor();

        assertThat(stringProcessor.getDefaultPortOf(myUrl)).isEqualTo(443);
    }
}
