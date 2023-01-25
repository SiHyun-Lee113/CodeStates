package com.example.codestates.Daily_Coding;

import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) {
        String[] input = new String[]{
                "abcd",
                "123456789",
                "world",
        };
        String output = readVertically(input);
        System.out.println(output);
    }

    private static String readVertically(String[] input) {
        StringBuilder result = new StringBuilder();

        String[][] board = new String[input.length][];

        int max = -1;
        for (int i = 0; i < input.length; i++) {
            board[i] = input[i].split("");
            max = Math.max(max, input[i].length());
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                try {
                    result.append(board[j][i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        return result.toString();
    }
}
