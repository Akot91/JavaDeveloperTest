package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Film;
import com.softwareplanttest.test.domain.FilmDto;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    public Film mapToFilm(final FilmDto filmDto) {
        return new Film(filmDto.getTitle(), filmDto.getUrl());
    }

}
