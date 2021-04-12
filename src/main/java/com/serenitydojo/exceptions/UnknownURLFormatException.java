package com.serenitydojo.exceptions;

public class UnknownURLFormatException extends RuntimeException {
    public UnknownURLFormatException() {
    }

    public UnknownURLFormatException(String message) {
        super(message);
    }

    public UnknownURLFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
