package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Film;
import com.softwareplanttest.test.domain.FilmDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FilmMapperTestSuite {

    @Autowired
    private FilmMapper testee;

    @Test
    public void shouldReturnFilm() {
        //Given
        FilmDto filmDto = new FilmDto("test_title", "test_url");

        //When
        Film result = testee.mapToFilm(filmDto);

        //Then
        Assert.assertEquals("test_title", result.getTitle());
        Assert.assertEquals("test_url", result.getUrl());
    }

    @Test(expected = NullPointerException.class)
    public void mapToFilmShouldReturnException() {
        //Given When Then
        Film result = testee.mapToFilm(null);
    }
}
