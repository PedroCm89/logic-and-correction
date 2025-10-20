package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringProcessorTest {

    StringProcessor stringProcessor = new StringProcessor();

    @Test
    public void givenMixedString_whenExtractAndSum_thenReturnCorrectSum (){
        //Given
        String sentence = "Pedido 10, constro 200 y despuesto 5";

        //When
        int result = stringProcessor.extractNumbersAndSum(sentence);

        //Then
        int expect = 215;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenNoNumbers_whenExtractAndSum_thenReturnZero (){
        //Given
        String sentence = "Solo texto sin numero";

        //When
        int result = stringProcessor.extractNumbersAndSum(sentence);

        //Then
        int expect = 0;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenEmptyString_whenExtractAndSum_thenReturnZero(){
        //Given
        String sentence = "";

        //When
        int result = stringProcessor.extractNumbersAndSum(sentence);

        //Then
        int expect =0;
        assertThat(result).isEqualTo(expect);

    }

    @Test
    public void givenNumbersAtEnds_whenExtractAndSum_thenReturnCorrectSum(){
        //Given
        String sentece = "50 Total 100";

        //When
        int result = stringProcessor.extractNumbersAndSum(sentece);

        //Then
        int expect = 150;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenNumbersSeparatedByDots_whenExtractAndSum_thenReturnCorrectSum(){
        //Given
        String sentece = "1,2,3";

        //When
        int result = stringProcessor.extractNumbersAndSum(sentece);

        //Then
        int expect = 6;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenNullInput_whenExtractAndSum_thenReturnZero(){
        //Given
        String sentence = null;

        //When
        int result = stringProcessor.extractNumbersAndSum(sentence);

        //Then
        int expect =0;
        assertThat(result).isEqualTo(expect);
    }
}
