package gy.etiolo.puzzles.streams;

import java.util.Arrays;

/**
 * Are two strings anagrams.
 */
public class Anagrams {
  public static void main(String ... args) {
    String word1 = "abcdefg";
    String word2 = "gfedabc";

    System.out.println("Are they anagrams: " + isAnagram(word1, word2));
  }

  private static boolean isAnagram(String word1, String word2) {
    int [] mask = new int[26];
    Arrays.fill(mask, 0);
    word1.toLowerCase().chars().forEach(c -> mask['z' - c]++);
    word2.toLowerCase().chars().forEach(c -> mask['z' - c]--);
    return Arrays.stream(mask).sum() == 0;
  }
}
