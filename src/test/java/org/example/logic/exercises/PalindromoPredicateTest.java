package org.example.logic.exercises;

import org.example.logic.exercises.PalindromoPredicate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PalindromoPredicateTest {

    private PalindromoPredicate palindromoPredicate = new PalindromoPredicate();

    @Test
    public void givenWords_whenInvertir_thenVerifyIsPalindromo(){

    //Given

        String word = "paco";
    //When

        String result = palindromoPredicate.reverse(word);

    //Then
        String expected = "ocap";

        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void givenStringEmpty_whenInvertid_thenVerifyinEmpty(){

        //Given
        String wordeEmpty = "";

        //When
         String result = palindromoPredicate.reverse(wordeEmpty);

        //Then
        assertThat(result).isEmpty();

    }

    @Test
    public void givenStringNull_whenInvertid_thenGiveNullPointerExcepction(){

        //Given
        String wordNull= null;

        //When and Then
        assertThatNullPointerException()
                .isThrownBy(()-> palindromoPredicate.reverse(wordNull))
        //        .withMessage(  "Cannot invoke \"String.toCharArray()\" because \"words\" is null")
        ;
    }

    @Test
    public void givenPalindrome_whenIsPalindromor_thenIsTrue(){

        //Given
        String word = "radar";

        //When
        boolean result = palindromoPredicate.isPalindromo(word);

        //Then
        assertThat(result).isTrue();
    }

    @Test
    public void givenNoPalindrome_whenIsPalindromo_thenIsFalse(){

        //Given
        String word = "Paco";

        //When
        boolean result = palindromoPredicate.isPalindromo(word);

        //Then

        assertThat(result).isFalse();
    }

    @Test
    public void givenStringEmpty_whenIsPalindrome_thenIsTrue(){

        //Given
        String emptyWord = "";

        //When

        boolean result = palindromoPredicate.isPalindromo(emptyWord);

        //Then
        assertThat(result).isTrue();

    }

    @Test
    public void givenNull_whenIsPalindrome_thenIsFalse(){

        //Given
        String word = null;

        //When
        boolean result = palindromoPredicate.isPalindromo(word);

        //Then
        assertThat(result).isFalse();

    }
}
