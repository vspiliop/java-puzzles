package gy.etiolo.puzzles.streams;

import java.util.stream.IntStream;

/**
 * Calculate Pythagorean Triples.
 */
public class PythagoreanTriples {

  public static void main(String... args) {
      IntStream.rangeClosed(1, 100).boxed()
               .flatMap(a ->
                 // start from a, not from 1, to void having the same tuple twice
                 IntStream.rangeClosed(a, 100)
                          .mapToObj(b -> new double [] {a, b, Math.sqrt(a*a + b*b)})
                          // keep only natural numbers
                          .filter(tuple -> tuple[2] % 1 == 0)
               )
               .limit(10)
               .forEach(tuple -> System.out.printf("(%d, %d, %d)", (int)tuple[0], (int)tuple[1], (int)tuple[2]));
  }
}
