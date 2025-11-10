/**
 * Extracts all positive integer numbers from a given text string and calculates their sum.
 * The method uses a regular expression to split the string based on any non-digit characters.
 * It handles null or empty input safely by returning 0.
 *
 * Example 1:
 * Input: "Order 10, cost 200 y added 5."
 * Output: 215 (10 + 200 + 5)
 *
 * Only positive numbers are added.
 * If the operator ‘-’ is added in front of a number, it is ignored and read as a positive number.
 * Example 2:
 * Input: "50 discount -100"
 * Output: 150 (50 + 100)
 *
 * @param text The input string containing mixed characters and numbers.
 * @return The sum of all extracted integer numbers, or 0 if no numbers are found or the input is invalid.
 */

package org.example;

public class StringProcessor {

    public int sumNumbersInStringFormat(String text) {
        int sumResult = 0;

        if (text == null || text.isEmpty()) {
            return sumResult;
        }

        // 1. Split the string using any non-digit character (\D+) as a delimiter.
        // This generates an array of strings, which may contain empty strings ("") due to delimiters
        // at the start/end or consecutive delimiters.
        String[] words = text.split("\\D+");

        // 2. Iterate through the resulting parts, filter out empty strings, parse, and sum.
        for (int i = 0; i < words.length; i++) {
            // Filter: Ensure the string is not empty before parsing it to an integer.
            if (!words[i].isEmpty()) {
                // Parse the numerical string part and add it to the total sum.
                sumResult += Integer.parseInt(words[i]);
            }
        }
        return sumResult;
    }

}
