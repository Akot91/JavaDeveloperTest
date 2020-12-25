package com.softwareplanttest.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class ReportResult {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "planet_id")
    private Long planetId;

    @Column(name = "planet_name")
    private String planetName;

    @OneToOne(mappedBy = "result")
    private Report report;

    public ReportResult() {
    }

    public ReportResult(Long filmId, String filmName, Long characterId, String characterName, Long planetId, String planetName) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.characterId = characterId;
        this.characterName = characterName;
        this.planetId = planetId;
        this.planetName = planetName;
    }

    public Long getId() {
        return id;
    }

    public Long getFilmId() {
        return filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Long getPlanetId() {
        return planetId;
    }

    public String getPlanetName() {
        return planetName;
    }
}
