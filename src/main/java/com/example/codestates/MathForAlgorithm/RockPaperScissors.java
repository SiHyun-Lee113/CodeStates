package com.example.codestates.MathForAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class RockPaperScissors {
    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(5);

        for (String[] strings : output) {
            System.out.println(Arrays.toString(strings));
        }
/*
    [
      ["rock", "rock", "rock", "rock", "rock"],
      ["rock", "rock", , "rock", "rock", "paper"],
      ["rock", "rock", , "rock", "rock", "scissors"],
      ["rock", "rock", "rock", "paper", "rock"],
      ["rock", "rock", "rock", "paper", "paper"],
      ["rock", "rock", "rock", "paper", "scissors"],
      ["rock", "rock", "rock", "scissors", "rock"],
      // ...etc ...
    ]
  */
    }
    static String[] RPS = {"rock", "paper", "scissors"};

    private static ArrayList<String[]> rockPaperScissors(int rounds) {

        ArrayList<String[]> list = new ArrayList<>();

        dfs(list, 0, rounds, new String[rounds]);

        return list;
    }

    public static void dfs (ArrayList<String[]> list, int depth, int rounds, String[] output) {
        if (depth == rounds) {
            String[] temp = new String[output.length];
            System.arraycopy(output, 0, temp, 0, output.length);
            list.add(temp);
            return;
        }
        for (int i = 0; i < 3; i++) {
            output[depth] = RPS[i];
            dfs(list, depth+1, rounds, output);
        }
    }
}
