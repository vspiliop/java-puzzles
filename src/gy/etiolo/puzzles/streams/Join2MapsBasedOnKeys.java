package gy.etiolo.puzzles.streams;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class Join2MapsBasedOnKeys {
    public static void main(String ... args) {
        Map<Integer, String> map1 = Map.of(1, "1_1", 2, "1_2", 3, "1_3");
        Map<Integer, String> map2 = Map.of(1, "2_1", 2, "2_2");

        Map<Integer, String> joinedMap = map1.keySet().stream().collect(toMap(Function.identity(),
                                                        e -> Optional.ofNullable(map2.get(e)).orElseGet(() -> map1.get(e))));
        joinedMap.entrySet().stream().forEach(System.out::println);
    }
}
