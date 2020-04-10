package gy.etiolo.puzzles.streams;

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

    StringBuilder builder = new StringBuilder();

    // for(int i = charArray.length - 1; i >= 0 ; i--) { ... }
    iterate(charArray.length - 1, i -> i - 1).limit(charArray.length).mapToObj(i -> charArray[i])
      .forEach(i -> builder.append(i));

    return builder.toString().equals(word);
  }

}
