package com.softwareplanttest.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterDto that = (CharacterDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, films);
    }
}
