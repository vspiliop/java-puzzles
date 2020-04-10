package gy.etiolo.puzzles.streams;

import java.util.Arrays;

public class CompleteStrings {

    public static void main(String ... args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isComplete(input));
    }

    private static boolean isComplete(String input) {
        int[] frequencies = new int[26];
        input.chars().forEach(c -> frequencies['z' - c]++);
        return Arrays.stream(frequencies).allMatch(f -> f >= 1);
    }
}
