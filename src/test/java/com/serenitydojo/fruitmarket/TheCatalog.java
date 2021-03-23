package com.serenitydojo.fruitmarket;

import org.junit.Test;

import java.util.Map;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {

    //Requirement 1: You can update the catalog with the current market price of a fruit
    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Apple).to(4.00);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }

    //Requirement 2:The Catalog should list the names of the currently available fruit in alphabetical order
    @Test
    public void shouldListTheNameOFTheCurrentlyAvailableFruitAlphabetically(){
        //Given
        Catalog catalog = new Catalog(Map.of(Apple, 2.50, Orange, 3.00, Pear, 2.00, Peach, 1.50));

        //When
        String availableFruitsString = catalog.showAvailableFruitListAlphabetically();

        //Then
        assertThat(availableFruitsString).isEqualTo("Apple, Orange, Peach, Pear");
    }


    //Requirement 3: The Catalog should report the price of a given type of fruit
    @Test
    public void shouldBeAbleToReportTheCurrentPriceOfAGivenFruit(){
        //Given
        Catalog catalog = new Catalog();

        //When
        catalog.setPriceOf(Orange).to(3.50);
        double orangePrice = catalog.getPriceOf(Orange);

        //Then
        assertThat(orangePrice).isEqualTo(3.50);
    }

    @Test (expected = FruitUnavailableException.class)
    public void shouldThrowUnavailableFruitExceptionIfFruitIsNotAvailable(){
        Catalog catalog = new Catalog(Map.of(Apple, 2.50, Orange, 3.00, Pear, 2.00, Peach, 1.50));
        catalog.getPriceOf(Mulberries);
    }
}
