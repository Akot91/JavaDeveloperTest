package com.softwareplanttest.test.client;

import com.softwareplanttest.test.config.ApiConfiguration;
import com.softwareplanttest.test.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SWAPIClientTestSuite {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ApiConfiguration apiConfiguration;

    @InjectMocks
    private SWAPIClient testee;

    @Before
    public void init() {
        when(apiConfiguration.getPeopleApiUrl()).thenReturn("https://testpeople.com/");
        when(apiConfiguration.getPlanetsApiUrl()).thenReturn("https://testplanets.com/");
    }

    @Test
    public void shouldReturnPlanetResultBySearch() throws URISyntaxException {
        //Given
        List<PlanetDto> planets = new ArrayList<>();
        List<String> residents = new ArrayList<>();
        residents.add("resident_1");
        PlanetDto planetDto = new PlanetDto("test_name", "test_url", residents);
        planets.add(planetDto);
        PlanetResultDto planetResultDto = new PlanetResultDto(planets);

        URI uri = new URI("https://testplanets.com/?search=Alderaan");

        when(restTemplate.getForObject(uri, PlanetResultDto.class)).thenReturn(planetResultDto);

        //When
        PlanetResultDto result = testee.getPlanetBySearch("Alderaan");

        //Then
        Assert.assertEquals(1, result.getPlanets().size());
    }

    @Test
    public void shouldReturnCharacterResultDtoBySearch() throws URISyntaxException {
        //Given
        List<String> testFilms = new ArrayList<>();
        testFilms.add("test1");
        CharacterDto characterDto = new CharacterDto("test_name", "test_url", testFilms);
        List<CharacterDto> characterDtos = new ArrayList<>();
        characterDtos.add(characterDto);
        CharacterResultDto characterResultDto = new CharacterResultDto(characterDtos);

        URI uri = new URI("https://testpeople.com/?search=Luke");

        when(restTemplate.getForObject(uri, CharacterResultDto.class)).thenReturn(characterResultDto);

        //When
        CharacterResultDto result = testee.getCharacterBySearch("Luke");

        //Then
        Assert.assertEquals(1, result.getCharacters().size());
    }

    @Test
    public void shouldReturnCharacterByUrl() throws URISyntaxException {
        //Given
        List<String> testFilms = new ArrayList<>();
        testFilms.add("test1");
        CharacterDto characterDto = new CharacterDto("test_name", "test_url", testFilms);

        URI uri = new URI("https://testpeople.com/");

        when(restTemplate.getForObject(uri, CharacterDto.class)).thenReturn(characterDto);

        //When
        CharacterDto result = testee.getCharacterByUrl("https://testpeople.com/");

        //Then
        Assert.assertEquals("test_name", result.getName());
        Assert.assertEquals("test_url", result.getUrl());
        Assert.assertEquals(1, result.getFilms().size());
    }
}
