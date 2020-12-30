package com.softwareplant.test.service;

import com.softwareplant.test.client.SWAPIClient;
import com.softwareplant.test.domain.ReportResult;
import com.softwareplant.test.dto.*;
import com.softwareplant.test.exception.FilmNotFoundException;
import com.softwareplant.test.exception.PlanetNotFoundException;
import com.softwareplant.test.exception.ResidentsNotFoundException;
import com.softwareplant.test.model.ReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportCreator {

    @Autowired
    private SWAPIClient SWAPIclient;

    public ReportResult prepareReport(ReportQuery reportQuery) {
        PlanetDto planet = findPlanet(reportQuery.getQueryCriteriaPlanetName());
        Long planetId = getIdFromUrl(planet.getUrl());

        CharacterDto character = findCharacter(planet.getResidents(), reportQuery.getQueryCriteriaCharacterPhrase());
        Long characterId = getIdFromUrl(character.getUrl());

        FilmDto film = findFilm(character.getFilms());
        Long filmId = getIdFromUrl(film.getUrl());

        return new ReportResult.Builder()
                .filmId(filmId)
                .filmName(film.getTitle())
                .characterId(characterId)
                .characterName(character.getName())
                .planetId(planetId)
                .planetName(planet.getName())
                .build();
    }

    private PlanetDto findPlanet(String planetName) {
        PlanetResultDto planetsDto = SWAPIclient.getPlanetByName(planetName);
        PlanetDto result;
        if (planetsDto.getPlanetsSize() == 0) {
            throw new PlanetNotFoundException(planetName);
        } else {
            result = planetsDto.getPlanet(0);
        }
        return result;
    }

    private CharacterDto findCharacter(List<String> residents, String characterName) {
        List<CharacterDto> residentsResult = new ArrayList<>();
        if (residents.size() == 0) {
            throw new ResidentsNotFoundException(characterName);
        } else {
            for (String resident : residents) {
                residentsResult.add(SWAPIclient.getCharacterByUrl(resident));
            }
        }
        CharacterResultDto searchedCharacterResult = SWAPIclient.getCharacterByName(characterName);
        if (searchedCharacterResult.getCharactersSize() == 0) {
            throw new ResidentsNotFoundException(characterName);
        }
        CharacterDto searchedCharacter = searchedCharacterResult.getCharacter(0);
        CharacterDto result = new CharacterDto();
        for (CharacterDto resident : residentsResult) {
            if (resident.equals(searchedCharacter)) {
                result = resident;
                break;
            }
        }
        return result;
    }

    private FilmDto findFilm(List<String> films) {
        if (films.size() == 0) {
            throw new FilmNotFoundException("No films found for this query");
        }
        return SWAPIclient.getFilmByUrl(films.get(0));
    }

    private Long getIdFromUrl(String url) {
        String[] urls = url.split("/");
        String result = urls[urls.length -1];
        return Long.parseLong(result);
    }
}
