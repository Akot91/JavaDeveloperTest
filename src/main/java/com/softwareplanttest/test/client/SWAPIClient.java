package com.softwareplanttest.test.client;

import com.softwareplanttest.test.config.ApiConfiguration;
import com.softwareplanttest.test.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
public class SWAPIClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiConfiguration apiConfiguration;

    public CharacterResultDto getCharacterBySearch(String search) {
        return Optional.ofNullable(restTemplate.getForObject(getCharacterBySearchUrl(search), CharacterResultDto.class)).orElseGet(CharacterResultDto::new);
    }

    public CharacterDto getCharacterByUrl(String forwardedUrl) {
        return Optional.ofNullable(restTemplate.getForObject(getCharacterUrl(forwardedUrl), CharacterDto.class)).orElseGet(CharacterDto::new);
    }

    public PlanetResultDto getPlanet(String search) {
        return Optional.ofNullable(restTemplate.getForObject(getPlanetUrl(search), PlanetResultDto.class)).orElseGet(PlanetResultDto::new);
    }

    public FilmDto getFilm(String forwardedUrl) {
        return Optional.ofNullable(restTemplate.getForObject(getFilmUrl(forwardedUrl), FilmDto.class)).orElseGet(FilmDto::new);
    }

    private URI getFilmUrl(String forwardedUrl) {
        return UriComponentsBuilder.fromHttpUrl(forwardedUrl)
                .build()
                .encode()
                .toUri();
    }

    private URI getPlanetUrl(String search) {
        return UriComponentsBuilder.fromHttpUrl(apiConfiguration.getPlanetsApiUrl())
                .queryParam("search", search)
                .build()
                .encode()
                .toUri();
    }

    private URI getCharacterBySearchUrl(String search) {
        return UriComponentsBuilder.fromHttpUrl(apiConfiguration.getPeopleApiUrl())
                .queryParam("search", search)
                .build()
                .encode()
                .toUri();
    }

    private URI getCharacterUrl(String forwardedUrl) {
        return UriComponentsBuilder.fromHttpUrl(forwardedUrl)
                .build()
                .encode()
                .toUri();
    }
}
