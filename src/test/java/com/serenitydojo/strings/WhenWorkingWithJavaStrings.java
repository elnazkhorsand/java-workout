package com.serenitydojo.strings;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class WhenWorkingWithJavaStrings {

    //Writing a method getting two Strings and returns a String containing the reverse Strings with a space between them
    @Test
    public void reverseTwoStrings(){
        assertThat(MyUtility.reverse("Duck", "Orange")).isEqualTo("Orange Duck");
                //.isEqual("Orange Duck");
    }

}
