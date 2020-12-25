package com.softwareplanttest.test.domain;

import java.util.Objects;

public class Film {

    private String title;

    private String url;

    public Film() {}

    public Film(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title) &&
                Objects.equals(url, film.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
