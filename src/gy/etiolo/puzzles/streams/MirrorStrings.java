package gy.etiolo.puzzles.streams;

import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.iterate;

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

        IntStream.range(0, charArray.length / 2).forEach(i -> stack.push(charArray[i]));

        return iterate(charArray.length / 2, i -> i < charArray.length , i -> i + 1)
                            .allMatch(i -> charArray[i] == stack.pop());
    }

}
