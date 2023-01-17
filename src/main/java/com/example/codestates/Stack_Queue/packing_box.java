package com.example.codestates.Stack_Queue;

import java.util.*;

public class packing_box {
    public static void main(String[] args) {
        int[] boxes = new int[]{5, 1, 4, 6, 1, 1, 1, 1};
        int output = paveBox(boxes);
        System.out.println(output); // 3

        int[] boxes2 = new int[]{1, 5, 7, 9};
        int output2 = paveBox(boxes2);
        System.out.println(output2); // 1
    }

    private static int paveBox(int[] boxes) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result_list = new ArrayList<>();
        for (int box : boxes) {
            queue.add(box);
        }

        int first = queue.poll();
        result++;
        for (Integer o : queue) {
            if (first >= o) {
                result++;
            } else {
                result_list.add(result);
                result = 0;
                first = o;
            }
        }
        for (Integer integer : result_list) {
            result = Math.max(integer, result);
        }
        return result;
    }
}
