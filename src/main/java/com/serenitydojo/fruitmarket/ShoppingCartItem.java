package com.serenitydojo.fruitmarket;

public class ShoppingCartItem {
    private Fruit fruit;
    private Double quantity;

    public ShoppingCartItem(Fruit fruit, Double quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

}
