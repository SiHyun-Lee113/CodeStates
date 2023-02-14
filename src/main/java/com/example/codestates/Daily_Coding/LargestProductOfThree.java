package com.example.codestates.Daily_Coding;

import java.util.*;
import java.util.stream.Collectors;

public class LargestProductOfThree {
    public static void main(String[] args) {
//        int output = largestProductOfThree(new int[]{-5, -4, -3, -2, -1});
        int output = largestProductOfThree(new int[]{ -50, -20, -30, -5, 40});

        System.out.println(output); // --> 42 (= 2 * 3 * 7)

//        output = largestProductOfThree(new int[]{-1, 2, -5, 7});
//        System.out.println(output);

    }
    public static int largestProductOfThree(int[] arr) {
        List<Integer> list = new ArrayList<>();
        combination(list, arr, 0, 0, new boolean[arr.length], new int[3]);
        System.out.println(list);
        return list.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static void combination(List<Integer> list, int[] arr, int start, int end, boolean[] visited, int[] out) {
        if (end == 3) {
            int mul = Arrays.stream(out).reduce(1, (a, b) -> a * b);
            list.add(mul);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[end] = arr[i];
                combination(list, arr, i, end+1, visited, out);
                visited[i] = false;
            }
        }
    }
}
