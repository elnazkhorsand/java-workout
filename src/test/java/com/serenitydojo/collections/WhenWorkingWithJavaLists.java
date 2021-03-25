package com.serenitydojo.collections;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void immutableLists(){
        //This type of initiation makes the List as immutable list which means, it wont be possible to change it later on.
        List<String> immutableList = Arrays.asList("Mina","Mohsen","Elimo");

        //When try to running the following commands you will receive: UnsupportedOperationException
        //immutableList.remove("Mina");
        //immutableList.add("NewName");
        assertThat(immutableList).contains("Mina","Mohsen","Elimo");
    }

    @Test
    public void removingItemsFromTheList(){
        List<String> names = new ArrayList<>();

        names.add("Mina");
        names.add("Elimo");
        names.add("Mohsen");

        assertThat(names).contains("Mina","Elimo","Mohsen");

        names.remove("Elimo");

        assertThat(names).contains("Mina", "Mohsen");

        names.clear();

        assertThat(names).isEmpty();
        assertThat(names.size()).isEqualTo(0);
    }

    @Test
    public void findingElementInList(){
        List<String> names = Arrays.asList("Z_0", "H_1", "M_2", "E_3", "N_4", "U_5", "P_6", "E_3", "E_3", "E_3");

        int indexOfE_3 = names.indexOf("E_3");
        int lastIndexOfE_3 = names.lastIndexOf("E_3");

        assertThat(indexOfE_3).isEqualTo(3);
        assertThat(lastIndexOfE_3).isEqualTo(9);
    }

    @Test
    public void findingASubList(){        // 0      1       2       3       4       5       6      7
        List<String> names = Arrays.asList("Tom", "Judi", "Sara", "Jack", "Joe", "Peter", "Loe", "Sam");

        List<String> subNames = names.subList(2, 6);
        assertThat(subNames).contains("Sara", "Jack", "Joe", "Peter");

        //Including the last element in the sub list:
        List<String> subNamesIncludingLastElement = names.subList(4, 8);
        assertThat(subNamesIncludingLastElement).contains("Joe", "Peter", "Loe", "Sam");
    }

    @Test
    public void findingTheSize(){
        List<String> names = new ArrayList<>();

        names.add("First");
        names.add("Two");
        names.add("Three");
        names.add("Four");

        assertThat(names.size()).isEqualTo(4);

        names.remove("Four");
        names.remove("Three");

        assertThat(names.size()).isEqualTo(2);
    }

    @Test
    public void convertingAListToASet(){       //0        1      2       3      4      5      6      7      8      9      10      11      12  -> Size: 13
        List<String> namesList = Arrays.asList("Zero", "Zero", "Zero", "One", "One", "Two", "Two", "Two", "Two", "Two", "Two", "Three", "Four");

        assertThat(namesList).contains("Zero", "Zero", "Zero", "One", "One", "Two", "Two", "Two", "Two", "Two", "Two", "Three", "Four");
        assertThat(namesList.size()).isEqualTo(13);

        //In Set, order wont exist, it is exactly like sets in math and there wont be any duplication.
        Set<String> namesSet = new HashSet<>(namesList);

        assertThat(namesSet).containsExactlyInAnyOrder("One", "Zero", "Three", "Four", "Two");
        assertThat(namesSet.size()).isEqualTo(5);
    }

    @Test
    public void sortingAList(){
        List<String> names = Arrays.asList("BBBB", "ZZZZ", "CCCC", "RRRR", "MMMM", "WWWW", "QQQQ", "AAAA");
        assertThat(names).contains("BBBB", "ZZZZ", "CCCC", "RRRR", "MMMM", "WWWW", "QQQQ", "AAAA");

        Collections.sort(names);
        assertThat(names).contains("AAAA","BBBB","CCCC","MMMM", "QQQQ", "RRRR", "WWWW", "ZZZZ");

        List<Integer> ages = Arrays.asList(2, 4, 6, 1, 5, 3, 7);
        assertThat(ages).contains(2, 4, 6, 1, 5, 3, 7);

        Collections.sort(ages);
        assertThat(ages).contains(1,2,3,4,5,6,7);
    }

    @Test
    public void findingMaxAndMinInAList(){
        List<Integer> ages = Arrays.asList(23, 40, 16, 15, 50, 30, 70);

        int min = Collections.min(ages);
        int max = Collections.max(ages);

        assertThat(min).isEqualTo(15);
        assertThat(max).isEqualTo(70);
    }

    @Test
    public void combiningLists(){
        List<String> names = Arrays.asList("One", "Two", "Three");
        List<String> moreNames = new ArrayList<>();

        moreNames.add("Four");
        moreNames.add("Five");

        assertThat(moreNames).contains("Four","Five");

        moreNames.addAll(names);

        assertThat(moreNames).contains("Four","Five", "One", "Two", "Three");

        List<String> copyNames = new ArrayList<>(names);

        assertThat(copyNames).contains("One", "Two", "Three");
    }
}
