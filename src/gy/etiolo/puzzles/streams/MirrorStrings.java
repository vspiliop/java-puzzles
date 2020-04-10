package gy.etiolo.puzzles.streams;

import java.util.Stack;

/**
 * Copyright (c)2020 DFS Services LLC
 * All rights reserved.
 *
 * @author vspilio
 */
public class MirrorStrings {
  public static void main(String... args) {
    String word = "abccba";
    System.out.println(isMirror(word));
  }

  private static boolean isMirror(String word) {
    if (word.length() % 2 != 0)
      return false;

    Stack<Character> stack = new Stack();

    char[] charArray = word.toCharArray();

    for(int i = 0; i < charArray.length/2; i++) {
      stack.push(charArray[i]);
    }

    for (int i = charArray.length/2; i < charArray.length; i++) {
      if (charArray[i] != stack.pop())
        return false;
    }

    return true;
  }

}
