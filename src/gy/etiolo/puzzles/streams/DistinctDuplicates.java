package gy.etiolo.puzzles.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright (c)2020 DFS Services LLC
 * All rights reserved.
 *
 * @author vspilio
 */
public class DistinctDuplicates {

  public static void main(String ... args) {
    List<Integer> input = Arrays.asList(1, 2, 5, 2, 5, 5, 1, 6, 9);

    Map<Integer, Long> frequencies = input.stream().collect(Collectors.groupingBy(Integer::intValue,
                                                                Collectors.counting()));

    frequencies.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(System.out::println);

  }


}
