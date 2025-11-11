package org.example.logic.exercises;

import org.example.logic.exercises.CharacterFinder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterFinderTest {

    private final CharacterFinder characterFinder = new CharacterFinder();

    @Test
    public void givenSimpleUnique_whenFindFirstNonRepeated_thenReturnFirstChar() {
        //Given
        String text = "alphabet";

        //When
        Character result = characterFinder.findFirstNonRepeated(text);

        //Then
        char expetd = 'l';
        assertThat(result).isEqualTo(expetd);
    }

    @Test
    public void givenCaseInsensitiveInput_whenFindFirstNonRepeated_thenReturnCorrectChar() {
        //Given
        String text = "sTreSss";

        //When
        Character result = characterFinder.findFirstNonRepeated(text);

        //Then
        char expect = 't';
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenAllRepeated_whenFindFirstNonRepeated_thenReturnEmpty() {

        //Give
        String text = "aabbcc";

        //When
        Character result = characterFinder.findFirstNonRepeated(text);

        //Then
        Character expet = Character.MIN_VALUE;
        assertThat(result).isEqualTo(expet);
    }

    @Test
    public void givenEmptyString_whenFindFirstNonRepeated_thenReturnEmpty() {

        //Given
        String text = "";

        //When
        Character result = characterFinder.findFirstNonRepeated(text);

        //Then
        Character expect = Character.MIN_VALUE;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenNullInput_whenFindFirstNonRepeated_thenReturnEmpty() {

        //Given
        String text = null;

        //When
        Character result = characterFinder.findFirstNonRepeated(text);

        //Then
        Character expect = Character.MIN_VALUE;
        assertThat(result).isEqualTo(expect);


    }
}

