package com.serenitydojo.fruitmarket;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TheShopping {

    Catalog myCatalog = new Catalog(Map.of(Fruit.Apple, 1.0, Fruit.Orange, 2.5,
            Fruit.Strawberries, 3.7, Fruit.Peach, 1.2 ));

    ShoppingCartItem appleOneKiloOneDollarItem = new ShoppingCartItem(Fruit.Apple, 1.0);
    ShoppingCartItem orangeTwoKiloTwoPointFiveDollarItem = new ShoppingCartItem(Fruit.Orange, 2.0);
    ShoppingCartItem strawberriesOnePointFiveKiloThreePointSevenDollarItem = new ShoppingCartItem(Fruit.Strawberries, 1.5);
    ShoppingCartItem peachOnePointTwoKiloOnePointTwoDollarItem = new ShoppingCartItem(Fruit.Peach, 1.2);

    ShoppingCartItem appleFiveKiloOneDollarItem = new ShoppingCartItem(Fruit.Apple, 5.0);
    ShoppingCartItem orangeFiveKiloTwoPointFiveDollarItem = new ShoppingCartItem(Fruit.Orange, 8.0);
    ShoppingCartItem strawberriesFiveKiloThreePointSevenDollarItem = new ShoppingCartItem(Fruit.Strawberries, 7.0);

    @Test
    public void shouldBeAbleToAddItemToShoppingCart(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);

        //Adding Apple to the basket
        myShoppingCart.addToShoppingCart(new ShoppingCartItem(Fruit.Apple, 1.0));

        assertThat(myShoppingCart.returnCartItems()).isEqualTo("Apple");
    }

    @Test
    public void shouldBeAbleToReturnTheItemsInTheShoppingCart(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);

        //Adding Apple, Orange, Strawberries and Peach to the basket
        myShoppingCart.addToShoppingCart(appleOneKiloOneDollarItem);
        myShoppingCart.addToShoppingCart(orangeTwoKiloTwoPointFiveDollarItem);
        myShoppingCart.addToShoppingCart(strawberriesOnePointFiveKiloThreePointSevenDollarItem);
        myShoppingCart.addToShoppingCart(peachOnePointTwoKiloOnePointTwoDollarItem);

        assertThat(myShoppingCart.returnCartItems()).isEqualTo("Apple, Orange, Strawberries, Peach");
    }

    @Test
    public void shouldReturnTheRunningTotalCartPrice(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);

        //Apple: 1 kilo * $1 = $1
        myShoppingCart.addToShoppingCart(appleOneKiloOneDollarItem);

        //Orange: 2 kilos * $2.5 = $5
        myShoppingCart.addToShoppingCart(orangeTwoKiloTwoPointFiveDollarItem);

        //Strawberries: 1.5 kilos * $3.7 = $5.55
        myShoppingCart.addToShoppingCart(strawberriesOnePointFiveKiloThreePointSevenDollarItem);

        //Peach: 1.2 kilos * $1.2 = $1.44
        myShoppingCart.addToShoppingCart(peachOnePointTwoKiloOnePointTwoDollarItem);

        //Expected: ($1 + $5 + $5.55 + $1.44) -> No discount is expected.
        assertThat(myShoppingCart.getRunningTotal()).isEqualTo(12.99);
    }

    @Test
    public void shouldGetTenPercentDiscountIfHaveAtLeastFiveKilosOfOneFruit(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);

        //Apple: 5 kilos * $1 = $5
        myShoppingCart.addToShoppingCart(appleFiveKiloOneDollarItem);

        //Orange: 2 kilos * $2.5 = $5
        myShoppingCart.addToShoppingCart(orangeTwoKiloTwoPointFiveDollarItem);

        //Strawberries: 1.5 kilos * $3.7 = $5.55
        myShoppingCart.addToShoppingCart(strawberriesOnePointFiveKiloThreePointSevenDollarItem);

        //Peach: 1.2 kilos * $1.2 = $1.44
        myShoppingCart.addToShoppingCart(peachOnePointTwoKiloOnePointTwoDollarItem);

        //Expected: ($5 + $5 + $5.55 + $1.44) - (($5 + $5 + $5.55 + $1.44) * 0.1) -> We have 10 percent discount on the total price
        assertThat(myShoppingCart.getRunningTotal()).isEqualTo(15.291);
    }

    @Test
    public void shouldGetOnlyTenPercentDiscountWithMoreThanOneFiveKilosItem(){

        //Create a shopping cart to be able to shop and add shopping cart item to it
        ShoppingCart myShoppingCart = new ShoppingCart(myCatalog);

        //Apple: 5 kilos  * $1 = $5
        myShoppingCart.addToShoppingCart(appleFiveKiloOneDollarItem);

        //Orange: 8 kilos * $2.5 = $20
        myShoppingCart.addToShoppingCart(orangeFiveKiloTwoPointFiveDollarItem);

        //Strawberries: 7 kilos * $3.7 = $25.9
        myShoppingCart.addToShoppingCart(strawberriesFiveKiloThreePointSevenDollarItem);

        //Peach: 1.2 kilos * $1.2 = $1.44
        myShoppingCart.addToShoppingCart(peachOnePointTwoKiloOnePointTwoDollarItem);

        //Expected: ($5 + $20 + $25.9 + $1.44) - (($5 + $20 + $25.9 + $1.44) * 0.1) -> We have 10 percent discount on the total price
        assertThat(myShoppingCart.getRunningTotal()).isEqualTo(47.106);

    }

    @Test
    public void shouldReturnTotalPriceAzZeroWhenTheBasketIsEmpty(){

        //Create a shopping cart - We wont add any item to check the total price of the empty basket
        ShoppingCart mySHoppingCart = new ShoppingCart(myCatalog);

        assertThat(mySHoppingCart.getRunningTotal()).isEqualTo(0.0);

    }
}
