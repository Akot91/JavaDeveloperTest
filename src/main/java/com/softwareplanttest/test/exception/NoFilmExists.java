package com.softwareplanttest.test.exception;

public class NoFilmExists extends RuntimeException {
    public NoFilmExists(String message) {
        super(message);
    }
}
