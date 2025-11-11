package org.example.date.structure.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListTest {

    private List list;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setup() {
        list = new List();

        book1 = new Book("Book 1 for test ", "author 1 for test 1", "isbn 1 for test");
        book2 = new Book("Book 2 for test", "author 2 for test", "isbn 2 for test");
        book3 = new Book("Book 3 for test", "author 3 for test", "isbn 3 for test");
    }

    @Test
    public void GivenListIsEmpty_WhenInsertFirst_ThenCheckNodeIsFirst() {
        //Given
        assertThat(list.isEmpty());
        assertThat(list.getLength()).isEqualTo(0);

        //When
        list.insertFirst(book1);


        //Then
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getBookPosition(0)).isEqualTo(book1);


    }

    @Test
    public void GivenListNotEmpty_WhenInsertEnd_ThenCheckNodeIsLast() {
        //Give
        list.insertFirst(book1);
        assertThat(list.isEmpty()).isFalse();

        //When
        list.insertEnd(book3);

        //Then
        assertThat(list.getLength()).isEqualTo(2);
        assertThat(list.getBookPosition(1)).isEqualTo(book3);
    }

    @Test
    public void GivenListEmpty_WhenInsertEnd_ThenInsertFirst() {
        //Given
        assertThat(list.isEmpty());
        assertThat(list.getLength()).isEqualTo(0);

        //When
        list.insertEnd(book1);


        //Then
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getBookPosition(0)).isEqualTo(book1);
    }

    @Test
    public void GivenListNotEmpty_WhenInsertPosition_ThenCheckNodeIsInHerPosition() {
        //Given
        list.insertFirst(book1);
        list.insertEnd(book3);
        assertThat(list.isEmpty()).isFalse();

        //When
        list.insertPosition(1, book2);

        //Then
        assertThat(list.getLength()).isEqualTo(3);
        assertThat(list.getBookPosition(1)).isEqualTo(book2);
        assertThat(list.getBookPosition(2)).isEqualTo(book3);
    }

    @Test
    public void GivenListEmpty_WhenInsertPosition_ThenInsertFirst() {
        //Given
        assertThat(list.isEmpty());
        assertThat(list.getLength()).isEqualTo(0);

        //When
        list.insertPosition(10, book1);


        //Then
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getLength()).isEqualTo(1);
        assertThat(list.getBookPosition(0)).isEqualTo(book1);
    }


    @Test
    public void GivenEmptyList_WhenGetPosition_ThenReturnNullPointerException() {

        //Give empty list
        //When not add nodes
        //Then
        assertThat(list.getBookPosition(0)).isEqualTo(null);

    }

    @Test
    public void GivenFullList_WhenDeleteFirst_ThenDeleteFirst() {
        //Given
        list.insertFirst(book1);
        list.insertEnd(book2);
        list.insertEnd(book3);
        assertThat(list.getLength()).isEqualTo(3);

        //When
        list.delteFirst();

        //Then
        assertThat(list.getLength()).isEqualTo(2);
        assertThat(list.getBookPosition(0)).isEqualTo(book2);

    }

    @Test
    public void GivenFullList_WhenDeleteEnd_ThenDeleteEnd() {
        //Given
        list.insertFirst(book1);
        list.insertEnd(book2);
        list.insertEnd(book3);
        assertThat(list.getLength()).isEqualTo(3);

        //When
        list.deleteEnd();

        //Then
        assertThat(list.getLength()).isEqualTo(2);
        assertThat(list.getBookPosition(2)).isEqualTo(null);

    }

    @Test
    public void GivenFullList_WhenDeleteBookPosition_ThenThisPosition() {
        //Given
        list.insertFirst(book1);
        list.insertEnd(book2);
        list.insertEnd(book3);
        assertThat(list.getLength()).isEqualTo(3);

        //When
        list.deleteBookPsition(1);

        //Then
        assertThat(list.getLength()).isEqualTo(2);
        assertThat(list.getBookPosition(1)).isEqualTo(book3);

    }


}