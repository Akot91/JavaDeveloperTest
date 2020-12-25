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
        return Optional.ofNullable(restTemplate.getForObject(getCharacterBySearchUrl(search), CharacterResultDto.class)).orElseGet(() -> new CharacterResultDto());
    }

    public CharacterDto getCharacterByUrl(String forwardedUrl) {
        return Optional.ofNullable(restTemplate.getForObject(getCharacterUrl(forwardedUrl), CharacterDto.class)).orElseGet(() -> new CharacterDto());
    }

    public PlanetResultDto getPlanet(String search) {
        return Optional.ofNullable(restTemplate.getForObject(getPlanetUrl(search), PlanetResultDto.class)).orElseGet(() -> new PlanetResultDto());
    }

    public FilmDto getFilm(String forwardedUrl) {
        return Optional.ofNullable(restTemplate.getForObject(getFilmUrl(forwardedUrl), FilmDto.class)).orElseGet(() -> new FilmDto());
    }

    private URI getFilmUrl(String forwardedUrl) {
        URI url = UriComponentsBuilder.fromHttpUrl(forwardedUrl)
                .build()
                .encode()
                .toUri();
        return url;
    }

    private URI getPlanetUrl(String search) {
        URI url = UriComponentsBuilder.fromHttpUrl(apiConfiguration.getPlanetsApiUrl())
                .queryParam("search", search)
                .build()
                .encode()
                .toUri();
        return url;
    }

    private URI getCharacterBySearchUrl(String search) {
        URI url = UriComponentsBuilder.fromHttpUrl(apiConfiguration.getPeopleApiUrl())
                .queryParam("search", search)
                .build()
                .encode()
                .toUri();
        return url;
    }

    private URI getCharacterUrl(String forwardedUrl) {
        URI url = UriComponentsBuilder.fromHttpUrl(forwardedUrl)
                .build()
                .encode()
                .toUri();
        return url;
    }
}
