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

    char[] charArray = word.toCharArray();

    // for(int i = charArray.length - 1; i >= 0 ; i--) { ... }
    String reversed = iterate(charArray.length - 1, i -> i >= 0 , i -> i - 1)
            .mapToObj(i -> charArray[i])
            .map(String::valueOf)
            .collect(joining());

    return reversed.equals(word);
  }

}
