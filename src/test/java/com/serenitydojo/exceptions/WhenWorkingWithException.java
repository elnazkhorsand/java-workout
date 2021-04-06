package com.serenitydojo.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;

public class WhenWorkingWithException {

    @Test
    public void shouldShowLengthOfString() {
        String input = "Some string";
        long lengthOfInput = input.length();
        String expectedOutput = input + " has a length of " + lengthOfInput;
        StringProcessor stringProcessor = new StringProcessor();

        Assertions.assertThat(stringProcessor.showLengthOf(input)).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldShowLengthOfStringAsAnInt(){
        String input = "Some string";
        long lengthOfInput = input.length();

        StringProcessor stringProcessor = new StringProcessor();

        Assertions.assertThat(stringProcessor.showLength(input)).isEqualTo(lengthOfInput);
    }

    @Test
    public void shouldShowLengthOfNullStringAsZero(){
        String input=null;

        StringProcessor stringProcessor = new StringProcessor();

        Assertions.assertThat(stringProcessor.showLength(input)).isEqualTo(0);
    }

    @Test
    public void shouldGetLengthOfFile(){
        StringProcessor stringProcessor = new StringProcessor();
        File myFile = new File("C:\\Users\\Elnaz\\Documents\\Java\\testingEmptyFile.txt");

        Assertions.assertThat(stringProcessor.getLengthOfFile(myFile)).isEqualTo(0);
    }

    @Test
    public void shouldGetLengthOfFileWithOneCharacter(){
        StringProcessor stringProcessor = new StringProcessor();
        File myFile = new File("C:\\Users\\Elnaz\\Documents\\Java\\testingFileWithOneCharacter.txt");

        Assertions.assertThat(stringProcessor.getLengthOfFile(myFile)).isEqualTo(1);
    }

    @Test
    public void shouldGetLengthOfNotExistingFileAsZero(){
        StringProcessor stringProcessor = new StringProcessor();
        File myFile = new File("C:\\Users\\Elnaz\\Documents\\Java\\notExistingFile.txt");

        Assertions.assertThat(stringProcessor.getLengthOfFile(myFile)).isEqualTo(0);
    }
}
