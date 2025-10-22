/**
 * Extracts all positive integer numbers from a given text string and calculates their sum.
 * The method uses a regular expression to split the string based on any non-digit characters.
 * It handles null or empty input safely by returning 0.
 *
 * Example 1:
 * Input: "Pedido 10, costo 200 y descuento 5."
 * Output: 215 (10 + 200 + 5)
 *
 * Example 2:
 * Input: "50 Total 100"
 * Output: 150 (50 + 100)
 *
 * @param text The input string containing mixed characters and numbers.
 * @return The sum of all extracted integer numbers, or 0 if no numbers are found or the input is invalid.
 */

package org.example;

public class StringProcessor {

    public int extractNumbersAndSum(String text) {
        int sumResult = 0;

        // Validation: If the input is null or empty, return 0 as requested by the tests.
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
