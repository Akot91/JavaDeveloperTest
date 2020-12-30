package com.softwareplant.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterResultDto {

    @JsonProperty(value = "results")
    private List<CharacterDto> characters;

    public CharacterResultDto() {}

    public CharacterResultDto(List<CharacterDto> characters) {
        this.characters = characters;
    }

    public List<CharacterDto> getCharacters() {
        return characters;
    }

    public int getCharactersSize() {
        return characters.size();
    }

    public CharacterDto getCharacter(int index) {
        return characters.get(index);
    }
}
