package gy.etiolo.puzzles.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Print anagrams together.
 *
 * Using sort for grouping.
 */
public class SortAnagramsV1 {
  public static void main(String... args) {
    List<String> anagrams = Arrays.asList("abc", "er", "cba", "bca", "re", "fdfd", "dfdf");

    Map<String, List<String>> anagramGroups = anagrams.stream().collect(Collectors.groupingBy(word -> sort(word)));

    anagramGroups.values().stream().flatMap(List::stream).forEach(System.out::print);
  }

  private static String sort(String word) {
    char[] toSort = word.toCharArray();
    Arrays.sort(toSort);
    return new String(toSort);
  }

}
