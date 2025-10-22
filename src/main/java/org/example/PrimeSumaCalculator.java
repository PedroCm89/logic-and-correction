/*
 * Creates a method that takes two positive integers, start and end,
 * and calculates the sum of all prime numbers found within that range
 * (including start and end if they are prime).
 *
 * Additional Requirement: If the start number is greater than the end number,
 * they must be automatically swapped to ensure the range is always valid.
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeSumaCalculator {

    /**
     * Checks if a given number is a prime number.
     * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
     *
     * @param number The integer to check.
     * @return true if the number is prime, false otherwise.
     */
    private boolean isPrime(int number) {
        //Handle edge cases: numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }
        // Optimization: only iterate up to the square root of the number.
        // If a number has a divisor greater than its square root, it must have one less than its square root.
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the sum of all prime numbers within a given range, inclusive.
     * Automatically handles the case where the start is greater than the end.
     *
     * @param start The starting number of the range.
     * @param end   The ending number of the range.
     * @return The total sum of prime numbers in the range.
     */
    public int sumPrimeNumbers(int start, int end) {
        int sumResult = 0;

        // Requirement: Swap start and end if the range is inverted.
        int startRange = (start <= end) ? start : end;
        int endRange = (start <= end) ? end : start;

        // Iterate through the range (inclusive) and sum the prime numbers.
        for (int i = startRange; i <= endRange; i++) {
            if (isPrime(i)) {
                sumResult += i;
            }
        }
        return sumResult;
    }
}
