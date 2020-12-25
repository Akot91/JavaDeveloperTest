package com.softwareplanttest.test.domain;

import java.util.List;
import java.util.Objects;

public class PlanetResult {

    private List<Planet> planets;

    public PlanetResult() {}

    public PlanetResult(List<Planet> planets) {
        this.planets = planets;
    }

    public Planet getPlanet(int index) {
        return planets.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetResult that = (PlanetResult) o;
        return Objects.equals(planets, that.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planets);
    }

    @Override
    public String toString() {
        return "PlanetResult{" +
                "planets=" + planets +
                '}';
    }
}
