package gy.etiolo.puzzles.streams;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 * Print all pair of two arrays of numbers that their sum is divisible by 3 without using for loops.
 */
public class DoubleLoopStreamsVersion {

  public static void main(String[] args) {
    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

    List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream()
      .filter(j -> (i + j) % 3 == 0)
      .map(j -> new int[] { i, j }))
      .collect(toList());

    pairs.stream().forEach(pair -> System.out.printf("(i=%d, j=%d)\n", pair[0], pair[1]));

  }
}
