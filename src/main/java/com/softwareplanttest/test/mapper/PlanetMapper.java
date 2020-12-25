package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Planet;
import com.softwareplanttest.test.domain.PlanetDto;
import com.softwareplanttest.test.domain.PlanetResult;
import com.softwareplanttest.test.domain.PlanetResultDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlanetMapper {

    public Planet mapToPlanet(PlanetDto planetDto) {
        return new Planet(planetDto.getName(), planetDto.getUrl(), planetDto.getResidents());
    }

    public PlanetResult mapToPlanetResult(PlanetResultDto planetResultDto) {
        return new PlanetResult(planetResultDto.getPlanets()
                .stream()
                .map(planetDto -> mapToPlanet(planetDto))
                .collect(Collectors.toList()));
    }

}
