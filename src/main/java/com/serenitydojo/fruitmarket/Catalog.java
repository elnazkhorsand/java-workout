package com.serenitydojo.fruitmarket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: 18/03/2021 The Catalog should throw a FruitUnavailableException if the fruit is not currently available  

public class Catalog {

    private Map<Fruit, Double> pricePerKilo = new HashMap<>();

    public Catalog(){}

    public Catalog(Map<Fruit, Double> pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    public PriceSetter setPriceOf(Fruit fruit) {
        return new PriceSetter(this, fruit);
    }

    //The Catalog should report the price of a given type of fruit
    public Double getPriceOf(Fruit fruit) {
        if (pricePerKilo.get(fruit)!= null){
            return pricePerKilo.get(fruit);
        }
        else throw new FruitUnavailableException(fruit + " is currently unavailable!");
    }


    //The Catalog should list the names of the currently available fruit in alphabetical order
    public String showAvailableFruitListAlphabetically() {

        List<String> availableFruitList = new ArrayList<>();

        for(Fruit fruit: pricePerKilo.keySet()){
            availableFruitList.add(fruit.toString());
        }

        Stream<String> sortedAvailableFruitList = availableFruitList.stream().sorted();

        return sortedAvailableFruitList.collect(Collectors.joining(", "));

    }



    // TODO: 18/03/2021 When you buy 5 kilos or more of any fruit, you get a 10% discount.

    public static class PriceSetter {
        private final Catalog catalog;
        private final Fruit fruit;

        public PriceSetter(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;
        }

        //You can update the catalog with the current market price of a fruit
        public Catalog to(Double price) {
            catalog.pricePerKilo.put(fruit, price);
            return catalog;
        }

    }

}
