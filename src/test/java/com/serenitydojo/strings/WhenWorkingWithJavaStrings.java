package com.serenitydojo.strings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    public void capitalizeOnlyTheFirstLetterOFEachWordAndReturnAStringWithSpace(){
        assertThat(MyUtility.capitalizeFirstLetter("bLUe", "GReen", "yeLLOW", "bLAck")).isEqualTo("Blue Green Yellow Black");
    }

    @Test
    public void checkingColorSwitch(){
        String[] expressions = {"Blue shirt","red Hose","Hat - blue","Blue blue - bLue_bLUE"};
        String[] expected = {"yellow shirt","red Hose","Hat - yellow","yellow yellow - yellow_yellow"};
        String switchThis = "blue";
        String switchWith = "yellow";
        assertThat(MyUtility.switchColor(expressions, switchThis,switchWith)).isEqualTo(expected);
    }

    @Test
    public void addingStringsTogether() {

        var colorA = "red";
        var colorB = "green";
        var colorC = "blue";
        var colorD = "yellow";
        var colorE = "gray";
        var colorF = "white";
        var colorG = "black";

        assertThat(MyUtility.addingStringsCommaSeparated(colorA,colorB,colorC)).isEqualTo("red,green,blue");
        assertThat(MyUtility.addingStringsCommaSeparated(colorA,colorB,colorC,colorD,colorE,colorF,colorG)).isEqualTo("red,green,blue,yellow,gray,white,black");

    }

}
