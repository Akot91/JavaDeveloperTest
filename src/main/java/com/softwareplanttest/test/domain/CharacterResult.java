package com.softwareplanttest.test.domain;

import java.util.List;
import java.util.Objects;

public class CharacterResult {

    private List<Character> characters;

    public CharacterResult() {}

    public CharacterResult(List<Character> characters) {
        this.characters = characters;
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterResult that = (CharacterResult) o;
        return Objects.equals(characters, that.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters);
    }

    @Override
    public String toString() {
        return "CharacterResult{" +
                "characters=" + characters +
                '}';
    }
}
