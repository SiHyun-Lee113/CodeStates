package com.example.codestates.Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class find_Path {
    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println("result = " + result);
    }
    static public boolean getDirections(int[][] matrix, int from, int to) {
        // TODO:
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.add(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            System.out.println(queue);

            int search_line = queue.poll();
            if (search_line == to)
                return true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[search_line][i] == 1 && !visited[i]) {
                    matrix[search_line][i] = 0;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }
}
