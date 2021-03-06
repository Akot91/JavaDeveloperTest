package com.softwareplant.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
public class ReportEntryDto {

    @JsonIgnore
    private Long id;

    private Long filmId;

    private String filmName;

    private Long characterId;

    private String characterName;

    private Long planetId;

    private String planetName;

    public ReportEntryDto() {
    }

    public ReportEntryDto(Long filmId, String filmName, Long characterId, String characterName, Long planetId, String planetName) {
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

    public static final class Builder {
        private Long filmId;
        private String filmName;
        private Long characterId;
        private String characterName;
        private Long planetId;
        private String planetName;

        public ReportEntryDto.Builder filmId(Long filmId) {
            this.filmId = filmId;
            return this;
        }

        public ReportEntryDto.Builder filmName(String filmName) {
            this.filmName = filmName;
            return this;
        }

        public ReportEntryDto.Builder characterId(Long characterId) {
            this.characterId = characterId;
            return this;
        }

        public ReportEntryDto.Builder characterName(String characterName) {
            this.characterName = characterName;
            return this;
        }

        public ReportEntryDto.Builder planetId(Long planetId) {
            this.planetId = planetId;
            return this;
        }

        public ReportEntryDto.Builder planetName(String planetName) {
            this.planetName = planetName;
            return this;
        }

        public ReportEntryDto build() {
            return new ReportEntryDto(filmId, filmName, characterId, characterName, planetId, planetName);
        }
    }
}
