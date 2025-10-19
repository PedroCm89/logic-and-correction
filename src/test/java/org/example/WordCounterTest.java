package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void givenSentence_whenCounter_thenVerfy(){


        //Give
        String sentence = "casa,casa paco";

        //When
        Map<String ,Integer> result = wordCounter.wordsCounter(sentence);

        //Then
        Map<String, Integer> expected = Map.of(
                "casa",2,
                "paco",1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void givenEmptySentence_whenCounter_thenReturnsEmpty(){

        //Give
        String emptySentence = "";

        //When
        Map<String,Integer> result = wordCounter.wordsCounter(emptySentence);

        //Then
        Map<String , Integer> expected = Map.of();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void givenNullSentence_whenCounter_thenReturnEmpty(){
        //Give
        String nullSentence = null;

        //When
        Map<String,Integer> result = wordCounter.wordsCounter(nullSentence);

        //Then
        Map<String, Integer> expected = Map.of();
        assertThat(result).isEqualTo(expected);
    }

}
