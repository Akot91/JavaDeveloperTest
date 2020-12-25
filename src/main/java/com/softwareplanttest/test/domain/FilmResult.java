package com.softwareplanttest.test.domain;

import java.util.List;
import java.util.Objects;

public class FilmResult {

    private List<Film> films;

    public FilmResult (){}

    public FilmResult(List<Film> films) {
        this.films = films;
    }

    public Film getFilm(int index) {
        return films.get(index);
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmResult that = (FilmResult) o;
        return Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(films);
    }

    @Override
    public String toString() {
        return "FilmResult{" +
                "films=" + films +
                '}';
    }
}
