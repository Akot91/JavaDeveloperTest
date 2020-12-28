package com.softwareplanttest.test.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.softwareplanttest.test.domain.Character;
import com.softwareplanttest.test.domain.CharacterDto;
import com.softwareplanttest.test.domain.CharacterResult;
import com.softwareplanttest.test.domain.CharacterResultDto;
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
public class CharacterMapperTestSuite {

    @Autowired
    private CharacterMapper testee;

    @Test
    public void shouldReturnCharacter() {
        //Given
        List<String> testFilms = new ArrayList<>();
        testFilms.add("test1");
        testFilms.add("test2");
        testFilms.add("test3");
        CharacterDto characterDto = new CharacterDto("test_name", "test_url", testFilms);

        //When
        Character result = testee.mapToCharacter(characterDto);

        //Then
        Assert.assertEquals("test_name", result.getName());
        Assert.assertEquals("test_url", result.getUrl());
        Assert.assertEquals(3, result.getFilms().size());
    }

    @Test(expected = NullPointerException.class)
    public void mapToCharacterShouldReturnException() {
        //Given //When //Then
        Character result = testee.mapToCharacter(null);
    }

    @Test
    public void shouldReturnCharacterResult() {
        //Given
        List<String> testFilms = new ArrayList<>();
        testFilms.add("test1");
        CharacterDto characterDto = new CharacterDto("test_name", "test_url", testFilms);
        List<CharacterDto> characterDtos = new ArrayList<>();
        characterDtos.add(characterDto);
        CharacterResultDto characterResultDto = new CharacterResultDto(characterDtos);

        //When
        CharacterResult result = testee.mapToCharacterResult(characterResultDto);

        //Then
        Assert.assertEquals(1, result.getCharactersSize());
    }

    @Test(expected = NullPointerException.class)
    public void mapToCharacterResultShouldReturnException() {
        //Given When Then
        CharacterResult result = testee.mapToCharacterResult(null);
    }
}
