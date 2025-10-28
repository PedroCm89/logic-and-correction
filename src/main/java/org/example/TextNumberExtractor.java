package org.example;

/**
 * Extracts and sums all positive integer numbers found within a given text string.
 * <p>
 * This method implements a highly efficient **O(N) character-by-character** algorithm,
 * relying on state management to identify and parse numbers without using regular expressions.
 * * The logic ensures numbers are correctly extracted even when they are separated by
 * multiple non-digit delimiters or when the string starts or ends with a number.
 * <p>
 * Example 1:
 * Input: "Order 10, total 200 and tax 5."
 * Output: 215 (10 + 200 + 5)
 * <p>
 * Example 2:
 * Input: "123...456"
 * Output: 579 (123 + 456)
 * <p>
 * Text The input string containing mixed characters and numbers.
 *
 * @return The total sum of all extracted integer numbers, or 0 if the input is null, empty, or contains no digits.
 */

public class TextNumberExtractor {

    public int sumNumbersWithoutRegex(String text) {
        StringBuilder concurrentNumber = new StringBuilder();
        char concurrentChar;
        int resultSum = 0;

        if (text == null) {
            return resultSum;
        }

        // Iterate over the string one character at a time.
        for (int i = 0; i < text.length(); i++) {
            concurrentChar = text.charAt(i);

            if (Character.isDigit(concurrentChar)) {
                // STATE 1: Accumulating the number.
                concurrentNumber.append(concurrentChar);

            } else {
                // STATE 2: Delimiter found (non-digit). Time to process the accumulated number.
                if (concurrentNumber.length() > 0) {
                    // 1. Convert the accumulated digits to an integer and add to the sum.
                    // This is where NumberFormatException for overflow is implicitly thrown.
                    String result = concurrentNumber.toString();
                    resultSum += Integer.parseInt(result);

                    // 2. Reset the StringBuilder for the next number.
                    concurrentNumber.setLength(0);
                }
            }
        }

        // CRUCIAL STEP: Final check to process the last number if the string ends with a digit.
        if (concurrentNumber.length() > 0) {
            String result = concurrentNumber.toString();
            resultSum += Integer.parseInt(result);
        }
        return resultSum;
    }
}
