package com.softwareplanttest.test.exception;

public class ResidentsNotFoundException extends RuntimeException {
    public ResidentsNotFoundException(String character) {
        super("There are no character called " + character);
    }
}
