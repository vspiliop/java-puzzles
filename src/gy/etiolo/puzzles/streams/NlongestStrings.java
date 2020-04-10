package gy.etiolo.puzzles.streams;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Copyright (c)2020 DFS Services LLC
 * All rights reserved.
 *
 * @author vspilio
 */
public class NlongestStrings {

  public static void main(String ... args) {
    List<String> input = Arrays.asList("Yuri", "Ron", "Interview", "Longest", "List", "Contain");
    nLongestStrings(input, 3);
  }

  private static void nLongestStrings(List<String> input, int i) {
    TreeMap<Integer, List<String>> collect = input.stream().collect(groupingBy(String::length,
                                                                        TreeMap::new, mapping(w -> w, toList())));

    collect.entrySet().forEach(System.out::println);

    System.out.println(collect.get(collect.descendingKeySet().toArray()[i -1]));
  }
}
