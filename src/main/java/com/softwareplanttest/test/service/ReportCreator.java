package com.softwareplanttest.test.service;

import com.softwareplanttest.test.client.SWAPIClient;
import com.softwareplanttest.test.domain.*;
import com.softwareplanttest.test.domain.Character;
import com.softwareplanttest.test.mapper.CharacterMapper;
import com.softwareplanttest.test.mapper.FilmMapper;
import com.softwareplanttest.test.mapper.PlanetMapper;
import com.softwareplanttest.test.model.Report;
import com.softwareplanttest.test.model.ReportQuery;
import com.softwareplanttest.test.model.ReportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportCreator {

    @Autowired
    private SWAPIClient cLient;

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

        return new ReportResult(
                filmId,
                film.getTitle(),
                characterId,
                character.getName(),
                planetId,
                planet.getName()
        );
    }

    private Planet findPlanet(String planetName) {
        PlanetResultDto planetsDto = cLient.getPlanet(planetName);
        PlanetResult planetResult = planetMapper.mapToPlanetResult(planetsDto);
        Planet result = planetResult.getPlanet(0);
        return result;
    }

    private Character findCharacter(List<String> residents, String characterName) {
        List<Character> residentsResult = new ArrayList<>();
        for (String resident : residents) {
            residentsResult.add(characterMapper.mapToCharacter(cLient.getCharacterByUrl(resident)));
        }
        CharacterResult searchedCharacterResult = characterMapper.mapToCharacterResult(cLient.getCharacterBySearch(characterName));
        Character searchedCharacter = searchedCharacterResult.getCharacter(0);
        for (Character resident : residentsResult) {
            if (resident.equals(searchedCharacter)) {
                return resident;
            }
        }
        return null;
    }

    private Film findFilm(List<String> films) {
        Film filmResult = filmMapper.mapToFilm(cLient.getFilm(films.get(0)));
        return filmResult;
    }

    private Long getIdFromUrl(String url) {
        String[] urls = url.split("/");
        String result = urls[urls.length -1];
        return Long.parseLong(result);
    }
}
