package gy.etiolo.puzzles.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

/**
 * Print anagrams together.
 *
 * Using a mask that counts the frequency of each letter of the english alphabet.
 */
public class SortAnagramsV2 {
  public static void main(String... args) {
    List<String> anagrams = Arrays.asList("abc", "er", "cba", "bca", "re", "fdfd", "dfdf");

    Map<String, List<String>> anagramGroups = anagrams.stream().collect(groupingBy(word -> mask(word)));

    anagramGroups.values().stream().flatMap(List::stream).forEach(System.out::print);
  }

  private static String mask(String word) {
    int [] mask = new int[26];
    Arrays.fill(mask, 0);
    word.toLowerCase().chars().forEach(c -> mask['z' - c]++);
    return Arrays.stream(mask).mapToObj(c -> (char) c + "").collect(joining());
  }
}
