package gy.etiolo.puzzles.streams;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.iterate;

/**
 * Copyright (c)2020 DFS Services LLC
 * All rights reserved.
 *
 * @author vspilio
 */
public class PalindromeStringsManualReverseVersion {
  public static void main(String... args) {
    String word = "abcwwcba";
    System.out.println(isPalindrome(word));
  }

  private static boolean isPalindrome(String word) {
    return iterate(word.toCharArray().length - 1, i -> i >= 0 , i -> i - 1)
            .mapToObj(i -> word.toCharArray()[i])
            .map(String::valueOf)
            .collect(joining()).equals(word);
  }

}
