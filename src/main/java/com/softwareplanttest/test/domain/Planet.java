package com.softwareplanttest.test.domain;

import java.util.List;
import java.util.Objects;

public class Planet {

    private String name;

    private String url;

    private List<String> residents;

    public Planet() {}

    public Planet(String name, String url, List<String> residents) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name) &&
                Objects.equals(url, planet.url) &&
                Objects.equals(residents, planet.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, residents);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", residents=" + residents +
                '}';
    }
}
