package com.serenitydojo.collections;

import org.graalvm.compiler.debug.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WhenWorkingWithJavaLists {

    //List: An ordered collection in Java which duplicate values are possible as well.

    @Test
    public void creatingSimpleLists(){
        List simpleList = new ArrayList();

        simpleList.add("a simple list");
        simpleList.add(123);
        simpleList.add(true);

        assertThat(simpleList).contains("a simple list", 123, true);
    }

    @Test
    public void createATypedList(){
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();

        names.add("Sara");
        names.add("James");
        names.add("Kim");

        ages.add(20);
        ages.add(32);
        ages.add(17);

        assertThat(names).contains("Sara","James","Kim");
        assertThat(ages).contains(20, 32, 17);
    }
}
