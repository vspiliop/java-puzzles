package gy.etiolo.puzzles.streams;

import static java.util.stream.IntStream.iterate;

import java.util.Stack;

/**
 * Copyright (c)2020 DFS Services LLC
 * All rights reserved.
 *
 * @author vspilio
 */
public class PalindromeStringsStackVersion {
  public static void main(String... args) {
    String word = "abcwwcba";
    System.out.println(isPalindrome(word));
  }

  private static boolean isPalindrome(String word) {

    Stack<Character> stack = new Stack();

    char[] charArray = word.toCharArray();

    iterate(0, i -> i + 1).limit(charArray.length)
      .forEach(i -> stack.push(charArray[i]));

    return iterate(0, i -> i + 1).limit(charArray.length)
      .allMatch(i -> charArray[i] == stack.pop());
  }

}
