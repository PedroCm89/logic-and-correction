package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeSumCalculatorTest {

    PrimeSumaCalculator primeSumaCalculator = new PrimeSumaCalculator();
    @Test
    public void givenValidRange_whenCalculateSum_thenReturnCorrectSum(){

        //Given
        int star = 1;
        int end = 10;

        //When
        int result = primeSumaCalculator.sumPrimeNumbers(star,end);

        //Then
        int expectd = 17;

        assertThat(result).isEqualTo(expectd);
    }

    @Test
    public void givenRangeWithNoPrimes_whenCalculateSum_thenReturnZero(){
        //Given
        int star = 24;
        int end = 28;

        //When
        int result = primeSumaCalculator.sumPrimeNumbers(star,end);

        //Then
        int expectd = 0;

        assertThat(result).isEqualTo(expectd);
    }

    @Test
    public void givenInvertedRange_whenCalculateSum_thenFixAndReturnCorrectSum(){

        //Given
        int star = 10;
        int end = 1;

        //When
        int result = primeSumaCalculator.sumPrimeNumbers(star,end);

        //Then
        int expectd = 17;

        assertThat(result).isEqualTo(expectd);

    }

    @Test
    public void givenSinglePrimeNumber_whenCalculateSum_thenReturnTheNumber(){
        //Given
        int star = 13;
        int end = 13;

        //When
        int result = primeSumaCalculator.sumPrimeNumbers(star,end);

        //Then
        int expectd = 13;

        assertThat(result).isEqualTo(expectd);
    }

    @Test
    public void givenSingleNonPrimeNumber_whenCalculateSum_thenReturnZero(){
        //Given
        int star = 4;
        int end = 4;

        //When
        int result = primeSumaCalculator.sumPrimeNumbers(star,end);

        //Then
        int expectd = 0;

        assertThat(result).isEqualTo(expectd);
    }
}
