package com.serenitydojo.strings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WhenWorkingWithJavaStrings {

    //Writing a method getting two Strings and returns a String containing the reverse Strings with a space between them
    @Test
    public void reverseTwoStrings(){
        assertThat(MyUtility.reverse("Duck", "Orange")).isEqualTo("Orange Duck");
                //.isEqual("Orange Duck");
    }

    @Test
    public void reverseThreeStrings(){
        assertThat(MyUtility.reverse("Duck","Orange","An")).isEqualTo("An Orange Duck");
    }

    @Test
    public void reverseArrayOfStrings(){
        assertThat(MyUtility.reverse("One", "Two", "Three", "Four", "Five", "Six")).isEqualTo("Six Five Four Three Two One");
    }

    @Test
    public void reverseAListAndReturnIt(){
        List<String> originalList = Arrays.asList("One", "Two", "Three", "Four");
        List<String> expectedReversed = Arrays.asList("Four", "Three", "Two", "One");

        assertThat(MyUtility.reverseList(originalList)).isEqualTo(expectedReversed);
    }

    @Test
    public void reverseAnArrayAndReturnAList(){
        List<String> originalList = Arrays.asList("One", "Two", "Three", "Four");
        List<String> expectedReversed = Arrays.asList("Six", "Five", "Four", "Three", "Two", "One");

        assertThat(MyUtility.reverseList("One", "Two", "Three", "Four", "Five", "Six")).isEqualTo(expectedReversed);
    }

    @Test
    public void capitalizeArrayOfWordsAndReturnsAString() {
        assertThat(MyUtility.capitalizeWords("one", "two", "three", "four")).isEqualTo("ONE TWO THREE FOUR");
    }
}
