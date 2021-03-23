package com.serenitydojo.fruitmarket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItem> items;
    private double runningTotal;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
        this.runningTotal = 0;
    }


    // You can add items to your shopping cart, which should keep a running total.
    public void addToShoppingCart(ShoppingCartItem item){
        items.add(item);
        runningTotal = runningTotal + catalog.getPriceOf(item.getFruit())*item.getQuantity();
    }

    public String returnCartItems(){
        String output = "";
        List<String> shoppingFruits = new ArrayList<>();
        for (ShoppingCartItem item: items){
            shoppingFruits.add(item.getFruit().toString());
        }
        return shoppingFruits.stream().collect(Collectors.joining(", "));
    }


    public double getRunningTotal() {

        for (ShoppingCartItem item:items ){
            if (item.getQuantity()>=5) return Math.round(((runningTotal-(runningTotal * 0.1))*100)/100);
        }
        return Math.round((runningTotal*100)/100);
    }
}
