package com.softwareplanttest.test.service;

import com.softwareplanttest.test.client.SWAPIClient;
import com.softwareplanttest.test.domain.*;
import com.softwareplanttest.test.domain.Character;
import com.softwareplanttest.test.exception.NoCharacterExists;
import com.softwareplanttest.test.exception.NoFilmExists;
import com.softwareplanttest.test.exception.NoResidentsException;
import com.softwareplanttest.test.exception.PlanetNotFoundException;
import com.softwareplanttest.test.mapper.CharacterMapper;
import com.softwareplanttest.test.mapper.FilmMapper;
import com.softwareplanttest.test.mapper.PlanetMapper;
import com.softwareplanttest.test.model.ReportQuery;
import com.softwareplanttest.test.model.ReportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportCreator {

    @Autowired
    private SWAPIClient client;

    @Autowired
    private PlanetMapper planetMapper;
    
    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private FilmMapper filmMapper;

    public ReportResult prepareReport(ReportQuery reportQuery) {
        Planet planet = findPlanet(reportQuery.getQueryCriteriaPlanetName());
        Long planetId = getIdFromUrl(planet.getUrl());

        Character character = findCharacter(planet.getResidents(), reportQuery.getQueryCriteriaCharacterPhrase());
        Long characterId = getIdFromUrl(character.getUrl());

        Film film = findFilm(character.getFilms());
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

    private Planet findPlanet(String planetName) {
        PlanetResultDto planetsDto = client.getPlanetBySearch(planetName);
        PlanetResult planetResult = planetMapper.mapToPlanetResult(planetsDto);
        Planet result;
        if (planetResult.getPlanetsSize() == 0) {
            throw new PlanetNotFoundException("There are no planets called " + planetName);
        } else {
            result = planetResult.getPlanet(0);
        }
        return result;
    }

    private Character findCharacter(List<String> residents, String characterName) {
        List<Character> residentsResult = new ArrayList<>();
        if (residents.size() == 0) {
            throw new NoResidentsException("There are no residents on this planet or this planet does'n exists!");
        } else {
            for (String resident : residents) {
                residentsResult.add(characterMapper.mapToCharacter(client.getCharacterByUrl(resident)));
            }
        }
        CharacterResult searchedCharacterResult = characterMapper.mapToCharacterResult(client.getCharacterBySearch(characterName));
        if (searchedCharacterResult.getCharactersSize() == 0) {
            throw new NoCharacterExists("There are no character called " + characterName);
        }
        Character searchedCharacter = searchedCharacterResult.getCharacter(0);
        Character result = new Character();
        for (Character resident : residentsResult) {
            if (resident.equals(searchedCharacter)) {
                result = resident;
                break;
            }
        }
        return result;
    }

    private Film findFilm(List<String> films) {
        if (films.size() == 0) {
            throw new NoFilmExists("No films found for this query");
        }
        return filmMapper.mapToFilm(client.getFilmByUrl(films.get(0)));
    }

    private Long getIdFromUrl(String url) {
        String[] urls = url.split("/");
        String result = urls[urls.length -1];
        return Long.parseLong(result);
    }
}
