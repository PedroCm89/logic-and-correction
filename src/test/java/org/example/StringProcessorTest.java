package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringProcessorTest {

    StringProcessor stringProcessor = new StringProcessor();

    @Test
    public void givenStringWhitNumbersAndCharacter_whenExtractAndSum_thenReturnCorrectSum (){
        //Given
        String sentence = "Order 10, cost 200 y added5";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expect = 215;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenStringWithoutNumbers_whenExtractAndSum_thenReturnZero (){
        //Given
        String sentence = "Only text";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expect = 0;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenEmptyString_whenExtractAndSum_thenReturnZero(){
        //Given
        String sentence = "";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expect =0;
        assertThat(result).isEqualTo(expect);

    }


    @Test
    public void givenNumbersSeparatedByDots_whenExtractAndSum_thenReturnCorrectSum(){
        //Given
        String sentece = "1,2,3";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentece);

        //Then
        int expect = 6;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenNull_whenExtractAndSum_thenReturnZero(){
        //Given
        String sentence = null;

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expect =0;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void givenNumber_whenExtractAndSum_thenThrowsException(){

        //Given
        String sentence = "123456789";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expected = 123456789;
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void givenStringWithMultipleEmbeddedNumbers_whenExtractAndSum_thenReturnCorrectSum(){

        //Given
        String sentence = "asd123asd1234asd3456";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expect = 4813;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void giveOnlyOneNumber_whenExtractedAndSum_thenRestunSameNumber(){

        //Given
        String sentence= "4";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expected= 4;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void givenNumbersWithADashBefore_whenExtractedAndSum_thenTheyAreManagedAsPositiveNumbers(){

        //Given
        String sentence = "rt2-39,5";

        //When
        int result = stringProcessor.sumNumbersInStringFormat(sentence);

        //Then
        int expect = 46;
        assertThat(result).isEqualTo(expect);
    }


}
