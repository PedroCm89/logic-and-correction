
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

package org.example;

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
        // This array preserves the original order of characters.
        char[] characters = text.toLowerCase().toCharArray();

        // Use a HashMap to store the frequency (count) of each character.
        Map<Character, Integer> wordText = new HashMap<>();

        // 2. FIRST PASS (O(N)): Count character frequencies.
        for (char c : characters) {
            wordText.put(c, wordText.getOrDefault(c, 0) + 1);
        }

        // 3. SECOND PASS (O(N)): Iterate over the array again to maintain insertion order.
        // The first character found with a frequency of 1 is the answer.
        for (char c : characters) {
            if (wordText.get(c) == 1) {
                nonRepeated = c;
                // Crucial: Stop immediately upon finding the first unique character.
                break;
            }
        }
        return nonRepeated;
    }
}
