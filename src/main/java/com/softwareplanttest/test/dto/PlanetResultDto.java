package com.softwareplanttest.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetResultDto {

    @JsonProperty(value = "results")
    private List<PlanetDto> planets;

    public PlanetResultDto() {}

    public PlanetResultDto(List<PlanetDto> planets) {
        this.planets = planets;
    }

    public List<PlanetDto> getPlanets() {
        return planets;
    }

    public int getPlanetsSize() {
        return planets.size();
    }

    public PlanetDto getPlanet(int index) {
        return planets.get(index);
    }
}
