package com.softwareplanttest.test.domain;

import java.util.List;
import java.util.Objects;

public class Character {

    private String name;

    private String url;

    private List<String> films;

    public Character(){}

    public Character(String name, String url, List<String> films) {
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

    public String getFilm(int index) {
        return films.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) &&
                Objects.equals(url, character.url) &&
                Objects.equals(films, character.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, films);
    }
}
