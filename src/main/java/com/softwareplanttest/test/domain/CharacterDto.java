package com.softwareplanttest.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "films")
    private List<String> films;

    public CharacterDto(){}

    public CharacterDto(String name, String url,  List<String> films) {
        this.name = name;
        this.url = url;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getFilms() {
        return films;
    }
}
