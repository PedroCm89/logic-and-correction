package org.example.logic.exercises;

import org.example.logic.exercises.TextNumberExtractor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextNumberExtractorTest {

    TextNumberExtractor textNumberExtractor = new TextNumberExtractor();

    @Test
    void givenNullInput_whenExtract_thenReturnZero() {

        //Give
        String text = null;


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 0;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void givenEmptyString_whenExtract_thenReturnZero() {

        //Give
        String text = "";


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 0;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void givenOnlyText_whenExtract_thenReturnZero() {

        //Give
        String text = "This has no numbers";


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 0;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void givenNumbersInMiddle_whenExtract_thenReturnSum() {

        //Give
        String text = "abc123def456gh";


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 579;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void givenStringEndingWithNumber_whenExtract_thenReturnSum() {

        //Give
        String text = "Item 10 Cost 200";


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 210;
        assertThat(result).isEqualTo(expect);
    }


    @Test
    void givenConsecutiveNonDigits_whenExtract_thenReturnSum() {

        //Give
        String text = "10..20;;30";


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 60;
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void givenOnlyNumberString_whenExtract_thenReturnNumber() {

        //Give
        String text = "999";


        //When
        int result = textNumberExtractor.sumNumbersWithoutRegex(text);

        //Then
        int expect = 999;
        assertThat(result).isEqualTo(expect);
    }
}
