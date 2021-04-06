package com.serenitydojo.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.Test;

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
}
