package com.softwareplant.test.client;

import com.softwareplant.test.config.ApiConfiguration;
import com.softwareplant.test.dto.CharacterDto;
import com.softwareplant.test.dto.CharacterResultDto;
import com.softwareplant.test.dto.FilmDto;
import com.softwareplant.test.dto.PlanetResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
public class SWAPIClient {

    private static final String PEOPLE_PATH = "api/people";
    private static final String PLANETS_PATH = "api/planets";

    private final RestTemplate restTemplate;

    private final ApiConfiguration apiConfiguration;

    @Autowired
    public SWAPIClient(RestTemplate restTemplate, ApiConfiguration apiConfiguration) {
        this.restTemplate = restTemplate;
        this.apiConfiguration = apiConfiguration;
    }

    public CharacterResultDto getCharacterByName(String name) {
        try {
            return Optional.ofNullable(restTemplate.getForObject(getCharacterByNameUrl(name), CharacterResultDto.class))
                    .orElseGet(CharacterResultDto::new);
        } catch (RestClientException e) {
            return new CharacterResultDto();
        }
    }

    public CharacterDto getCharacterByUrl(String forwardedUrl) {
        try {
            return Optional.ofNullable(restTemplate.getForObject(getCharacterUrl(forwardedUrl), CharacterDto.class))
                    .orElseGet(CharacterDto::new);
        } catch (RestClientException e) {
            return new CharacterDto();
        }
    }

    public PlanetResultDto getPlanetByName(String name) {
        try {
            return Optional.ofNullable(restTemplate.getForObject(getPlanetByNameUrl(name), PlanetResultDto.class))
                    .orElseGet(PlanetResultDto::new);
        } catch (RestClientException e) {
            return new PlanetResultDto();
        }
    }

    public FilmDto getFilmByUrl(String forwardedUrl) {
        try {
            return Optional.ofNullable(restTemplate.getForObject(getFilmUrl(forwardedUrl), FilmDto.class))
                    .orElseGet(FilmDto::new);
        } catch (RestClientException e) {
            return new FilmDto();
        }
    }

    private URI getFilmUrl(String forwardedUrl) {
        return UriComponentsBuilder.fromHttpUrl(forwardedUrl)
                .build()
                .encode()
                .toUri();
    }

    private URI getPlanetByNameUrl(String name) {
        return UriComponentsBuilder.fromHttpUrl(apiConfiguration.getSWAPIHost() + PLANETS_PATH)
                .queryParam("search", name)
                .build()
                .encode()
                .toUri();
    }

    private URI getCharacterByNameUrl(String name) {
        return UriComponentsBuilder.fromHttpUrl(apiConfiguration.getSWAPIHost() + PEOPLE_PATH)
                .queryParam("search", name)
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
