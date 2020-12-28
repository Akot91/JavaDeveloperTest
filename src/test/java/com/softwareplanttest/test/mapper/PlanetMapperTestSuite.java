package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Planet;
import com.softwareplanttest.test.domain.PlanetDto;
import com.softwareplanttest.test.domain.PlanetResult;
import com.softwareplanttest.test.domain.PlanetResultDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlanetMapperTestSuite {

    @Autowired
    private PlanetMapper testee;

    @Test
    public void shouldReturnPlaner() {
        //Given
        List<String> residents = new ArrayList<>();
        residents.add("resident_1");
        residents.add("resident_2");
        PlanetDto planetDto = new PlanetDto("test_name", "test_url", residents);

        //When
        Planet result = testee.mapToPlanet(planetDto);

        //Then
        Assert.assertEquals("test_name", result.getName());
        Assert.assertEquals("test_url", result.getUrl());
        Assert.assertEquals(2, result.getResidents().size());
    }

    @Test(expected = NullPointerException.class)
    public void mapToPlanetShouldReturnException() {
        //Given When Then
        Planet result = testee.mapToPlanet(null);
    }

    @Test
    public void shouldReturnPlanetResult() {
        //Given
        List<PlanetDto> planets = new ArrayList<>();
        List<String> residents = new ArrayList<>();
        residents.add("resident_1");
        PlanetDto planetDto = new PlanetDto("test_name", "test_url", residents);
        planets.add(planetDto);
        PlanetResultDto planetResultDto = new PlanetResultDto(planets);

        //When
        PlanetResult result = testee.mapToPlanetResult(planetResultDto);

        //Then
        Assert.assertEquals(1, result.getPlanetsSize());
    }

    @Test(expected = NullPointerException.class)
    public void mapToPlanetResultShouldReturnException() {
        //Given When Then
        PlanetResult result = testee.mapToPlanetResult(null);
    }
}
