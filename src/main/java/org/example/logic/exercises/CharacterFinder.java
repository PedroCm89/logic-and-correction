
/**
 * Finds and returns the first non-repeated character in a given text string.
 * The check is performed case-insensitively (e.g., 'A' and 'a' count as the same character).
 * This method uses an efficient two-pass algorithm (O(N) time complexity) with a HashMap
 * to count character frequencies and then identify the first unique one in the original order.
 *
 * Example 1 (Simple Unique):
 * Input: "alphabet" (Normalized: "alphabet")
 * Output: 'l'
 *
 * Example 2 (Case Insensitive):
 * Input: "sTreSss" (Normalized: "stresss")
 * Output: 't'
 *
 * Example 3 (All Repeated):
 * Input: "aabbcc"
 * Output: Character.MIN_VALUE (Placeholder for absence)
 *
 * @param text The input string to analyze.
 * @return The first non-repeated character, or Character.MIN_VALUE if none is found or the input is null/empty.
 */

package org.example.logic.exercises;

import java.util.HashMap;
import java.util.Map;

public class CharacterFinder {

    public Character findFirstNonRepeated(String text) {
        // Use Character.MIN_VALUE as the placeholder for 'not found'.
        Character nonRepeated = Character.MIN_VALUE;

        // 1. Handle edge cases: null or empty input.
        if (text == null) {
            return nonRepeated;
        }

        // Prepare the input: convert to lowercase for case-insensitivity and get the character array.
        char[] characters = text.toLowerCase().toCharArray();


        Map<Character, Integer> chartCounters = new HashMap<>();

        // 2.  Count character frequencies.
        for (char c : characters) {
            chartCounters.put(c, chartCounters.getOrDefault(c, 0) + 1);
        }

        // 3. Iterate over the array again to maintain insertion order.
        // The first character found with a frequency of 1 is the answer.
        for (char c : characters) {
            if (chartCounters.get(c) == 1) {
                nonRepeated = c;
                break;
            }
        }
        return nonRepeated;
    }
}
