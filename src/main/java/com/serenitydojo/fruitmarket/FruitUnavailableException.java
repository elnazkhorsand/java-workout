package com.serenitydojo.fruitmarket;

// TODO: 18/03/2021 The Catalog should throw a FruitUnavailableException if the fruit is not currently available
public class FruitUnavailableException extends RuntimeException{
    public FruitUnavailableException(String message) {
        super(message);
    }

    public FruitUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
