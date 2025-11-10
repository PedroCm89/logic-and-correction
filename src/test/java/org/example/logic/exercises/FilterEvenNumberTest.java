package org.example.logic.exercises;

import org.example.logic.exercises.FilterEvenNumber;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterEvenNumberTest {



    @Test
    public void givenList_whenFilter_thenVerifyResult() {

        FilterEvenNumber filterEvenNumber =new FilterEvenNumber();

        //Given
        //dada esta entrada
        List<Integer> lista = List.of(0,1,2,3,4);

        //When
        //cuando ejecuto esto
        List<Integer> result =filterEvenNumber.filter(lista);

        //Then
        // entonces tengo que comprobar
        List<Integer> expected =List.of(0,2,4);

        assertThat(result)
                .containsExactly(0,2,4)
                .containsExactlyElementsOf(expected)
                .contains(2)
        ;
    }

    @Test
    public void givenList_whenFilter_thenUnsortedListIsValid(){

        FilterEvenNumber filterEvenNumber= new FilterEvenNumber();

        // Given
        List<Integer> lista = List.of(0, 1,2,3,4);

        //When
        List<Integer> result =filterEvenNumber.filter(lista);

        //Then
        List<Integer> expected =List.of(2,0,4);

        assertThat(result).isNotEqualTo(expected);
    }

    @Test
    public void givenList_whenFilterWhitStream_thenResultIsExpected (){
        FilterEvenNumber filterEvenNumber= new FilterEvenNumber();

        //Given
        List<Integer> lista = List.of(10,11,12,13,14);

        //When
        List<Integer> result = filterEvenNumber.filterWithStream(lista);

        //Then
        List<Integer> expected = List.of(10,12,14);
        assertThat(result).isNotEmpty()
                .containsExactly(10,12,14)
                .contains(10)
                .containsExactlyElementsOf(expected);
    }

    @Test
    public void givenListEmpty_whenFilterWhitStream_thenResulIsEmptyList(){

        FilterEvenNumber filterEvenNumber = new FilterEvenNumber();

        //Given
        List<Integer> list = new LinkedList<>();

        //When
        List<Integer> expected = filterEvenNumber.filterWithStream(list);

        //Then
        assertThat(expected).isEmpty();

    }



}
