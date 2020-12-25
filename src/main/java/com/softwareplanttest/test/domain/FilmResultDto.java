package com.softwareplanttest.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmResultDto {

    @JsonProperty(value = "results")
    private List<FilmDto> films;

    public FilmResultDto (){}

    public FilmResultDto(List<FilmDto> films) {
        this.films = films;
    }

    public List<FilmDto> getFilms() {
        return films;
    }
}
