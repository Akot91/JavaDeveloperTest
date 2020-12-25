package com.softwareplanttest.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDto {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "url")
    private String url;

    public FilmDto() {}

    public FilmDto(String title,  String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
