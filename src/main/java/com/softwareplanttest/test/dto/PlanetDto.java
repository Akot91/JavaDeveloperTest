package com.softwareplanttest.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "residents")
    private List<String> residents;

    public PlanetDto() {}

    public PlanetDto(String name, String url, List<String> residents) {
        this.name = name;
        this.url = url;
        this.residents = residents;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getResidents() {
        return residents;
    }

}
