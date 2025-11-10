package org.example.logic.exercises;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class PalindromoPredicate {

    public String reverse(String words) {

        char[] wordsInCharacter = words.toCharArray();
        char[] reverseWordsInCharacter = new char[words.length()];

        for (int i = wordsInCharacter.length - 1; i >= 0; i--) {

            reverseWordsInCharacter[i] = wordsInCharacter[(wordsInCharacter.length - 1) - i];
        }

        String reverseWord = new String(reverseWordsInCharacter);

        return reverseWord;
    }

    public boolean isPalindromo(String word) {

        if (word == null) {
            return false;
        }
        return word.equals(reverse(word));


//        boolean isPalindromo = false;
//        String reverseWord = reverse(word);
//
//        if (word.equalsIgnoreCase(reverseWord)) {
//            isPalindromo = true;
//        }
//
//
//        return isPalindromo;


//        String reverseWord = reverse(word);
//        boolean isPalindromo= reverseWord.equals(word);
//        return isPalindromo;
//
//        String reverseWord = reverse(word);
//        return reverseWord.equals(word);

    }

}

