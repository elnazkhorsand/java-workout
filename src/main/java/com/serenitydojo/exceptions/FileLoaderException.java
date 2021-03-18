package com.serenitydojo.exceptions;

public class FileLoaderException extends RuntimeException{
    public FileLoaderException(String message) {
        super(message);
    }

    public FileLoaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
