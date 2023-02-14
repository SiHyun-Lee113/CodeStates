package com.example.codestates.Daily_Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<String> output1 = powerSet("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output2 = powerSet("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
    }

    public static ArrayList<String> powerSet(String str) {
        ArrayList<String> answer = new ArrayList<>();

        String[] strings = Arrays.stream(str.split("")).sorted().distinct().toArray(String[]::new);

        for (int i = 0; i < strings.length; i++) {
            dfs(answer, strings, new boolean[strings.length], 0, i+1,  new String[strings.length], 0);
        }

        answer.add("");
        Collections.sort(answer);

        return answer;
    }

    private static void dfs(ArrayList<String> answer, String[] strings, boolean[] visited, int depth, int r, String[] out, int start) {
        if (depth == r) {
            String[] strings1 = Arrays.stream(out).filter(Objects::nonNull).toArray(String[]::new);

            String join = String.join("", strings1);
            answer.add(join);
            return;
        }

        for (int i = start; i < strings.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = strings[i];
                dfs(answer, strings, visited, depth+1, r, out, i+1);
                visited[i] = false;
            }
        }
    }
}
