package com.serenitydojo.fruitmarket;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TheShopping {

    Catalog myCatalog = new Catalog(Map.of(Fruit.Apple, 1.0, Fruit.Orange, 2.5,
            Fruit.Strawberries, 3.7, Fruit.Peach, 1.2 ));

    ShoppingCartItem appleItem = new ShoppingCartItem(Fruit.Apple, 1.0, 1.0);
    ShoppingCartItem orangeItem = new ShoppingCartItem(Fruit.Orange, 2.0, 1.0);
    ShoppingCartItem strawberriesItem = new ShoppingCartItem(Fruit.Strawberries, 1.5, 1.0);
    ShoppingCartItem peachItem = new ShoppingCartItem(Fruit.Peach, 1.2, 1.0);

    ShoppingCartItem FiveKiloAppleItem = new ShoppingCartItem(Fruit.Apple, 5.0, 1.0);

    @Test
    public void shouldBeAbleToAddItemToShoppingCart(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);
        myShoppingCart.addToShoppingCart(new ShoppingCartItem(Fruit.Apple, 1.0, 1.0));

        assertThat(myShoppingCart.returnCartItems()).isEqualTo("Apple");
    }

    @Test
    public void shouldBeAbleToReturnTheItemsInTheShoppingCart(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);
        myShoppingCart.addToShoppingCart(appleItem);
        myShoppingCart.addToShoppingCart(orangeItem);
        myShoppingCart.addToShoppingCart(strawberriesItem);
        myShoppingCart.addToShoppingCart(peachItem);

        assertThat(myShoppingCart.returnCartItems()).isEqualTo("Apple, Orange, Strawberries, Peach");
    }

    @Test
    public void shouldReturnTheRunningTotalCartPrice(){
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);
        myShoppingCart.addToShoppingCart(appleItem);
        myShoppingCart.addToShoppingCart(orangeItem);
        myShoppingCart.addToShoppingCart(strawberriesItem);
        myShoppingCart.addToShoppingCart(peachItem);

        assertThat(myShoppingCart.getRunningTotal()).isEqualTo(12.99);
    }

    @Test
    public void shouldGetTenPercentDiscountIfHaveAtLeastFiveKilosOfOneFruit(){
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);
        myShoppingCart.addToShoppingCart(FiveKiloAppleItem);
        myShoppingCart.addToShoppingCart(orangeItem);
        myShoppingCart.addToShoppingCart(strawberriesItem);
        myShoppingCart.addToShoppingCart(peachItem);

        assertThat(myShoppingCart.getRunningTotal()).isEqualTo(15.291);
    }
}
