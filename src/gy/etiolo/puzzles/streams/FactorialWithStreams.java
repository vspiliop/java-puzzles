package gy.etiolo.puzzles.streams;

import java.util.stream.LongStream;

/**
 * Calculate factorial via using Java streams.
 * <p>
 * e.g. 5! = 5 * 4 * 3 * 2 * 1
 */
public class FactorialWithStreams {
    public static void main(String... args) {
        System.out.println(factorial(0));
    }

    private static long factorial(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (n1, n2) -> n1 * n2);
    }
}
