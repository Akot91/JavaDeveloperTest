package com.softwareplant.test.exception;

public class PlanetNotFoundException extends RuntimeException {
    public PlanetNotFoundException(String planetName) {
        super("There are no planets called " + planetName);
    }
}
