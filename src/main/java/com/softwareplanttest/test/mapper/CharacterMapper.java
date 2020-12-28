package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Character;
import com.softwareplanttest.test.domain.CharacterDto;
import com.softwareplanttest.test.domain.CharacterResult;
import com.softwareplanttest.test.domain.CharacterResultDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CharacterMapper {

    public Character mapToCharacter(final CharacterDto characterDto) {
        return new Character(characterDto.getName(), characterDto.getUrl(), characterDto.getFilms());
    }

    public CharacterResult mapToCharacterResult(final CharacterResultDto characterResultDto) {
        return new CharacterResult(characterResultDto.getCharacters()
                .stream()
                .map(characterDto -> mapToCharacter(characterDto))
                .collect(Collectors.toList()));
    }

}
